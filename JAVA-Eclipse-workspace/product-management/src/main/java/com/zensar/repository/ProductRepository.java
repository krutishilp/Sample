package com.zensar.repository;

import com.zensar.beans.Product;

public interface ProductRepository {

	int insertProduct(Product productObj);
	Product[] getAllProducts();
	Product getProduct(int productId);
	boolean deleteProduct(int productId);
}
