package actions.general;

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

/**
 * Servlet implementation class JoinGameAction
 */
@WebServlet("/JoinGameAction")
public class JoinGameAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinGameAction() {
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
		
		HashMap<Integer,Monopoly> gameList = (HashMap<Integer, Monopoly>) request.getServletContext().getAttribute(TextKeys.gameList);;
		
		Monopoly monopoly = gameList.get(0);
		
		//Spieler hinzufuegen
		
		//In User Session speichern
		request.getSession().setAttribute(TextKeys.userGameId, 0);
		request.getSession().setAttribute(TextKeys.playerId, 0 );
		
	
	}

}
