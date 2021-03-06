package com.zensar.spring.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zensar.spring.beans.Product;
@Repository
public class ProductRepositoryImpl2 implements ProductRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;
	@Override
	public int insertProduct(Product product) {
		int productId=105;
		product.setProductId(productId);
		String sql="insert into product values(:productId,:productName,:productCost)";
		
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("productId", product.getProductId());
		map.put("productName", product.getProductName());
		map.put("productCost", product.getProductCost());
		template.execute(sql, map, new PreparedStatementCallback<Integer>() {

			@Override
			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				
				return ps.executeUpdate();
			}
		});
		
		return 0;
	}

	@Override
	public List<Product> getAllProducts() {
		return template.query("select * from product", new RowMapper<Product>() {

			@Override
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				return new Product(rs.getInt(1), rs.getString(2),rs.getInt(3));
			}
		});
	}

}
