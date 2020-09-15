package com.zensar.session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class NextServlet
 */
public class NextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NextServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		String uName = request.getParameter("userName");
		//String password = request.getParameter("password");
		/*
		 * HttpSession session = request.getSession(); String
		 * uName=(String)session.getAttribute("userName"); String
		 * password=(String)session.getAttribute("password");
		 */
		
	//	response.getWriter().println("<h2>UserName: "+ uName+" Password: "+password+"</h2>");
		
		response.getWriter().println("<h2>User Name:- "+uName+"</h2>");
		
		/*
		 * Cookie[] cookies = request.getCookies();
		 * 
		 * for(Cookie cookie:cookies) {
		 * 
		 * response.getWriter().println("<h2>Cookie Name: "+
		 * cookie.getName()+" Value: "+cookie.getValue()+"</h2>"); }
		 */
		
	}

}
