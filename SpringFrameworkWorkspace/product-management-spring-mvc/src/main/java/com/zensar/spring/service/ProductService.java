package com.zensar.spring.service;

import com.zensar.spring.model.Product;

public interface ProductService {

	int acceptProduct(Product product);
	Product[] getAllProducts();
	Product getProduct(int productId);
	boolean deleteProduct(int productId);
	boolean updateProduct(Product product);
}
