package com.zensar.spring.service;

import java.util.List;

import com.zensar.spring.beans.Product;

public interface ProductService {

	int insertProduct(Product product);
	List<Product> getAllProducts();
	Product fetchProductById(int productId);
	boolean deleteProductById(int productId);
	Product updateProduct(Product product);
}
