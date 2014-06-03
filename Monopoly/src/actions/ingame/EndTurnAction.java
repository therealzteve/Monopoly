package actions.ingame;

import javax.servlet.http.HttpServletRequest;

import beans.Result;
import misc.TextKeys;
import actions.GameBaseAction;

public class EndTurnAction extends GameBaseAction {

	@Override
	public String performAction(HttpServletRequest request) {
		
		Result r = new Result();
		r.setSuccess(true);
		r.setMessage("Runde beendet");
		r.setEvent("endTurn");
		request.setAttribute(TextKeys.result,r );
		
		return "/json/standard.jsp";
	}

}
