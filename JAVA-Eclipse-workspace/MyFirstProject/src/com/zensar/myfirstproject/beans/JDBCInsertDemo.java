package com.zensar.myfirstproject.beans;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.PreparedStatement;

public class JDBCInsertDemo {
	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement pstmt=null;
	
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Please Enter your Employee Id...");
		int empId=sc.nextInt();
		
		System.out.println("Please Enter your Name...");
		String empName=sc.next();
		
		System.out.println("Please Enter your Salary...");
		int empSalary=sc.nextInt();
		
		sc.close();
		
		try {
			
			con=ConnectionProvider.getConnection();
			
			String sql="insert into employee values(?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, empId);
			pstmt.setString(2, empName);
			pstmt.setInt(3, empSalary);
		
			int count=pstmt.executeUpdate();
			
			if(count>0) {
				System.out.println("Date Inserted Successfully....");
			}else {
				System.out.println("Date Insertion Failed....");
			}
			/*
			 * Statement stmt=con.createStatement(); String
			 * sql="insert into employee values(1003,'Krishna',60000)"; //String
			 * sql="delete from employee where empId=1003"; int
			 * count=stmt.executeUpdate(sql); if(count>0) {
			 * System.out.println("Data Inserted Successfully.."); }
			 */
			//ResultSet rs=stmt.executeQuery(sql);
			
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
