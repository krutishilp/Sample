package com.zensar.spring.repository;

import org.springframework.stereotype.Repository;

import com.zensar.spring.model.Product;

@Repository
public class ProductRepositoryImpl1 implements ProductRepository {

	Product[] product = new Product[10];
	private static int INDEX = 0, productId = 100;

	public int insertProduct(Product productObj) {
		productObj.setProductId(productId++);
		product[INDEX++] = productObj;
		return productObj.getProductId();
	}

	public Product[] getAllProducts() {
		return product;
	}

	public Product getProduct(int productId) {
		Product pdt = null;
		for (int i = 0; i < product.length; i++) {
			if (product[i] != null) {
				if (product[i].getProductId() == productId) {
					pdt = product[i];
					break;
				}
			}

		}
		return pdt;
	}

	public boolean deleteProduct(int productId) {
		for (int i = 0; i < product.length; i++) {
			if (product[i] != null) {
				if (product[i].getProductId() == productId) {
					product[i] = null;
					return true;
				}
			}
		}
		return false;
	}

	public boolean updateProduct(Product prod) {
		for (int i = 0; i < product.length; i++) {
			if (product[i] != null) {
				if (product[i].getProductId() == prod.getProductId()) {
					product[i]=prod;
					return true;
				}
			}

		}
		return false;
	}

}
