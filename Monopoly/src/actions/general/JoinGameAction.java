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
import monopoly.Spieler;

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

		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Parameter laden
		long gameId = Long.parseLong(request.getParameter("whichgame"));
		String playerName = request.getParameter("playerName");
		
		//Hashmap laden
		HashMap<Long,Monopoly> gameList = (HashMap<Long, Monopoly>) request.getServletContext().getAttribute(TextKeys.gameList);;
		
		//Entsprechendes Monopoly holen;
		Monopoly monopoly = gameList.get(gameId);
		
		//Spieler anhand Formulardaten erstellen
		Spieler player = new Spieler(monopoly.getNewPlayerId(), playerName, false);
		
		//icon setzen:
		player.setIcon(retrieveColor(monopoly));
	
		//Spieler zu monopoly Spieler Liste hinzufuegen
		monopoly.players.add(player);
		
		//In User Session speichern
		request.getSession().setAttribute(TextKeys.userGameId, gameId);
		request.getSession().setAttribute(TextKeys.playerId, player.getId() );
		
		request.getRequestDispatcher("/boardalt1.html").forward(request, response);
	}

	
	/**
	 * Sucht eine freie Farbe
	 * 
	 * @param monopoly
	 * @return icon Farbname
	 */
	public String retrieveColor(Monopoly monopoly){
		Boolean colorTaken[] = {false,false,false,false};
		
		//Pruefen, welche Farben belegt sind
		for(Spieler pl : monopoly.players){
			if("rot".equals(pl.getIcon())){
				colorTaken[0] = true;
			}
			if("gruen".equals(pl.getIcon())){
				colorTaken[1] = true;
			}
			if("gelbt".equals(pl.getIcon())){
				colorTaken[2] = true;
			}
			if("blau".equals(pl.getIcon())){
				colorTaken[3] = true;
			}
		}
		
		//Freie Farbe ermitteln und zurueck geben
		if(!colorTaken[0]){
			return "rot";
		}
		if(!colorTaken[1]){
			return "gruen";
		}
		if(!colorTaken[2]){
			return "gelb";
		}
		if(!colorTaken[3]){
			return "blau";
		}
		
		return "";
	}
}
