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
import monopoly.Feld;
import monopoly.Monopoly;
import monopoly.Spieler;
import monopoly.Street;

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
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		long gameId = -1;
		// Session Daten abfragen, wenn null, session abgelaufen
		try {
			gameId = (long) request.getSession().getAttribute(
					TextKeys.userGameId);

			int playerId = (int) request.getSession().getAttribute(
					TextKeys.playerId);

			System.out.println("Update from playerId: " + playerId);

			// Spiel in HashMap finden
			HashMap<Long, Monopoly> gameList = (HashMap<Long, Monopoly>) request
					.getServletContext().getAttribute(TextKeys.gameList);
			Monopoly monopoly = gameList.get(gameId);

			//If monopoly is null there is a game in the user session which does 
			//not exist anymore. Clean session and throw exception
			if(monopoly == null){
				request.getSession().removeAttribute(TextKeys.userGameId);
				request.getSession().removeAttribute(TextKeys.playerId);
				throw new Exception();
			}
			
			Spieler p = monopoly.players.get(playerId);

			// Daten bereitstellen
			request.setAttribute(TextKeys.id, p.getId());
			request.setAttribute(TextKeys.name, p.getName());
			request.setAttribute(TextKeys.guthaben, p.getGuthaben());
			request.setAttribute(TextKeys.position, p.getPosition());
			request.setAttribute(TextKeys.icon, p.getIcon());
			request.setAttribute(TextKeys.streetOwnList, p.getOwnedStreets()
					.toArray());
			request.setAttribute(TextKeys.userState, p.getUserState());
			request.setAttribute(TextKeys.isAdmin, p.isAdmin());
			request.setAttribute(TextKeys.hasLost, p.getHasLost());
			request.setAttribute(TextKeys.hasWon, p.isHasWon());
			request.setAttribute(TextKeys.isRunning, monopoly.isRunning);

			ArrayList<Street> streets = new ArrayList<Street>();
			ArrayList<Feld> fields = new ArrayList<Feld>();
			for (Feld f : monopoly.getFields()) {
				if ("street".equals(f.getTyp()) || "bahhof".equals(f.getTyp())
						|| "werk".equals(f.getTyp())) {
					streets.add((Street) f);
				} else {
					fields.add(f);
				}
			}
			request.setAttribute(TextKeys.streets, streets);
			request.setAttribute(TextKeys.fields, fields);

			// Andere Spieler Objekte in Request einbinden:
			ArrayList<Spieler> otherPlayers = new ArrayList<Spieler>();
			for (Spieler pl : monopoly.players) {
				if (pl.getId() != p.getId()) {
					otherPlayers.add(pl);
				}
			}
			request.setAttribute(TextKeys.otherPlayers, otherPlayers);

			// Auf JSP weiterleiten
			response.setContentType("application/json");
			request.getRequestDispatcher("/json/update.jsp").forward(request,
					response);
		} catch (Exception e) {
			System.out.println("Session lost!");
			request.getSession().removeAttribute(TextKeys.userGameId);
			request.getSession().removeAttribute(TextKeys.playerId);
			// Auf JSP weiterleiten
			response.setContentType("application/json");
			request.getRequestDispatcher("/json/sessionLost.jsp").forward(
					request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
