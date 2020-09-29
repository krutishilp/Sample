package com.zensar.webservice.repository;

import java.util.List;

import com.zensar.webservice.beans.Product;

public interface ProductRepository {

	public List<Product> getAllProducts();

	public Product getProduct(int productId);

	public boolean insertProduct(Product product);

	public boolean deleteProduct(int productId);

	public boolean updateProduct(int productId, Product updatedProduct);
}
