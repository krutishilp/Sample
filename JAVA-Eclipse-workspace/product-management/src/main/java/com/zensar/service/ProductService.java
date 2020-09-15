package com.zensar.service;

import com.zensar.beans.Product;

public interface ProductService {

	public int acceptProduct(String productName, int productCost);
	Product[] getAllProducts();
	Product getProduct(int productId);
	boolean deleteProduct(int productId);
}
