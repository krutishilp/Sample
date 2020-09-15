package com.zensar.productmanagement.repository;

import com.zensar.productmanagement.beans.Product;
import com.zensar.productmanagement.beans.User;
import com.zensar.productmanagement.exceptions.ProductNotFoundException;


public interface ProductRepository {
	boolean validateUser(int userId, String userPassword);

	int registerUser(User user, String userPassword);

	int insertProduct(Product productObj,int userId);

	Product[] getAllProducts(int userId);

	Product getProduct(int productId,int userId) throws ProductNotFoundException;

	boolean deleteProduct(int productId,int userId) throws ProductNotFoundException;
}
