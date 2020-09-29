package com.zensar.webservice.service;

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
		return repository.findAll();
	}

	@Override
	public Product getProduct(int productId) {
		return repository.findById(productId).get();
	}

	@Override
	public Product insertProduct(Product product) {
		return repository.save(product);
	}

	@Override
	public void deleteProduct(int productId) {
		repository.deleteById(productId);
		;

	}

	@Override
	public Product updateProduct(int productId, Product updatedProduct) {
		Product product = repository.findById(productId).get();
		product.setProductId(productId);
		product.setProductName(updatedProduct.getProductName());
		product.setProductCost(updatedProduct.getProductCost());
		return repository.save(product);

	}

	@Override
	public List<Product> getProductByName(String productName) {
		//return repository.getByProductName(productName);
		return repository.giveMeProducts(productName);
	}

}
