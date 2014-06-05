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
		
		//Daten aus Session laden
		int gameId = (int) request.getSession().getAttribute(TextKeys.userGameId);
		int playerId = (int) request.getSession().getAttribute(TextKeys.playerId);
				
		//Monopoly Objekt aus HashMap holen
		HashMap<Integer,Monopoly> gameList = (HashMap<Integer, Monopoly>) request.getServletContext().getAttribute(TextKeys.gameList);;
		Monopoly monopoly = gameList.get(gameId);
		
		
		//Daten bereitstellen (durch player objekt ersetzen)
		request.setAttribute(TextKeys.myTurn, true);
		String[] streets = {"test1","test2","test3"}; //Test, kommt noch raus
		request.setAttribute(TextKeys.name, "Testname");
		request.setAttribute(TextKeys.guthaben, 2000);
		request.setAttribute(TextKeys.position, 1);
		request.setAttribute(TextKeys.streetOwnList,streets );
		request.setAttribute(TextKeys.userState,0 );
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
