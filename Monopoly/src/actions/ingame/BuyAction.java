package actions.ingame;

import javax.servlet.http.HttpServletRequest;

import beans.Result;
import misc.TextKeys;
import actions.GameBaseAction;

public class BuyAction extends GameBaseAction {

	@Override
	public String performAction(HttpServletRequest request) {

		//get user
		
		//get his position
		
		//check guthaben
		
		//change owner, add to streetOwnList
		
		Result r = new Result();
		r.setSuccess(true);
		r.setMessage("Kauf erfolgreich abgeschlossen");
		r.setEvent("buy");
		request.setAttribute(TextKeys.result,r );
		return "/json/standard.jsp";
	}

}
