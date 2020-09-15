package com.zensar.practice.beans;

import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class RetriveImageJDDBC {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		BufferedImage image = null;
		int width = 963; // width of the image
		int height = 640;
		try {
			con = ConnectionProvider.getConnection();
			if (con != null)
				System.out.println("Database Connected....");
			else
				System.out.println("Database Connection Failed....");

			Scanner sc=new Scanner(System.in);
			
			System.out.println("Please Enter Image Id:- ");
			int imageId=sc.nextInt();
			stmt = con.prepareStatement("select imageName from images where imageId=?");
			stmt.setInt(1, imageId);
			rs = stmt.executeQuery();
			if (rs.next()) {
				String imageName = rs.getString(1);

				File file = new File(imageName);

				//image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
				image = ImageIO.read(file);

				System.out.println("Reading complete.");
			}

			File outfile = new File("./outImage.jpg");

			// Writing to file taking type and path as
			ImageIO.write(image, "jpg", outfile);

			System.out.println("Writing complete.");

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
