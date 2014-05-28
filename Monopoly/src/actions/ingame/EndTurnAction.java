package actions.ingame;

import javax.servlet.http.HttpServletRequest;

import actions.GameBaseAction;

public class EndTurnAction extends GameBaseAction {

	@Override
	public String performAction(HttpServletRequest request) {
		return "/json/endTurn.jsp";
	}

}
