package actions.ingame;

import javax.servlet.http.HttpServletRequest;

import beans.Result;
import misc.TextKeys;
import monopoly.Monopoly;
import actions.GameBaseAction;

public class StartGameAction extends GameBaseAction {

	public StartGameAction(Monopoly monopoly, int playerId) {
		super(monopoly, playerId);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String performAction(HttpServletRequest request) {
		monopoly.players.get(playerId).setUserState(0);
		monopoly.isRunning = true;
		
		Result r = new Result();
		r.setSuccess(true);
		r.setMessage("Spiel gestartet");
		r.setEvent("start");
		request.setAttribute(TextKeys.result,r );
		return "/json/standard.jsp";
	}

}
