package actions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import misc.TextKeys;
import monopoly.Monopoly;
import monopoly.Spieler;

/**
 * Servlet implementation class GetUpdateAction
 */
@WebServlet("/GetUpdateAction")
public class GetUpdateAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetUpdateAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Session Daten abfragen
		int gameId = (int) request.getSession().getAttribute(TextKeys.userGameId);
		int playerId = (int) request.getSession().getAttribute(TextKeys.playerId);
				
		//Spiel in HashMap finden
		HashMap<Integer,Monopoly> gameList = (HashMap<Integer, Monopoly>) request.getServletContext().getAttribute(TextKeys.gameList);;
		Monopoly monopoly = gameList.get(gameId);
		
		Spieler p = monopoly.players.get(playerId);
		
				
		
		//Daten bereitstellen 
		request.setAttribute(TextKeys.name, p.getName());
		request.setAttribute(TextKeys.guthaben, p.getGuthaben());
		request.setAttribute(TextKeys.position, p.getPosition());
		request.setAttribute(TextKeys.streetOwnList,p.getOwnedStreets().toArray() );
		request.setAttribute(TextKeys.userState, p.getUserState() );
		
		//Andere Spieler Objekte in Request einbinden:
		
		//Auf JSP weiterleiten
		response.setContentType("application/json");
		request.getRequestDispatcher("/json/update.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
