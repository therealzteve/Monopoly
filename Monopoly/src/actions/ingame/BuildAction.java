package actions.ingame;

import javax.servlet.http.HttpServletRequest;

import actions.GameBaseAction;

public class BuildAction extends GameBaseAction {

	@Override
	public String performAction(HttpServletRequest request) {
		return "/json/build.jsp";
	}

}
