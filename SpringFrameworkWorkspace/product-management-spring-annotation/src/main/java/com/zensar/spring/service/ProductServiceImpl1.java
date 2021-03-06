package com.zensar.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.zensar.spring.beans.Product;
import com.zensar.spring.repository.ProductRepository;
import com.zensar.spring.repository.ProductRepositoryImpl1;
@Service
@Scope("prototype")
public class ProductServiceImpl1 implements ProductService {
	//@Autowired
	private ProductRepository productRepositoryImpl;
	@Autowired
	public ProductServiceImpl1(ProductRepository productRepositoryImpl) {
		super();
		this.productRepositoryImpl = productRepositoryImpl;
	}

	@Override
	public int insertProduct(Product product) {
		return productRepositoryImpl.insertProduct(product);
	}

	public ProductRepository getProductRepositoryImpl() {
		return productRepositoryImpl;
	}
	/*
	 * @Autowired public void setProductRepositoryImpl(ProductRepository
	 * productRepositoryImpl) { this.productRepositoryImpl = productRepositoryImpl;
	 * }
	 */
}
