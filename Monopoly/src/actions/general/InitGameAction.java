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
		// TODO Auto-generated method stub
		getServletContext().setAttribute(TextKeys.gameId, 1);
		request.getSession().setAttribute(TextKeys.userGameId, 0);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Monopoly erstellen
		Monopoly monopoly = new Monopoly();
		
		//Spieler anhand Formulardaten erstellen
		Spieler player = new Spieler(0, request.getParameter("usr"), true);
		player.setIcon(request.getParameter("icon"));
		//Spieler zu monopoly Spieler Liste hinzufuegen
		monopoly.players.add(player);
		monopoly.setId(0);
		
		//Spiel in HashMap einfuegen
		HashMap<Long,Monopoly> gameList = (HashMap<Long, Monopoly>) getServletContext().getAttribute(TextKeys.gameList);
		gameList.put((long) 0, monopoly);
		
		//Information in Session speichern
		request.getSession().setAttribute(TextKeys.userGameId, 0);
		request.getSession().setAttribute(TextKeys.playerId, 0);
		
		request.getRequestDispatcher("/boardalt1.html").forward(request, response);
	}

}
