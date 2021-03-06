package com.zensar.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zensar.spring.beans.Product;
import com.zensar.spring.service.ProductService;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		ProductService service = context.getBean("productServiceImpl1", ProductService.class);
		ProductService service1 = context.getBean("productServiceImpl1", ProductService.class);
		System.out.println("Product inserted with productId: " + service.insertProduct(new Product("Laptop", 50000)));

		if (service == service1) {
			System.out.println("Singleton Scope");
		} else {
			System.out.println("Prototype Scope");
		}
		((ClassPathXmlApplicationContext) context).close();
	}
}
