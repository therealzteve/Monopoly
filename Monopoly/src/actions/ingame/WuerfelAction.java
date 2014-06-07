package actions.ingame;

import javax.servlet.http.HttpServletRequest;

import beans.Result;
import misc.TextKeys;
import monopoly.Aktionsfeld;
import monopoly.Feld;
import monopoly.Monopoly;
import monopoly.Spieler;
import monopoly.Street;
import actions.GameBaseAction;

public class WuerfelAction extends GameBaseAction {

	public WuerfelAction(Monopoly monopoly, int playerId) {
		super(monopoly, playerId);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String performAction(HttpServletRequest request) {
		String resultText = "";
		
		//Wuerfeln
		int result = (int) (Math.random() * 12) + 1;


		// get Player
		Spieler p = monopoly.players.get(playerId);

		// change position
		p.addPosition(result);

		// handle position:
		resultText = handlePosition(p, result);

		Result r = new Result();
		r.setSuccess(true);
		r.setMessage("Wuerfelzahl: " + result + "<br>" + resultText);
		r.setEvent("wuerfel");
		request.setAttribute(TextKeys.result, r);
		request.setAttribute("wuerfelzahl", result);

		return "/json/wuerfel.jsp";
	}

	private String handlePosition(Spieler p, int result) {

		// get type of field
		Feld f = monopoly.fields.get(p.getPosition());

		// if Aktionsfeld
		if ("aktion".equals(f.getTyp())) {
			return handleAktion(p, (Aktionsfeld) f, result);
		}

		// if street, werk or bahnhof
		if ("street".equals(f.getTyp()) || "werk".equals(f.getTyp())
				|| "bahnhof".equals(f.getTyp())) {
			return handleStreet(p, (Street) f, f.getTyp(), result);
		}

		// Feld "Los"
		if ("los".equals(f.getTyp())) {
			return handleMisc(p);
		}

		// Wenn nur zu Besuch Gefaengnis
		if ("gefaengnis".equals(f.getTyp())) {
			return handleMisc(p);
		}

		// Wenn frei parken
		if ("freiParken".equals(f.getTyp())) {
			return handleMisc(p);
		}

		// Wenn gehe in das Gefaengnis
		if ("geheGefaengnis".equals(f.getTyp())) {
			return handleMisc(p);
		}

		// Wenn unbekannt
		if (f.getTyp() == null || f.getTyp() == "") {
			System.out.println("Type is null or empty");
			return handleMisc(p);
		}

		return "";
	}

	private String handleAktion(Spieler p, Aktionsfeld a, int wuerfelResult) {
		int currentPosition = p.getPosition();
		String result = a.fuehreKarteAus(p.getId());
		p.setUserState(2);
		// Wenn sich Position geaendert hat, nochmal die aktuelle Position
		// ueberpruefen
		if (currentPosition != p.getPosition()) {
			return result + "<br>" + handlePosition(p, wuerfelResult);
		}
		return result;
	}

	/**
	 * Behandelt noch nicht implementierte Positionsergebnisse
	 * 
	 * @param p
	 * @return
	 */
	private String handleMisc(Spieler p) {
		p.setUserState(2);
		return "Noch zu bearbeiten";
	}

	
	/**
	 * Behandelt das Verhalten, wenn der Spieler auf einer Strasse steht
	 * @param p
	 * @param str
	 * @param type
	 * @param wuerfelzahl
	 * @return
	 */
	private String handleStreet(Spieler p, Street str, String type,
			int wuerfelzahl) {
		String resultText = "";

		// if street
		// Check owner of street
		Spieler owner = str.getOwner();

		if (owner == null) {
			p.setUserState(1);
			// if null change userState to enable buy
			resultText = str.getName() 
					+ " ist noch frei!<br> Kaufpreis: " + str.getPrice();
		} else {
			if (owner.equals(p)) {

				// Change user state to end turn state
				p.setUserState(2);

				resultText = str.getName()
						+ " gehoert dir bereits!";
			} else {

				// Zahlung durchfuehren
				int miete = handlePayment(p, str, wuerfelzahl);

				// Pruefen ob Spieler verloren hat
				checklost(p);

				// Set user state
				p.setUserState(2);

				resultText = str.getName() + " gehoert "
						+ owner.getName() + "<br> Miete: "
						+ miete;

				;
			}
		}
		return resultText;
	}

	
	/**
	 *  Fuehrt die Zahlung durch
	 *  
	 * @param p
	 * @param str
	 * @param wuerfelzahl
	 * @return
	 */
	private int handlePayment(Spieler p, Street str, int wuerfelzahl) {
		int miete = getMietpreis(str, wuerfelzahl);

		p.setGuthaben(p.getGuthaben() - miete);
		str.getOwner().setGuthaben(str.getOwner().getGuthaben() + miete);
		
		return miete;
	}

	private void checklost(Spieler p) {
		// check guthaben of player
		if (p.getGuthaben() < 0) {
			// if minus --> GiveUp

			// Strassen freigeben
			for (Street ownedStreets : p.getOwnedStreets()) {
				ownedStreets.setOwner(null);
			}
			// Guthaben auf 0 setzen
			p.setGuthaben(0);

			// hasLost auf true setzen um Spieler als Verlierer zu kennzeichnen
			p.setHasLost(true);
		}
	}
	
	
	/**
	 *  Ermittelt die Miete eines Spielers anhand der Strasse
	 * @param str
	 * @param wuerfelzahl
	 * @return
	 */
	private int getMietpreis(Street str, int wuerfelzahl){
		int miete = 0;
		if ("street".equals(str.getTyp())) {
			miete = str.getCurrentMiete();
		}
		if ("werk".equals(str.getTyp())) {
			miete = wuerfelzahl * 20;
		}
		if ("bahnhof".equals(str.getTyp())) {
			// Pruefen ob Bestitzer noch mehr Bahnhoefe besitzt
			for (Street street : str.getOwner().getOwnedStreets()) {
				if ("bahnhof".equals(street.getTyp())) {
					miete += 50;
				}
			}
		}
		return miete;
	}
}
