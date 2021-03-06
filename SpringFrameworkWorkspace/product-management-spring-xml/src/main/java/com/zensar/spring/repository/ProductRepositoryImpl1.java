package com.zensar.spring.repository;

import org.springframework.jdbc.core.JdbcTemplate;

import com.zensar.spring.beans.Product;

public class ProductRepositoryImpl1 implements ProductRepository {

	private JdbcTemplate template;

	@Override
	public int insertProduct(Product product) {
		int index = 0, productId = 100;
		product.setProductId(productId);
		String sql = "insert into product values(" + product.getProductId() + ",'" + product.getProductName() + "',"
				+ product.getProductCost() + ");";
		template.execute(sql);
		return product.getProductId();
	}

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

}
