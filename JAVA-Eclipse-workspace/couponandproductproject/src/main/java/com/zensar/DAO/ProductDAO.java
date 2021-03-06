package com.zensar.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.zensar.model.Product;
import com.zensar.util.ConnectionProvider;

public class ProductDAO {
	private Connection con = ConnectionProvider.getConnection();

	public Product createProduct(Product product) {
		try {
			PreparedStatement preparedStatement = con.prepareStatement(
					"insert into products(productName,productDescription,productPrice) values(?,?,?)");
			preparedStatement.setString(1, product.getProductName());
			preparedStatement.setString(2, product.getProductDescription());
			preparedStatement.setBigDecimal(3, product.getProductPrice());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return product;
	}
}
