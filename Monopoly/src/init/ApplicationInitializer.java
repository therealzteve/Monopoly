package init;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import misc.TextKeys;

public class ApplicationInitializer implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		ArrayList<Integer> gameIdList = new ArrayList<Integer>();
		arg0.getServletContext().setAttribute(TextKeys.gameList, gameIdList);
		
	}

}
