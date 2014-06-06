package actions.ingame;

import javax.servlet.http.HttpServletRequest;

import beans.Result;
import misc.TextKeys;
import monopoly.Feld;
import monopoly.Monopoly;
import monopoly.Spieler;
import monopoly.Street;
import actions.GameBaseAction;


public class WuerfelAction extends GameBaseAction {

	public WuerfelAction(Monopoly monopoly ,int  playerId) {
		super(monopoly, playerId);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String performAction(HttpServletRequest request) {
		int result = (int)(Math.random()*12)+1;
		request.setAttribute("wuerfelzahl", result);
		
		
		//get Player
		Spieler p = monopoly.players.get(playerId);
		
		//change position
		p.setPosition(result);
		//handle position:
		
			//get type of field
			Feld f = monopoly.fields.get(p.getPosition());
		
			//if Aktionsfeld
			if("aktion".equals(f.getTyp()) ){
				handleAktion(p);
			}else{
				handleStreet(p, (Street) f);
			}
		

		Result r = new Result();
		r.setSuccess(true);
		r.setMessage( "Wuerfelzahl: " + result);
		r.setEvent("wuerfel");
		request.setAttribute(TextKeys.result,r );
		
		return "/json/wuerfel.jsp";
	}
	

	private void handleAktion(Spieler p ){
		
	}
	
	private void handleStreet(Spieler p, Street str){
		//if street
		//Check owner of street
		Spieler owner = str.getOwner();
		
		if(owner == null){
			p.setUserState(1);
			//if null change userState to enable buy
		}else{
			if(owner.equals(p)){
				p.setUserState(2);
				//Change user state to end turn state
			}else{
				p.setGuthaben(p.getGuthaben() - str.getCurrentMiete());
				owner.setGuthaben(owner.getGuthaben() + str.getCurrentMiete());
				
				//check guthaben of player
				//if minus --> GiveUp
				
				//Remove player from game, release cards
				
				//Set user state
				p.setUserState(2);
			}
		}
	}
}
