package actions;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GameAction
 */
@WebServlet("/GameAction")
public class GameAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GameAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//User state abfragen
		int userState = 0;
		//Parameter parsen
		
		//Unteraktion ausfuehren
		GameBaseAction action = getGameAction(userState);
		action.performAction(request);
		
		//Ergebnis zurueckgeben
		request.getRequestDispatcher("/json/wuerfel.jsp").forward(request, response);
	}
	
	protected GameBaseAction getGameAction(int userState){
		if(userState == 0){
			return new WuerfelAction();
		}
		return null;
	}

}
