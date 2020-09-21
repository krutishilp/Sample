package com.zensar.spring.repository;

import com.zensar.spring.model.Product;

public interface ProductRepository {
	int insertProduct(Product product);
	Product[] getAllProducts();
	Product getProduct(int productId);
	boolean deleteProduct(int productId);
	boolean updateProduct(Product product);
}
