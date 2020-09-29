package com.zensar.webservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.zensar.webservice.beans.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	//List<Product> getByProductName(String productName);
	@Query("from Product p where p.productName=?1")
	List<Product> giveMeProducts(String productName);
}
