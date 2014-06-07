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
		int result = (int) (Math.random() * 12) + 1;
		request.setAttribute("wuerfelzahl", result);

		// get Player
		Spieler p = monopoly.players.get(playerId);

		// change position
		p.addPosition(result);
		// handle position:

		// get type of field
		Feld f = monopoly.fields.get(p.getPosition());

		// if Aktionsfeld
		if ("aktion".equals(f.getTyp())) {
			resultText = handleAktion(p, (Aktionsfeld)f) ;
		}

		// if street
		if ("street".equals(f.getTyp())) {
			resultText = handleStreet(p, (Street) f);
		}

		// if werk
		if ("werk".equals(f.getTyp())) {

			resultText = handleWerk(p, (Street) f, result);
		}

		// if bahnhof
		if ("bahnhof".equals(f.getTyp())) {

			resultText = handleBahnhof(p, (Street) f);
		}

		// Wenn unbekannt
		if (f.getTyp() == null) {
			System.out.println("Type is null");
			resultText = handleMisc(p);
		}

		Result r = new Result();
		r.setSuccess(true);
		r.setMessage("Wuerfelzahl: " + result + "<br>" + resultText);
		r.setEvent("wuerfel");
		request.setAttribute(TextKeys.result, r);

		return "/json/wuerfel.jsp";
	}

	private String handleBahnhof(Spieler p, Street str) {
		String resultText = "";

		// Besitzer ermitteln
		Spieler owner = str.getOwner();

		if (owner == null) {
			p.setUserState(1);
			
			// if null change userState to enable buy
			resultText = "Bahnhof ist noch frei!";
		} else {
			if (owner.equals(p)) {

				// Change user state to end turn state
				p.setUserState(2);

				resultText = "Dieser Bahnhof gehoert dir bereits!";
			} else {
				int miete = 0;

				// Pruefen ob Bestitzer noch mehr Bahnhoefe besitzt
				for (Street street : owner.getOwnedStreets()) {
					if ("bahnhof".equals(street.getTyp())) {
						miete += 50;
					}
				}

				// Geld transferieren
				p.setGuthaben(p.getGuthaben() - miete);
				owner.setGuthaben(owner.getGuthaben() + miete);

				// Pruefen ob Spieler verloren hat
				checklost(p);
				// Set user state
				p.setUserState(2);

				resultText = "Dieser Bahnhof gehoert " + owner.getName()
						+ "<br> Miete: " + miete;

				;
			}
		}
		return resultText;
	}

	private String handleWerk(Spieler p, Street str, int wuerfelzahl) {
		String resultText = "";

		// Besitzer ermitteln
		Spieler owner = str.getOwner();

		if (owner == null) {
			p.setUserState(1);
			// if null change userState to enable buy
			resultText = "Werk ist noch frei!";
		} else {
			if (owner.equals(p)) {

				// Change user state to end turn state
				p.setUserState(2);

				resultText = "Dieses Werk gehoert dir bereits!";
			} else {
				int miete = wuerfelzahl * 20;
				p.setGuthaben(p.getGuthaben() - miete);
				owner.setGuthaben(owner.getGuthaben() + miete);

				// Pruefen ob Spieler verloren hat
				checklost(p);

				// Set user state
				p.setUserState(2);

				resultText = "Dieses Werk gehoert " + owner.getName()
						+ "<br> Miete: " + miete;

				;
			}
		}
		return resultText;
	}

	private String handleAktion(Spieler p, Aktionsfeld a) {
		String result = a.fuehreKarteAus(p.getId());
		p.setUserState(2);
		return result;
	}

	private String handleMisc(Spieler p) {
		p.setUserState(2);
		return "Noch zu bearbeiten";
	}

	private String handleStreet(Spieler p, Street str) {
		String resultText = "";

		// if street
		// Check owner of street
		Spieler owner = str.getOwner();

		if (owner == null) {
			p.setUserState(1);
			// if null change userState to enable buy
			resultText = "Strasse ist noch frei!";
		} else {
			if (owner.equals(p)) {

				// Change user state to end turn state
				p.setUserState(2);

				resultText = "Diese Strasse gehoert dir bereits!";
			} else {
				p.setGuthaben(p.getGuthaben() - str.getCurrentMiete());
				owner.setGuthaben(owner.getGuthaben() + str.getCurrentMiete());

				// Pruefen ob Spieler verloren hat
				checklost(p);

				// Set user state
				p.setUserState(2);

				resultText = "Diese Strasse gehoert " + owner.getName()
						+ "<br> Miete: " + str.getCurrentMiete();

				;
			}
		}
		return resultText;
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
}
