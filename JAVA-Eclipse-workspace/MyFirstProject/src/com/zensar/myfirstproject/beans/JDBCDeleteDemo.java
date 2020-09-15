package com.zensar.myfirstproject.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCDeleteDemo {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter Employee ID...");
		int empId = sc.nextInt();
		sc.close();
		try {
			con = ConnectionProvider.getConnection();
			String sql = "delete from employee where empId=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, empId);
			int count = pstmt.executeUpdate();
			if (count > 0) {
				System.out.println("Date Deleted Successfully....");
			} else {
				System.out.println("Date Deletion Failed....");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	}
}
