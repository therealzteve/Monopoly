package actions.general;

import java.io.IOException;
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
 * Servlet implementation class InitGameAction
 */
public class InitGameAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InitGameAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Session Daten abfragen
		long gameId = -1 ;
		
		try{
			gameId = (long) request.getSession().getAttribute(TextKeys.userGameId);
		}catch(Exception e){
			System.out.println("No game found, creating a new one");
		}
		System.out.println(gameId);
		
		//Wenn -1 dann ist kein Spiel in der Session des Nutzers
		if(gameId == -1){
			//Monopoly erstellen
			Monopoly monopoly = new Monopoly();
			monopoly.setId(Monopoly.getGameId());

			//Spieler anhand Formulardaten erstellen
			Spieler player = new Spieler(monopoly.getNewPlayerId(), request.getParameter("usr"), true);
			player.setIcon(request.getParameter("icon"));
			
			//Spieler zu monopoly Spieler Liste hinzufuegen
			monopoly.players.add(player);
			
			//Spiel in HashMap einfuegen
			HashMap<Long,Monopoly> gameList = (HashMap<Long, Monopoly>) getServletContext().getAttribute(TextKeys.gameList);
			gameList.put((long) monopoly.getId(), monopoly);
			
			//Information in Session speichern
			request.getSession().setAttribute(TextKeys.userGameId, (long)monopoly.getId());
			request.getSession().setAttribute(TextKeys.playerId, player.getId());
			
		}
		
		//Zum Spielbrett weiterleiten
		request.getRequestDispatcher("/boardalt1.html").forward(request, response);
	}

}
