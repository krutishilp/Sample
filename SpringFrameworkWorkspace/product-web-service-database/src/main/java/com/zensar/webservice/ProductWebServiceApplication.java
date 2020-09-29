package com.zensar.webservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ProductWebServiceApplication /* 1st way :implements CommandLineRunner*/ {

	
	/*//1st
	 * @Autowired private ProductController controller;
	 */

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ProductWebServiceApplication.class, args);
		/*//2nd Way:
		 * ProductController controller =
		 * context.getBean("productController",ProductController.class);
		 * controller.insertProduct(new Product(1005,"Lappy",500000));
		 */
	}

	/*//1st
	 * @Override public void run(String... args) throws Exception {
	 * 
	 * controller.insertProduct(new Product(1001, "Laptop", 15000));
	 * controller.insertProduct(new Product(1002, "TV", 10000)); }
	 */

}
