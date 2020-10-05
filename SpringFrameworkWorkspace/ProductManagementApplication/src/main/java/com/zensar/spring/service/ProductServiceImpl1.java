package com.zensar.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.spring.beans.Product;
import com.zensar.spring.repository.ProductRepository;
@Service
public class ProductServiceImpl1 implements ProductService {
	@Autowired
	private ProductRepository productRepositoryImpl;

	@Override
	public int insertProduct(Product product) {
		return productRepositoryImpl.insertProduct(product);
	}

	public ProductRepository getProductRepositoryImpl() {
		return productRepositoryImpl;
	}
	public void setProductRepositoryImpl(ProductRepository productRepositoryImpl) {
		this.productRepositoryImpl = productRepositoryImpl;
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepositoryImpl.getAllProducts();
	}

	@Override
	public Product fetchProductById(int productId) {
		return productRepositoryImpl.fetchProductById(productId);
	}

	@Override
	public boolean deleteProductById(int productId) {
		return productRepositoryImpl.deleteProductById(productId);
	}

	@Override
	public Product updateProduct(Product product) {
		return productRepositoryImpl.updateProduct(product);
	}

}
