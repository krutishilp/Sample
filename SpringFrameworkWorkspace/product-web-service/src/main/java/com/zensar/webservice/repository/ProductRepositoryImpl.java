package com.zensar.webservice.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.zensar.webservice.beans.Product;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

	List<Product> list = new ArrayList<Product>();

	public ProductRepositoryImpl() {
		list.add(new Product(1, "Windows", 15000));
		list.add(new Product(2, "Mac", 100000));
		list.add(new Product(3, "Ipad", 50000));
	}

	@Override
	public List<Product> getAllProducts() {
		return list;
	}

	@Override
	public Product getProduct(int productId) {
		for (Product product : list) {
			if (product.getProductId() == productId) {
				return product;
			}
		}
		return null;
	}

	@Override
	public boolean insertProduct(Product product) {
		return list.add(product);
	}

	@Override
	public boolean deleteProduct(int productId) {
		for (Product product : list) {
			if (product.getProductId() == productId) {
				return list.remove(product);
			}
		}
		return false;
	}

	@Override
	public boolean updateProduct(int productId, Product updatedProduct) {
		for (Product product : list) {
			if (product.getProductId() == productId) {
				product.setProductId(updatedProduct.getProductId());
				product.setProductName(updatedProduct.getProductName());
				product.setProductCost(updatedProduct.getProductCost());
				return true;
			}
		}
		return false;
	}

}
