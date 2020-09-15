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

import com.zensar.ticket_management.service.TicketService;
import com.zensar.ticket_management.serviceprovider.TicketServiceProvider;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		TicketService ts = TicketServiceProvider.getService();
		PrintWriter writer = response.getWriter();
		writer.println("<html><head><title>All Orders</title><link rel=\"stylesheet\"\r\n"
				+ "	href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\"\r\n"
				+ "	integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\"\r\n"
				+ "	crossorigin=\"anonymous\"></style></head><body>");
		String userName = request.getParameter("userName");
		long userContact = Long.parseLong(request.getParameter("contactNumber"));
		String userAddress = request.getParameter("address");
		String userPassword = request.getParameter("password");

		int user = ts.registerUser(userName, userContact, userAddress, userPassword);

		if(user>0) {
			writer.println("<h2>Registration Successull, your User Id is "+user+"</h2>");
			writer.println("<a class=\"btn btn-primary\" href=\"index.jsp\">Back to Home</a>");
		}else {
			response.sendRedirect("registerError.html");
		}
		
		writer.print("</body></html>");
	}
}
