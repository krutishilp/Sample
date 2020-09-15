package com.zensar.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// ServletConfig servletConfig=null;
	ServletContext servletContext = null;
	String driver = null;
	String url = null;
	String dUserName = null;
	String dPassword = null;
	Connection con=null;

	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		PrintWriter writer = response.getWriter();
		/*
		 * //1.HttpSession HttpSession session=request.getSession();
		 * session.setAttribute("userName", userName); session.setAttribute("password",
		 * password);
		 */
		response.setContentType("text/html");
		
		/*
		 * //2.Cookies Cookie cookie1=new Cookie("userName", userName); Cookie
		 * cookie2=new Cookie("password", password); cookie1.setMaxAge(10000);
		 * cookie2.setMaxAge(10000);
		 * 
		 * response.addCookie(cookie1); response.addCookie(cookie2);
		 */	
		if(userName.equals("zensar") && password.equals("zensar")) {
			writer.println("<h2>Hello "+userName);
			//writer.println("<a href='next'>Click here to know more</a></h2>");
		
			//3.Url Rewriting
			//	writer.println("<a href='next?userName="+userName+"&password="+password+"'>Click here to know more</a></h2>");
			
			
			//4.Hidden Form 
			writer.println("<form action='next'>");
			writer.println("<input type='hidden' name='userName' value="+userName+">");
			writer.println("<input type='submit' value='Want to Know More'></form>");
		}
		
	}

}
