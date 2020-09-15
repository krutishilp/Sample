package com.zensar.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

	@Override
	public void init(ServletConfig config) throws ServletException {
		/*
		 * this.servletConfig = config;
		 * 
		 * driver = servletConfig.getInitParameter("driver"); url =
		 * servletConfig.getInitParameter("url"); dUserName =
		 * servletConfig.getInitParameter("dUserName"); dPassword =
		 * servletConfig.getInitParameter("dPassword");
		 */

		servletContext = config.getServletContext();
		
		con=(Connection)servletContext.getAttribute("connection");
		/*
		 * driver = servletContext.getInitParameter("driver"); url =
		 * servletContext.getInitParameter("url"); dUserName =
		 * servletContext.getInitParameter("dUserName"); dPassword =
		 * servletContext.getInitParameter("dPassword");
		 */

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * ServletContext servletContext = getServletContext();
		 * 
		 * String driver = servletContext.getInitParameter("driver"); String url =
		 * servletContext.getInitParameter("url"); String dUserName =
		 * servletContext.getInitParameter("dUserName"); String dPassword =
		 * servletContext.getInitParameter("dPassword"); or ServletConfig servletConfig
		 * = getServletConfig();
		 * 
		 * String driver = servletConfig.getInitParameter("driver"); String url =
		 * servletConfig.getInitParameter("url"); String dUserName =
		 * servletConfig.getInitParameter("dUserName"); String dPassword =
		 * servletConfig.getInitParameter("dPassword");
		 */
		System.out.println("inside doPost()");
		
		//Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//String uName = null, pass = null;
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		PrintWriter writer = response.getWriter();

		try {
			/*
			 * Class.forName(driver); con = DriverManager.getConnection(url, dUserName,
			 * dPassword);
			 */
			if (con != null)
				System.out.println("Database Connected....");
			else
				System.out.println("Database Connection Failed....");
			String sql = "select * from login where userName=? and password=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userName);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();

			RequestDispatcher dispatcher = null;

			if (rs.next()) {
				dispatcher = request.getRequestDispatcher("success.html");
				// dispatcher.forward(request, response);
				// dispatcher.include(request, response);
				response.sendRedirect("success.html");
			} else {
				dispatcher = request.getRequestDispatcher("error.html");
				// dispatcher.forward(request, response);
				// dispatcher.include(request, response);
				response.sendRedirect("error.html");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}

			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
		}
	}

}
