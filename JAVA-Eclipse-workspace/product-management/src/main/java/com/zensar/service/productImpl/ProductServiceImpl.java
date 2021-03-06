package com.zensar.service.productImpl;

import com.zensar.beans.Product;
import com.zensar.repository.ProductRepository;
import com.zensar.repository.productrepoImpl.ProductRepositoryImpl;
import com.zensar.service.ProductService;

public class ProductServiceImpl implements ProductService {
	ProductRepository pr = new ProductRepositoryImpl();

	public int acceptProduct(String productName, int productCost) {
		return pr.insertProduct(new Product(productName, productCost));
	}

	@Override
	public Product[] getAllProducts() {
		return pr.getAllProducts();
	}

	@Override
	public Product getProduct(int productId) {
		// TODO Auto-generated method stub
		return pr.getProduct(productId);
	}

	@Override
	public boolean deleteProduct(int productId) {
		// TODO Auto-generated method stub
		return pr.deleteProduct(productId);
	}

}
