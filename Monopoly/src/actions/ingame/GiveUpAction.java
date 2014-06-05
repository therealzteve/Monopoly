package actions.ingame;

import javax.servlet.http.HttpServletRequest;

import beans.Result;
import misc.TextKeys;
import monopoly.Monopoly;
import actions.GameBaseAction;

public class GiveUpAction extends GameBaseAction {

	public GiveUpAction(Monopoly monopoly) {
		super(monopoly);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String performAction(HttpServletRequest request) {

		//Get Player
		
		//Remove player from game
		
		//Release streets
		
		Result r = new Result();
		r.setSuccess(true);
		r.setMessage("Aufgegeben!");
		r.setEvent("giveUp");
		request.setAttribute(TextKeys.result,r );
		

		return "/json/standard.jsp";
	}

}
