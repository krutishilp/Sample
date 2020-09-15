package com.zensar.practice.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsertImageJDBC {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConnectionProvider.getConnection();
			if (con != null)
				System.out.println("Database Connected....");
			else
				System.out.println("Database Connection Failed....");
			
			stmt=con.prepareStatement("insert into images(imageName) values(?)");
			//stmt.setString(1,"Sandip-foundation.jpg");
			stmt.setString(1,"IMG-1.jpg");
			int i = stmt.executeUpdate();
			if(i>0) {
				System.out.println("Image Inserted Successfully");
			}
			stmt=con.prepareStatement("insert into images(imageName) values(?)");
			stmt.setString(1,"IMG-2.jpg");
			int j = stmt.executeUpdate();
			if(j>0) {
				System.out.println("Image Inserted Successfully");
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