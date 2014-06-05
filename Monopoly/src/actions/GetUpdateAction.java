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
		
		request.setAttribute(TextKeys.myTurn, true);
		
		//Daten bereitstellen (durch player objekt ersetzen)
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
