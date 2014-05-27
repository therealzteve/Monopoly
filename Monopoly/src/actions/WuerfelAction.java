package actions;

import javax.servlet.http.HttpServletRequest;


public class WuerfelAction extends GameBaseAction {

	@Override
	void performAction(HttpServletRequest request) {
		int result = (int)(Math.random()*12)+1;
		request.setAttribute("wuerfelzahl", result);
		System.out.println("Wuerfeln called!");
		
	}
	

}
