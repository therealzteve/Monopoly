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
import monopoly.Street;

/**
 * Servlet implementation class IndexAction
 */
@WebServlet("/IndexAction")
public class IndexAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IndexAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try {
			long gameId = (long) request.getSession().getAttribute(
					TextKeys.userGameId);
			int playerId = (int) request.getSession().getAttribute(
					TextKeys.playerId);

			// Hashmap laden
			HashMap<Long, Monopoly> gameList = (HashMap<Long, Monopoly>) request
					.getServletContext().getAttribute(TextKeys.gameList);

			// Entsprechendes Monopoly holen;
			Monopoly monopoly = gameList.get(gameId);

			//Spieler aufgeben lassen, da er das Spiel verlassen hat
			giveUp(request, monopoly, playerId);

		
			handleEmptyGame(monopoly, gameList, gameId);
			
		} catch (Exception e) {
		}

		request.getRequestDispatcher("/index.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	
	/**
	 *  Lets the player give up
	 * 
	 * @param request
	 * @param monopoly
	 * @param playerId
	 */
	protected void giveUp(HttpServletRequest request ,Monopoly monopoly, int playerId) {
		// Get Player
		Spieler p = monopoly.players.get(playerId);

		for (Street str : p.getOwnedStreets()) {
			str.setOwner(null);
		}
		p.setGuthaben(0);
		p.setHasLost(true);
		
		request.getSession().removeAttribute(TextKeys.userGameId);
		request.getSession().removeAttribute(TextKeys.playerId);
	}
	
	/**
	 *  Checks if there is anyone playing in the game and removes it if empty
	 * 
	 * @param monopoly
	 * @param gameList
	 * @param gameId
	 */
	protected void handleEmptyGame(Monopoly monopoly, HashMap<Long, Monopoly> gameList, long gameId){
		boolean allLeft = true;
		for (Spieler pl : monopoly.players) {
			if (!pl.getHasLost()) {
				allLeft = false;
			}
		}
		if (allLeft) {
			gameList.remove(gameId);
		}
	}
	

}
