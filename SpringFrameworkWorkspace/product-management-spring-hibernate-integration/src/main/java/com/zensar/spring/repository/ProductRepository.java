package com.zensar.spring.repository;

import java.util.List;

import com.zensar.spring.beans.Product;

public interface ProductRepository {
	int insertProduct(Product product);
	List<Product> getAllProducts();
	Product fetchProductById(int productId);
	boolean deleteProductById(int productId);
	Product updateProduct(Product product);
}
