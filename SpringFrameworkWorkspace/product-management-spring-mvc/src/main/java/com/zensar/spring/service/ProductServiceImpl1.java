package com.zensar.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.zensar.spring.model.Product;
import com.zensar.spring.repository.ProductRepository;
@Service
public class ProductServiceImpl1 implements ProductService {

	@Autowired
	@Qualifier("productRepositoryImpl2")
	private ProductRepository repository;
	public int acceptProduct(Product product) {
		return repository.insertProduct(product);
	}
	public Product[] getAllProducts() {
		return repository.getAllProducts();
	}
	public Product getProduct(int productId) {
		return repository.getProduct(productId);
	}
	public boolean deleteProduct(int productId) {
		return repository.deleteProduct(productId);
	}
	public boolean updateProduct(Product product) {
		
		return repository.updateProduct(product);
	}

}
