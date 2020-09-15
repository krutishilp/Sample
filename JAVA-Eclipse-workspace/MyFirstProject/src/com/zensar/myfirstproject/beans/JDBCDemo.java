package com.zensar.myfirstproject.beans;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {

	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;	
		try {
			con = ConnectionProvider.getConnection();
			
			if (con != null)
				System.out.println("Database Connected....");
			else
				System.out.println("Database Connection Failed....");
			stmt = con.createStatement();
			String sql = "select * from employee";
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3));

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
			
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}

		}

	}

}
