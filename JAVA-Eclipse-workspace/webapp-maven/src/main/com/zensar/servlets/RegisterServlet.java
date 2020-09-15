package com.zensar.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServletContext servletContext = getServletContext();

		String driver = servletContext.getInitParameter("driver");
		String url = servletContext.getInitParameter("url");
		String dUserName = servletContext.getInitParameter("dUserName");
		String dPassword = servletContext.getInitParameter("dPassword");

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String[] hobbies = null;
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String fName = request.getParameter("fName");
		String lName = request.getParameter("lName");
		String email = request.getParameter("email");
		String birthDate = request.getParameter("birthDate");
		String gender = request.getParameter("gender");
		String technology = request.getParameter("technology");
		hobbies = request.getParameterValues("hobbies");
		String address = request.getParameter("address");

		System.out.println(technology);

		String hobby = "";
		int row = 0;
		boolean flag = false;
		PrintWriter writer = response.getWriter();
		RequestDispatcher dispatcher = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, dUserName, dPassword);

			pstmt = con.prepareStatement("select userName from login where userName=?");
			pstmt.setString(1, userName);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				flag = true;
				dispatcher = request.getRequestDispatcher("registerError.html");
				dispatcher.forward(request, response);
			} else {
				if (!flag) {
					pstmt = con.prepareStatement("insert into login values(?,?)");
					pstmt.setString(1, userName);
					pstmt.setString(2, password);
					row = pstmt.executeUpdate();

					pstmt = con.prepareStatement(
							"insert into student(firstName,lastName,email,birthDate,gender,technology,address) values(?,?,?,?,?,?,?)");
					pstmt.setString(1, fName);
					pstmt.setString(2, lName);
					pstmt.setString(3, email);
					pstmt.setString(4, birthDate);
					pstmt.setString(5, gender);
					pstmt.setString(6, technology);
					pstmt.setString(7, address);
					row = pstmt.executeUpdate();
					
					pstmt = con.prepareStatement(
							"insert into hobbies values(?,?)");
					if (hobbies != null) {
						for (int i = 0; i < hobbies.length; i++) {
							pstmt.setString(1, userName);
							pstmt.setString(2, hobbies[i]);
							pstmt.executeUpdate();
						}
					}

					if (row > 0) {
						dispatcher = request.getRequestDispatcher("registerSuccess.html");
						dispatcher.forward(request, response);
					}
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
