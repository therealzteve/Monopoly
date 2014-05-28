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
		// TODO Auto-generated method stub
		HashMap<Integer,Integer> gameList;
		
		//Liste aus Application Scope holen
		Object obj = request.getServletContext().getAttribute(TextKeys.gameList);
		
		//Pruefen ob obj vom Typ ArrayList ist
		if(obj instanceof HashMap<?,?>){
			
			//obj zu ArrayList casten
			gameList = (HashMap<Integer,Integer>)obj;
			
			int game = gameList.get(request.getParameter(TextKeys.gameId));
			//Pruefen ob Spiel mit ID existiert
			if(game != 0){
				
				//Game ID in die Session des Users speichern
				request.getSession().setAttribute(TextKeys.userGameId, 1);
				
				//TODO Weiterleitung zur Spiel Logik
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
