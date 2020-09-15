package com.zensar.productmanagement.service;

import com.zensar.productmanagement.beans.Product;
import com.zensar.productmanagement.exceptions.ProductNotFoundException;

public interface ProductService {
	
boolean validateUser(int userId,String userPassword);
	
	int registerUser(String userName,long userContact,String userAddress,String userPassword);
	public int acceptProduct(String productName, int productCost,int userId);
	Product[] getAllProducts(int userId);
	Product getProduct(int productId,int userId) throws ProductNotFoundException;
	boolean deleteProduct(int productId,int userId) throws ProductNotFoundException;
}
