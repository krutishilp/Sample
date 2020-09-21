package com.zensar.spring.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zensar.spring.model.Product;

@Repository
public class ProductRepositoryImpl2 implements ProductRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	public Product getProduct(int productId) {
		String sql = "select * from product where productId=" + productId + ";";

		return template.query(sql, new ResultSetExtractor<Product>() {

			public Product extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					Product product = new Product(rs.getInt(1), rs.getString(2), rs.getInt(3));
					return product;
				}
				return null;

			}
		});
	}

	public boolean deleteProduct(int productId) {
		String sql = "delete from product where productId=:productId";

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("productId", productId);

		return template.execute(sql, map, new PreparedStatementCallback<Boolean>() {

			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				int rs = ps.executeUpdate();
				if (rs > 0) {
					return true;
				} else {
					return false;
				}
			}
		});
	}

	public boolean updateProduct(Product product) {
		String sql = "update product set productName=:productName,productCost=:productCost where productId=:productId";

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("productName", product.getProductName());
		map.put("productCost", product.getProductCost());
		map.put("productId", product.getProductId());
		return template.execute(sql, map, new PreparedStatementCallback<Boolean>() {

			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {

				int rs = ps.executeUpdate();
				if (rs > 0) {
					return true;
				} else {
					return false;
				}
			}
		});

	}

	public int insertProduct(Product product) {
		Random rand = new Random();
		int productId = rand.nextInt(1000);
		product.setProductId(productId);
		String sql = "insert into product values(:productId,:productName,:productCost)";

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("productId", product.getProductId());
		map.put("productName", product.getProductName());
		map.put("productCost", product.getProductCost());
		Integer result = template.execute(sql, map, new PreparedStatementCallback<Integer>() {

			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {

				return ps.executeUpdate();
			}
		});
		if (result > 0) {
			return product.getProductId();
		} else {
			return 0;
		}

	}

	public Product[] getAllProducts() {
		return template.query("select * from product", new ResultSetExtractor<Product[]>() {
			List<Product> products = new ArrayList<Product>();

			public Product[] extractData(ResultSet rs) throws SQLException, DataAccessException {
				while (rs.next()) {
					products.add(new Product(rs.getInt(1), rs.getString(2), rs.getInt(3)));
				}
				Product[] productsArr = new Product[products.size()];
				for (int i = 0; i < products.size(); i++)
					productsArr[i] = products.get(i);
				return productsArr;
			}
		});

	}

}
