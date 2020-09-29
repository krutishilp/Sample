package com.zensar.webservice.service;

import java.util.List;

import com.zensar.webservice.beans.Product;

public interface ProductService {

	public List<Product> getAllProducts();

	public Product getProduct(int productId);

	public Product insertProduct(Product product);

	public void deleteProduct(int productId);

	public Product updateProduct(int productId, Product updatedProduct);
	public List<Product> getProductByName(String productName);
}
