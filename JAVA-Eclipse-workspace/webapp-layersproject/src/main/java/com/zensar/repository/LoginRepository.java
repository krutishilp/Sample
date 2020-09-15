package com.zensar.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zensar.jdbc.ConnectionProvider;

public class LoginRepository {
	public boolean isvalid(String userName, String password) {

		Connection con = ConnectionProvider.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			if (con != null)
				System.out.println("Database Connected....");
			else
				System.out.println("Database Connection Failed....");
			String sql = "select * from login where userName=? and password=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userName);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
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
		return false;
	}
}
