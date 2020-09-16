package com.zensar.spring;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zensar.spring.beans.Product;
import com.zensar.spring.service.ProductService;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		ProductService service = context.getBean("service", ProductService.class);
		createProduct(service);
		fetchAllProduct(service);
		//fetchProductById(service);
		//deleteProductById(service);
		//updateProduct(service);
		
		((ClassPathXmlApplicationContext) context).close();

	}

	public static void createProduct(ProductService service) {
		service.insertProduct(new Product(1001,"TV", 50000));
		System.out.println("Product Inserted.....");
	}

	public static void fetchProductById(ProductService service) {
		Product product = service.fetchProductById(1);
		System.out.println(product);

	}

	public static void fetchAllProduct(ProductService service) {
		System.out.println("All Products");
		List<Product> allProducts = service.getAllProducts();
		for (Product product : allProducts) {
			System.out.println(product);
		}

	}
	
	public static void deleteProductById(ProductService service) {
		boolean id = service.deleteProductById(0);
		if (id) {
			System.out.println("Deleted");
		}
	}
	
	public static void updateProduct(ProductService service) {
		Product product = service.fetchProductById(1);
		product.setProductName("SKKK");
		Product updateProduct = service.updateProduct(product);
		System.out.println("updated Product " + updateProduct);
	}
}
