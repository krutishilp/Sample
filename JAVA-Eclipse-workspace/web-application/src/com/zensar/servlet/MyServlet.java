package com.zensar.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zensar.connection.ConnectionProvider;

public class MyServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		
		Enumeration<String> headerNames = req.getHeaderNames();
		while(headerNames.hasMoreElements()) {
			String header = headerNames.nextElement();
			writer.println(header+"::"+ req.getHeader(header)) ;
		}
		
		
		writer.println("<html>");
		writer.println("<body>");
		writer.println("<h1>Hello World !!!</h1>");
		writer.println("</body>");
		writer.println("</html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String uName = null,pass = null;
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");
		PrintWriter writer = resp.getWriter();
		
		con = ConnectionProvider.getConnection();
		
		System.out.println("*************************************************************");
		if (con != null)
			System.out.println("Database Connected....");
		else
			System.out.println("Database Connection Failed....");
		try {
			String sql = "select * from login where userName=? and password=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userName);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				writer.println("<h1>Welcome, Authentication Successful</h1>");
			}else {
				writer.println("<h1>Sorry,Authentication Failed</h1>");
			}
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(rs!=null)
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(pstmt!=null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
		}
		
	}

	
}
