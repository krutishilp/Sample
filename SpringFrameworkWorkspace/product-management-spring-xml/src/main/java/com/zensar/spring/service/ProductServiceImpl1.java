package com.zensar.spring.service;
import com.zensar.spring.beans.Product;
import com.zensar.spring.repository.ProductRepository;

public class ProductServiceImpl1 implements ProductService {
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

}
