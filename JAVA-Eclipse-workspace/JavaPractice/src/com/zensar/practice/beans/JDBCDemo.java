package com.zensar.practice.beans;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

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
			// stmt = con.createStatement();

			// ************ Working with stored Procedure CallableStatement ****************

			/*
			 * DELIMITER $$
			 * 
			 * DROP PROCEDURE IF EXISTS `javafs`.`getEmpName` $$ CREATE PROCEDURE
			 * `javafs`.`getEmpName` (IN EMP_ID INT, OUT EMP_FIRST VARCHAR(255)) BEGIN
			 * SELECT empName INTO EMP_FIRST FROM employee WHERE empId = EMP_ID; END $$
			 * 
			 * DELIMITER ;
			 * 
			 */

			String SQL = "{call getEmpName (?, ?)}";
			CallableStatement cstmt = con.prepareCall(SQL);
			cstmt.setInt(1, 1008);
			cstmt.registerOutParameter(2, Types.VARCHAR);

			cstmt.execute();

			System.out.println("Name: " + cstmt.getString(2));
			/*
			 * ResultSet set = cstmt.getResultSet(); if(set.next()) {
			 * System.out.println(); }
			 */
			//****************************************************************************************************
			//****************************Statement Batch*********************************
			
			/*
			 * String sql = "select * from employee"; boolean b = stmt.execute(sql);
			 */
			/*
			 * con.setAutoCommit(false);
			 * stmt.addBatch("insert into employee values(1001,'asd',5555)");
			 * stmt.addBatch("insert into employee values(1002,'avds',4855)");
			 * stmt.addBatch("insert into employee values(1003,'ddsd',3885)");
			 * 
			 * stmt.executeBatch(); con.setAutoCommit(true)
			 */;

			/*
			 * rs=stmt.getResultSet(); System.out.println(b);
			 * 
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
