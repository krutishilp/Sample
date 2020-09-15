package com.zensar.ticketmanagement_webapp.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zensar.ticket_management.service.TicketService;
import com.zensar.ticket_management.serviceprovider.TicketServiceProvider;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		TicketService ts = TicketServiceProvider.getService();
		int userId = Integer.parseInt(request.getParameter("userId"));
		String password = request.getParameter("password");
		PrintWriter writer = response.getWriter();
		// RequestDispatcher dispatcher = request.getRequestDispatcher("");
		boolean validateUser = ts.validateUser(userId, password);

		if (validateUser) {
			HttpSession session = request.getSession();
			session.setAttribute("userId", userId);
			request.getRequestDispatcher("welcome.html").forward(request, response);
		} else {
			// dispatcher = request.getRequestDispatcher("error.html");

			response.sendRedirect("error.html");
		}

	}

}
