package actions;

import java.io.IOException;
import java.util.ArrayList;

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
		ArrayList<Integer> gameList;
		
		//Liste aus Application Scope holen
		Object obj = request.getServletContext().getAttribute(TextKeys.gameList);
		
		//Pruefen ob obj vom Typ ArrayList ist
		if(obj instanceof ArrayList<?>){
			
			//obj zu ArrayList casten
			gameList = (ArrayList<Integer>)obj;
			
			//Pruefen ob Spiel mit ID existiert
			if(gameList.contains(request.getParameter(TextKeys.gameId))){
				
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
