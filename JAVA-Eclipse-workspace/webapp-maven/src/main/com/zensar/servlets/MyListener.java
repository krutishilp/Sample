package com.zensar.servlets;

import java.sql.Connection;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.zensar.jdbc.ConnectionProvider;

/**
 * Application Lifecycle Listener implementation class MyListener
 *
 */
public class MyListener implements ServletContextListener {

    
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent event)  { 
         
    	System.out.println("Inside Listener");
    	ServletContext context = event.getServletContext();
    	String driver=context.getInitParameter("driver");
    	String url=context.getInitParameter("url");
    	String userName=context.getInitParameter("dUserName");
    	String password=context.getInitParameter("dPassword");
    	
    	Connection connection = ConnectionProvider.getDatabaseConnection(driver, url, userName, password);

    	context.setAttribute("connection", connection);
    	
    }
	
}
