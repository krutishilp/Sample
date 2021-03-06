package com.zensar.productmanagement.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.zensar.productmanagement.beans.Product;
import com.zensar.productmanagement.beans.User;
import com.zensar.productmanagement.exceptions.ProductNotFoundException;
import com.zensar.productmanagement.jdbc.ConnectionProvider;

public class ProductRepositoryImpl implements ProductRepository {
	private Connection con = ConnectionProvider.getConnection();
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	public int insertProduct(Product productObj,int userId) {

		Random rand = new Random();
		productObj.setProductId(rand.nextInt(100));
		try {
			pstmt = con.prepareStatement("insert into products(productId,productName,productCost,userId) values(?,?,?,?)");
			pstmt.setInt(1, productObj.getProductId());
			pstmt.setString(2, productObj.getProductName());
			pstmt.setInt(3, productObj.getProductCost());
			pstmt.setInt(4, userId);
			int update = pstmt.executeUpdate();
			if (update > 0) {
				return productObj.getProductId();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return productObj.getProductId();
		
	}

	public Product[] getAllProducts(int userId) {
		List<Product> list = new ArrayList<Product>();

		try {
			pstmt = con.prepareStatement("select * from products where userId=?");
			pstmt.setInt(1, userId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1),rs.getString(2),rs.getInt(3)));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Product[] product = new Product[list.size()];
		product = list.toArray(product);
		return product;
	}

	public Product getProduct(int productId,int userId) throws ProductNotFoundException {
		Product product = null;
		try {
			pstmt = con.prepareStatement("select * from products where productId=? and userId=?");
			pstmt.setInt(1, productId);
			pstmt.setInt(2, userId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				product = new Product(rs.getInt(1),rs.getString(2),rs.getInt(3));
				return product;
			} else {
				throw new ProductNotFoundException("Product Not Found");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return product;
		
	}

	public boolean deleteProduct(int productId,int userId) throws ProductNotFoundException {
		try {
			pstmt = con.prepareStatement("delete from products where productId=? and userId=?");
			pstmt.setInt(1, productId);
			pstmt.setInt(2, userId);
			int ch = pstmt.executeUpdate();
			if (ch > 0) {
				return true;
			} else {
				throw new ProductNotFoundException("Product Not Found");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean validateUser(int userId, String userPassword) {
		try {
			pstmt = con.prepareStatement("select userId,password from login where userId=? and password=?");
			pstmt.setInt(1, userId);
			pstmt.setString(2, userPassword);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	public int registerUser(User user, String userPassword) {
		Random rand = new Random();
		user.setUserId(rand.nextInt(100));

		try {
			pstmt = con.prepareStatement("insert into login(userId,userName,password) values(?,?,?)");
			pstmt.setInt(1, user.getUserId());
			pstmt.setString(2, user.getUserName());
			pstmt.setString(3, userPassword);
			pstmt.executeUpdate();
			pstmt = con.prepareStatement("insert into user(userId,userName,userContact,userAddress) values(?,?,?,?)");
			pstmt.setInt(1, user.getUserId());
			pstmt.setString(2, user.getUserName());
			pstmt.setLong(3, user.getUserContact());
			pstmt.setString(4, user.getUserAddress());
			int update = pstmt.executeUpdate();
			if(update>0) {
				return user.getUserId();
			}else {
				return 0;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return user.getUserId();

	}
	
	@Override
	protected void finalize() throws Throwable {

		super.finalize();
		if (rs != null) {
			rs.close();
		}
		if (pstmt != null) {
			pstmt.close();
		}
		if (con != null) {
			con.close();
		}
	}

}
