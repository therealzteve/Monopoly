package actions.ingame;

import javax.servlet.http.HttpServletRequest;

import beans.Result;
import misc.TextKeys;
import actions.GameBaseAction;

public class BuildAction extends GameBaseAction {

	@Override
	public String performAction(HttpServletRequest request) {
		
		int streetId = Integer.parseInt(request.getParameter(TextKeys.streetId));
		int buildAmount = Integer.parseInt(request.getParameter(TextKeys.buildAmount));
		
		//Find street
		
		//(Check owner)
		
		//increase Build amount
		
		
		Result r = new Result();
		r.setSuccess(true);
		r.setMessage("Bau erfolgreich abgeschlossen");
		r.setEvent("build");
		request.setAttribute(TextKeys.result,r );
		return "/json/standard.jsp";
	}

}
