package actions.ingame;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import beans.Result;
import misc.TextKeys;
import monopoly.Monopoly;
import monopoly.Spieler;
import monopoly.Street;
import actions.GameBaseAction;

public class EndTurnAction extends GameBaseAction {

	public EndTurnAction(Monopoly monopoly , int playerId) {
		super(monopoly ,playerId);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String performAction(HttpServletRequest request) {
		
		//get Player
		Spieler p = monopoly.players.get(playerId);
		//Change userstate
		p.setUserState(-1);
		
		Result r = new Result();
		r.setSuccess(true);
		r.setMessage("Runde beendet");
		r.setEvent("endTurn");
		request.setAttribute(TextKeys.result,r );
		
		return "/json/standard.jsp";
	}

}
