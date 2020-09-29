package com.zensar.webservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.webservice.beans.Product;
import com.zensar.webservice.repository.ProductRepository;
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository repository;

	@Override
	public List<Product> getAllProducts() {
		return repository.getAllProducts();
	}

	@Override
	public Product getProduct(int productId) {
		return repository.getProduct(productId);
	}

	@Override
	public boolean insertProduct(Product product) {
		return repository.insertProduct(product);
	}

	@Override
	public boolean deleteProduct(int productId) {
		return repository.deleteProduct(productId);
		
	}

	@Override
	public boolean updateProduct(int productId, Product updatedProduct) {
		return repository.updateProduct(productId, updatedProduct);

	}

}
