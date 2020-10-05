package com.zensar.spring.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.zensar.spring.beans.Product;
import com.zensar.spring.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService service;

	@GetMapping("/productInfo")
	public String productInfo(Model model) {
		List<Product> list = service.getAllProducts();
		model.addAttribute("list", list);
		model.addAttribute("listSize",list.size());
		return "productInfo";
	}

	@PostMapping("/insertProduct")
	public RedirectView insertProduct(@ModelAttribute Product product,RedirectAttributes redir) {
		int productId = service.insertProduct(product);
		RedirectView redirectView = new RedirectView();
		if (productId > 0) {
			redirectView.setContextRelative(true);
			redirectView.setUrl("/productInfo");
			redir.addFlashAttribute("productId", productId);
			return redirectView;
		}
		return redirectView;
	}

	@GetMapping("/getProductDetails/{productId}")
	public String getProductDetails(@PathVariable int productId, Model model) {
		model.addAttribute("product", service.fetchProductById(productId));
		return "productOperations";
	}

	@RequestMapping(value = "/getProductDetails/productOperations", params = "update")
	public RedirectView productOperationUpdate(@ModelAttribute Product product,RedirectAttributes redir) {
		/*
		 * List<Product> list = service.getAllProducts(); model.addAttribute("list",
		 * list);
		 */
		Product updatedProduct = service.updateProduct(product);
		RedirectView redirectView = new RedirectView();
		redir.addFlashAttribute("updated", false);
		if (updatedProduct != null) {
			redirectView.setContextRelative(true);
			redirectView.setUrl("/productInfo");
			redir.addFlashAttribute("isUpdated", true);
			return redirectView;
		}
		return redirectView;
	}

	@RequestMapping(value = "/getProductDetails/productOperations", params = "delete")
	public RedirectView productOperationDelete(@ModelAttribute Product product,RedirectAttributes redir) {
		/*
		 * List<Product> list = service.getAllProducts(); model.addAttribute("list",
		 * list);
		 */
		boolean isDeleted = service.deleteProductById(product.getProductId());
		RedirectView redirectView = new RedirectView();
		redir.addFlashAttribute("isDeleted", false);
		if (isDeleted) {
			redirectView.setContextRelative(true);
			redirectView.setUrl("/productInfo");
			redir.addFlashAttribute("isDeleted", true);
			return redirectView;
		}
		return redirectView;
	}
	
	@ModelAttribute
	public void commonMsg(Model model) {
		String msg = "Product Management Application";
		model.addAttribute("msg", msg);
	}

}
