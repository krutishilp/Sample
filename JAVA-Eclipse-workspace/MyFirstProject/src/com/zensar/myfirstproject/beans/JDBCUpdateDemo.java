package com.zensar.myfirstproject.beans;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCUpdateDemo {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt=null;
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter your Employee ID...");
		int empId=sc.nextInt();
		System.out.println("Please Enter your Updated Salary...");
		int empSalary = sc.nextInt();
		sc.close();
		try {
			con = ConnectionProvider.getConnection();
			String sql = "update employee set empSal=? where empId=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, empSalary);
			pstmt.setInt(2, empId);
			int count = pstmt.executeUpdate();
			if (count > 0) {
				System.out.println("Date Updated Successfully....");
			} else {
				System.out.println("Date Updation Failed....");
			}
			/*
			 * Statement stmt=con.createStatement(); String
			 * sql="insert into employee values(1003,'Krishna',60000)"; //String
			 * sql="delete from employee where empId=1003"; int
			 * count=stmt.executeUpdate(sql); if(count>0) {
			 * System.out.println("Data Inserted Successfully.."); }
			 */
			// ResultSet rs=stmt.executeQuery(sql);

		} catch (SQLException e1) {
			e1.printStackTrace();
		}finally {
			if (pstmt != null) {
				try {
					pstmt.close();
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
