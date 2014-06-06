package actions.ingame;

import javax.servlet.http.HttpServletRequest;

import beans.Result;
import misc.TextKeys;
import monopoly.Monopoly;
import monopoly.Spieler;
import monopoly.Street;
import actions.GameBaseAction;

public class GiveUpAction extends GameBaseAction {

	public GiveUpAction(Monopoly monopoly,int playerId) {
		super(monopoly, playerId);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String performAction(HttpServletRequest request) {

		//Get Player
		Spieler p  = monopoly.players.get(playerId);
		
		for(Street str : p.getOwnedStreets()){
			str.setOwner(null);
		}
		
		//Spieler auf inaktiv setzen
		 monopoly.players.remove(p);
		 
		
		//Release streets
		
		Result r = new Result();
		r.setSuccess(true);
		r.setMessage("Aufgegeben!");
		r.setEvent("giveUp");
		request.setAttribute(TextKeys.result,r );
		

		return "/json/standard.jsp";
	}

}
