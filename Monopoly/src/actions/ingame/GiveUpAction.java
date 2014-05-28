package actions.ingame;

import javax.servlet.http.HttpServletRequest;

import actions.GameBaseAction;

public class GiveUpAction extends GameBaseAction {

	@Override
	public String performAction(HttpServletRequest request) {
		return "/json/giveUp.jsp";
	}

}
