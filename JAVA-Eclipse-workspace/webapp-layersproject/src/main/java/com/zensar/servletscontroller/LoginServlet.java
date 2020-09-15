package com.zensar.servletscontroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zensar.service.LoginService;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		PrintWriter writer = response.getWriter();
		LoginService service = new LoginService();
		RequestDispatcher dispatch = null;
		boolean result = service.isvalidUser(userName, password);
		if (result) {
			dispatch = request.getRequestDispatcher("success.html");
			dispatch.forward(request, response);
		} else {
			dispatch = request.getRequestDispatcher("login.html");
			dispatch.include(request, response);
		}
	}

}
