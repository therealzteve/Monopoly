package actions;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import misc.TextKeys;
import monopoly.Monopoly;
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
		
		//Session Daten abfragen
		long gameId = (long) request.getSession().getAttribute(TextKeys.userGameId);
		int playerId = (int) request.getSession().getAttribute(TextKeys.playerId);
		
		//Spiel in HashMap finden
		HashMap<Long,Monopoly> gameList = (HashMap<Long, Monopoly>) request.getServletContext().getAttribute(TextKeys.gameList);;
		Monopoly monopoly = gameList.get((long)gameId);
		
		
		
		
		
		//User state abfragen
		int userState = monopoly.players.get(playerId).getUserState();
		//Parameter parsen
		
		//Unteraktion finden
		GameBaseAction action = getGameAction(userState,request.getParameter("action"),monopoly, playerId);
		
		
		String result;
		//Wenn action gefunden, action ausfuehren
		if(action != null) {
			 result = action.performAction(request);
		}
		else{
			//Wenn keine action gefunden wurde, fehlerergebnis zurueckgeben
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
	
	protected GameBaseAction getGameAction(int userState, String actionName, Monopoly monopoly,int playerId){
		
		//Spiel starten
		if(userState == -1 && monopoly.players.get(playerId).isAdmin()){
			return new StartGameAction(monopoly, playerId);
		}
		
		//Aufgeben
		if("giveUp".equals(actionName) ){
			return new GiveUpAction(monopoly, playerId);
		}
		
		//Bereit zum wuerfeln oder bauen
		if(userState == 0){
			if(actionName == null || actionName == ""){
				return new WuerfelAction(monopoly , playerId);
			}
			if("build".equals(actionName)){
				return new BuildAction(monopoly, playerId);
			}
		}
		//Zug beenden oder kaufen oder bauen
		if(userState == 1){
			if(actionName == null || actionName == ""){
				return new EndTurnAction(monopoly, playerId);
			}
			if("buy".equals(actionName)){
				return new BuyAction(monopoly, playerId);
			}
			if("build".equals(actionName)){
				return new BuildAction(monopoly, playerId);
			}
		}
		//Zug beenden oder bauen
		if(userState == 2){
			if(actionName == null || actionName == ""){
				return new EndTurnAction(monopoly , playerId);
			}
			if("build".equals(actionName)){
				return new BuildAction(monopoly , playerId);
			}
		}
		return null;
	}

}
