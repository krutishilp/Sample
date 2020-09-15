package com.zensar.myfirstproject.beans;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ScrollableAndUpdatableExample {
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
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			String sql = "select * from employee";
			rs = stmt.executeQuery(sql);
			System.out.println("Forword ResultSet");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3));
			}

			System.out.println("Reverse ResultSet");
			rs.afterLast();
			while (rs.previous()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3));
			}

			System.out.println("Update ResultSet");
			rs.absolute(2);
			rs.updateString("empName", "11111111");
			rs.rowUpdated();

			System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3));

			System.out.println("First:");
			rs.first();
			System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3));

			System.out.println("Last");
			rs.last();
			System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3));

			/*
			 * while (rs.next()) { System.out.println(rs.getInt(1) + " " + rs.getString(2) +
			 * " " + rs.getInt(3));
			 * 
			 * }
			 */

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
