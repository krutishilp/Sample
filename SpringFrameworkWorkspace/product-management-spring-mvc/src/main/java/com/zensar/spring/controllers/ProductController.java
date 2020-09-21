package com.zensar.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.zensar.spring.model.Product;
import com.zensar.spring.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;

	public ProductController() {
		System.out.println("**********************");
	}

	@RequestMapping("/productInfo")
	public String productInfo() {
		return "productInfo";
	}

	/*
	 * @RequestMapping("/insertProduct") public String
	 * insertProduct(@RequestParam(name = "productId", defaultValue = "10") int
	 * productId,
	 * 
	 * @RequestParam(name = "productName", defaultValue = "Laptop") String
	 * productName,
	 * 
	 * @RequestParam(name = "productCost", defaultValue = "10") int productCost,
	 * Model model) { Product product = new Product();
	 * product.setProductId(productId); product.setProductName(productName);
	 * product.setProductCost(productCost);
	 * 
	 * model.addAttribute(product);
	 * 
	 * 
	 * model.addAttribute("productId", productId); model.addAttribute("productName",
	 * productName); model.addAttribute("productCost", productCost);
	 * 
	 * 
	 * return "insertProduct"; }
	 */

	@RequestMapping("/insertProduct")
	public String insertProduct(@ModelAttribute Product product) {
		int result = productService.acceptProduct(product);
		if (result >= 100) {
			return "insertProduct";
		} else {
			return "productInfo";
		}
	}

	@RequestMapping("/displayAllProducts")
	public String displayAllProducts(Model model) {
		Product[] allProducts = productService.getAllProducts();
		model.addAttribute("products", allProducts);
		return "displayAllProducts";
	}

	@ModelAttribute
	public void commonMsg(Model model) {
		String msg = "Product Management Application";
		model.addAttribute("msg", msg);
	}

	@RequestMapping("/getProduct")
	public String getProduct() {
		return "getProduct";
	}

	@RequestMapping("/getProductById")
	public String getProductById(@RequestParam("productId") int productId, Model model) {
		Product product = productService.getProduct(productId);
		if(product!=null) {
			model.addAttribute(product);
			return "displayProductById";
		}else {
			return "getProduct";
		}
		
	}

	@RequestMapping("/productDelete")
	public String productDelete() {
		return "deleteProduct";
	}

	@RequestMapping("/deleteProductById")
	public String deleteProduct(@RequestParam("productId") int productId) {
		System.out.println("Product Id " + productId);
		boolean product = productService.deleteProduct(productId);

		if (product) {
			return "deleteProductSuccess";
		} else {
			return "deleteProduct";
		}
	}

	@RequestMapping("/productUpdate")
	public String productUpdate() {
		return "updateProduct";
	}

	@RequestMapping("/updateProd")
	public String prodUpdate(@ModelAttribute Product product) {
		boolean updateProduct = productService.updateProduct(product);
		System.out.println(product.getProductId()+" "+product.getProductName());
		if (updateProduct) {
			return "updateProductSuccess";
		} else {
			return "updateProduct";
		}

	}

}
