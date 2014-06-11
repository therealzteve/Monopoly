package actions.ingame;

import javax.servlet.http.HttpServletRequest;

import beans.Result;
import misc.TextKeys;
import monopoly.Feld;
import monopoly.Monopoly;
import monopoly.Spieler;
import monopoly.Street;
import actions.GameBaseAction;

public class BuyAction extends GameBaseAction {

	public BuyAction(Monopoly monopoly, int playerId) {
		super(monopoly , playerId);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String performAction(HttpServletRequest request) {

		//get player
		Spieler p = monopoly.players.get(playerId);
		
		//get his position
		int position = p.getPosition();
		
		//check guthaben
		
		//Strasse ermitteln
		Street str = (Street)monopoly.fields.get(position);
		
		//Kauf taetigen:
		p.setGuthaben(p.getGuthaben()- str.getPrice());
		
		//TODO: Abpruefen ob User genug Geld hat
		
		//Eigentuemer wechseln
		str.setOwner(p);
		
		//strasse zur Liste des Spielers hinzufuegen
		p.getOwnedStreets().add(str);
		
		
		
		Result r = new Result();
		r.setSuccess(true);
		r.setMessage("Kauf erfolgreich abgeschlossen");
		r.setEvent("buy");
		request.setAttribute(TextKeys.result,r );
		return "/json/standard.jsp";
	}

}
