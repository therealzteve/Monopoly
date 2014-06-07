package init;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import misc.TextKeys;
import monopoly.Monopoly;

public class ApplicationInitializer implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		HashMap<Long,Monopoly> gameList = new HashMap<Long,Monopoly>();
		arg0.getServletContext().setAttribute(TextKeys.gameList, gameList);
		
	}

}
