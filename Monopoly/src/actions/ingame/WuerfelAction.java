package actions.ingame;

import javax.servlet.http.HttpServletRequest;

import actions.GameBaseAction;


public class WuerfelAction extends GameBaseAction {

	@Override
	public void performAction(HttpServletRequest request) {
		int result = (int)(Math.random()*12)+1;
		request.setAttribute("wuerfelzahl", result);
		System.out.println("Wuerfeln called!");
		
	}
	

}
