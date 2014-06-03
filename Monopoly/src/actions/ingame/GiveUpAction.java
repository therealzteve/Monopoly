package actions.ingame;

import javax.servlet.http.HttpServletRequest;

import beans.Result;
import misc.TextKeys;
import actions.GameBaseAction;

public class GiveUpAction extends GameBaseAction {

	@Override
	public String performAction(HttpServletRequest request) {

		Result r = new Result();
		r.setSuccess(true);
		r.setMessage("Aufgegeben!");
		r.setEvent("giveUp");
		request.setAttribute(TextKeys.result,r );
		

		return "/json/standard.jsp";
	}

}
