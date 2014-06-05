package actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import misc.TextKeys;
import beans.Result;
import actions.ingame.*;

/**
 * Servlet implementation class GameAction
 */
@WebServlet("/GameAction")
public class GameAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GameAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Spiel Objekt finden
		System.out.println(getServletContext().getAttribute("GameID"));
		//User state abfragen
		int userState = 0;
		//Parameter parsen
		
		//Unteraktion ausfuehren
		GameBaseAction action = getGameAction(userState,request.getParameter("action"));
		String result;
		if(action != null) {
			 result = action.performAction(request);
		}
		else{
			Result r = new Result();
			r.setSuccess(false);
			r.setMessage("Aktion nicht erlaubt");
			r.setEvent("illegalCommand");
			request.setAttribute(TextKeys.result,r );
			result = "/json/standard.jsp";
		}
		
		//Ergebnis zurueckgeben
		request.getRequestDispatcher(result).forward(request, response);
	}
	
	protected GameBaseAction getGameAction(int userState, String actionName){
		System.out.println("ActionName: "+actionName);
		System.out.println("userState: " + userState);
		if(userState == 0){
			if(actionName == null || actionName == ""){
				return new WuerfelAction();
			}
			if("build".equals(actionName)){
				return new BuildAction();
			}
		}
		if(userState == 1){
			if(actionName == null || actionName == ""){
				return new EndTurnAction();
			}
			if(actionName == "buy"){
				return new BuyAction();
			}
			if(actionName == "build"){
				return new BuildAction();
			}
		}
		if(userState == 2){
			if(actionName == null || actionName == ""){
				return new EndTurnAction();
			}
			if(actionName == "build"){
				return new BuildAction();
			}
		}
		return null;
	}

}
