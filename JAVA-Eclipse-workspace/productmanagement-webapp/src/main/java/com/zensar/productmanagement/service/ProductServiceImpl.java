package com.zensar.productmanagement.service;

import com.zensar.productmanagement.beans.Product;
import com.zensar.productmanagement.beans.User;
import com.zensar.productmanagement.exceptions.ProductNotFoundException;
import com.zensar.productmanagement.repository.ProductRepository;
import com.zensar.productmanagement.repositoryprovider.RepositoryProvider;

public class ProductServiceImpl implements ProductService {
	ProductRepository pr = RepositoryProvider.provideService();

	public int acceptProduct(String productName, int productCost,int userId) {
		return pr.insertProduct(new Product(productName, productCost),userId);
	}

	public Product[] getAllProducts(int userId) {
		return pr.getAllProducts(userId);
	}

	public Product getProduct(int productId,int userId) throws ProductNotFoundException {
		return pr.getProduct(productId,userId);
	}

	public boolean deleteProduct(int productId,int userId) throws ProductNotFoundException {
		return pr.deleteProduct(productId,userId);
	}

	public boolean validateUser(int userId, String userPassword) {
		return pr.validateUser(userId, userPassword);
	}

	public int registerUser(String userName, long userContact, String userAddress, String userPassword) {
		
		return pr.registerUser(new User(userName, userContact, userAddress), userPassword);
	}

}
