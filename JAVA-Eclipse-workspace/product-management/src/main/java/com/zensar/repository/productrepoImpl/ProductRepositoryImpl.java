package com.zensar.repository.productrepoImpl;

import com.zensar.beans.Product;
import com.zensar.repository.ProductRepository;

public class ProductRepositoryImpl implements ProductRepository {
	Product[] product = new Product[10];
	private static int INDEX = 0, productId = 100;

	public int insertProduct(Product productObj) {
		productObj.setProductId(productId++);
		product[INDEX++] = productObj;
		return productObj.getProductId();
	}

	@Override
	public Product[] getAllProducts() {
		return product ;
	}

	@Override
	public Product getProduct(int productId) {
		Product pdt=null;
		for(int i=0;i<product.length;i++) {
			if(product[i]!=null) {
				if(product[i].getProductId()==productId) {
					pdt= product[i];
					break;
				}				
			}
			
		}
		return pdt;
	}

	@Override
	public boolean deleteProduct(int productId) {
		for(int i=0;i<product.length;i++) {
			if(product[i]!=null) {
				if(product[i].getProductId()==productId) {
					product[i]=null;
					return true;
				}				
			}	
		}
		return false;
	}
}
