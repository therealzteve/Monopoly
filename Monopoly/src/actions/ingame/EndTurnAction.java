package actions.ingame;

import javax.servlet.http.HttpServletRequest;

import beans.Result;
import misc.TextKeys;
import monopoly.Monopoly;
import actions.GameBaseAction;

public class EndTurnAction extends GameBaseAction {

	public EndTurnAction(Monopoly monopoly) {
		super(monopoly);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String performAction(HttpServletRequest request) {
		
		//get Player
		
		//Change userstate
		
		Result r = new Result();
		r.setSuccess(true);
		r.setMessage("Runde beendet");
		r.setEvent("endTurn");
		request.setAttribute(TextKeys.result,r );
		
		return "/json/standard.jsp";
	}

}
