package com.zensar.spring.service;

import java.util.List;

import com.zensar.spring.beans.Product;

public interface ProductService {

	int insertProduct(Product product);
	List<Product> getAllProducts();
}
