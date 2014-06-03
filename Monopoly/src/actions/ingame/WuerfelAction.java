package actions.ingame;

import javax.servlet.http.HttpServletRequest;

import beans.Result;
import misc.TextKeys;
import actions.GameBaseAction;


public class WuerfelAction extends GameBaseAction {

	@Override
	public String performAction(HttpServletRequest request) {
		int result = (int)(Math.random()*12)+1;
		request.setAttribute("wuerfelzahl", result);
		
		
		//get Player
		
		//change position
		
		//handle position:
		
			//get type of field
		
			//if street
				//Check owner of street
		
				//if null change userState to enable buy
		
				//if already owned, transfer amount
		
				//check guthaben of player
					//if minus --> GiveUp
					
					//Remove player from game, release cards
		  
				

		Result r = new Result();
		r.setSuccess(true);
		r.setMessage( "Wuerfelzahl: " + result);
		r.setEvent("wuerfel");
		request.setAttribute(TextKeys.result,r );
		
		return "/json/wuerfel.jsp";
	}
	

}
