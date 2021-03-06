package com.zensar.productmanagement.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zensar.productmanagement.service.ProductService;
import com.zensar.productmanagement.serviceprovider.ServiceProvider;



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

		ProductService ts = ServiceProvider.provideService();
		int userId = Integer.parseInt(request.getParameter("userId"));
		String password = request.getParameter("password");
		PrintWriter writer = response.getWriter();
		// RequestDispatcher dispatcher = request.getRequestDispatcher("");
		boolean validateUser = ts.validateUser(userId, password);
		HttpSession session = request.getSession();
		if (validateUser) {
			session.setAttribute("userId", userId);
			request.getRequestDispatcher("welcome.html").forward(request, response);
		} else {
			// dispatcher = request.getRequestDispatcher("error.html");

			response.sendRedirect("error.html");
		}

	}

}
