package actions;

import javax.servlet.http.HttpServletRequest;

import monopoly.Monopoly;

public abstract class GameBaseAction {

	protected Monopoly monopoly;
	
	public GameBaseAction(Monopoly monopoly) {
		this.monopoly = monopoly;
	}
	
	public abstract String performAction(HttpServletRequest request);
}
