package com.zensar.spring.repository;

import java.util.List;

import com.zensar.spring.beans.Product;

public interface ProductRepository {
	int insertProduct(Product product);
	List<Product> getAllProducts();
}
