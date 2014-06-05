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
@WebServlet("/InitGameAction")
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
		request.getSession().setAttribute(TextKeys.userGameId, 1);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Monopoly erstellen
		Monopoly monopoly = new Monopoly();
		
		//Spieler anhand Formulardaten erstellen
		Spieler player = new Spieler(0, "test", true);
		
		//Spiel in HashMap einfuegen
		HashMap<Integer,Monopoly> gameList = (HashMap<Integer, Monopoly>) getServletContext().getAttribute(TextKeys.gameList);
		gameList.put(0, monopoly);
		
		
		request.getSession().setAttribute(TextKeys.userGameId, 1);
		request.getSession().setAttribute(TextKeys.playerId, 1);
	}

}
