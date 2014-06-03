package actions.ingame;

import javax.servlet.http.HttpServletRequest;

import beans.Result;
import misc.TextKeys;
import actions.GameBaseAction;

public class BuildAction extends GameBaseAction {

	@Override
	public String performAction(HttpServletRequest request) {
		
		Result r = new Result();
		r.setSuccess(true);
		r.setMessage("Bau erfolgreich abgeschlossen");
		r.setEvent("build");
		request.setAttribute(TextKeys.result,r );
		return "/json/standard.jsp";
	}

}
