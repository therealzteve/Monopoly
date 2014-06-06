package actions;

import javax.servlet.http.HttpServletRequest;

import misc.TextKeys;
import monopoly.Monopoly;

public abstract class GameBaseAction {

	protected Monopoly monopoly;
	protected int playerId;
	
	
	public GameBaseAction(Monopoly monopoly, int playerId) {
		this.monopoly = monopoly;
		this.playerId = playerId;
	}
	
	public abstract String performAction(HttpServletRequest request);
}
