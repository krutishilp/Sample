package com.zensar.webservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.webservice.beans.Product;
import com.zensar.webservice.service.ProductService;

@RestController
@CacheConfig(cacheNames = "products") //cacheing in Spring
public class ProductController {

	@Autowired
	private ProductService service;

	//Logging in Spring 
	private Logger logger = LoggerFactory.getLogger(ProductController.class);

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String sayHello() {
		return "<h2>Hii Welcome</h2>";
	}

	// @RequestMapping(value = "/products", method = RequestMethod.GET)
	@GetMapping("/products")
	@Cacheable()
	public List<Product> getAllProducts() {
		logger.warn("Get All Products Method");
		return service.getAllProducts();
	}

	// @RequestMapping(value = "/products/{productId}", method = RequestMethod.GET)
	@GetMapping("/products/{productId}")
	public Product getProduct(@PathVariable("productId") int productId) {
		return service.getProduct(productId);
	}

	// @RequestMapping(value = "/insertProduct", method = RequestMethod.POST)
	@PostMapping("/insertProduct")
	public Product insertProduct(@RequestBody Product product) {
		return service.insertProduct(product);
	}

	// @RequestMapping(value = "/products/{productId}", method =
	// RequestMethod.DELETE)
	@DeleteMapping("/products/{productId}")
	public void deleteProduct(@PathVariable("productId") int productId) {
		service.deleteProduct(productId);
	}

	// @RequestMapping(value="/updateProduct/{productId}",method =
	// RequestMethod.PUT)
	@PatchMapping("/updateProduct/{productId}")
	public Product updateProduct(@PathVariable("productId") int productId, @RequestBody Product updatedProduct) {
		return service.updateProduct(productId, updatedProduct);
	}

	@GetMapping("/products/name/{productName}")
	public List<Product> getProductByName(@PathVariable String productName) {
		return service.getProductByName(productName);
	}

}
