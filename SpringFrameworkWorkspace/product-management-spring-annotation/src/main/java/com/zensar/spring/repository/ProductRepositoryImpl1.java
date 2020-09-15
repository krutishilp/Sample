package com.zensar.spring.repository;

import org.springframework.stereotype.Repository;

import com.zensar.spring.beans.Product;
@Repository
public class ProductRepositoryImpl1 implements ProductRepository {

	private Product[] products=new Product[10];
	@Override
	public int insertProduct(Product product) {
		int index=0,productId=100;
		product.setProductId(productId);
		products[index++]=product;
		return product.getProductId();
	}

}
