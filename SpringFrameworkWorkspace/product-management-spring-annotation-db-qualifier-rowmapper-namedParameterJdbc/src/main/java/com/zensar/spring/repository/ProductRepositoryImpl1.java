package com.zensar.spring.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.zensar.spring.beans.Product;
@Repository
public class ProductRepositoryImpl1 implements ProductRepository {
	@Autowired
	private JdbcTemplate template;

	@Override
	public int insertProduct(final Product product) {
		int index = 0, productId = 103;
		product.setProductId(productId);
		/*
		 * String sql = "insert into product values(" + product.getProductId() + ",'" +
		 * product.getProductName() + "'," + product.getProductCost() + ");";
		 */
		String sql="insert into product values(?,?,?)";
		template.execute(sql,new PreparedStatementCallback<Product>() {

			@Override
			public Product doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setInt(1, product.getProductId());
				ps.setString(2, product.getProductName());
				ps.setInt(3, product.getProductCost());
				ps.execute();
				return product;
			}
		});
		return product.getProductId();
	}

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public List<Product> getAllProducts() {
		return template.query("select * from product",new ResultSetExtractor<List<Product>>() {

			@Override
			public List<Product> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Product> products=new ArrayList<>();
				while(rs.next()) {
					products.add(new Product(rs.getInt(1),rs.getString(2),rs.getInt(3)));
				}
				return products;
			}
		});
	}

}
