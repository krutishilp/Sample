package com.zensar.controller;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zensar.DAO.CouponDAO;
import com.zensar.DAO.ProductDAO;
import com.zensar.model.Coupon;
import com.zensar.model.Product;

/**
 * Servlet implementation class ProductController
 */
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProductController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		createProduct(request, response);
	}

	private void createProduct(HttpServletRequest request, HttpServletResponse response) {
		CouponDAO couponDAO = new CouponDAO();
		ProductDAO productDAO = new ProductDAO();
		Product product = new Product();
		String productName = request.getParameter("productName");
		String productDescription = request.getParameter("productDescription");
		BigDecimal productPrice = new BigDecimal(request.getParameter("productPrice"));
		String couponCode = request.getParameter("couponCode");

		Coupon coupon = couponDAO.findCoupon(couponCode);

		response.setContentType("text/html");
		product.setProductName(productName);
		product.setProductDescription(productDescription);
		product.setProductPrice(productPrice.subtract(coupon.getCouponDiscount()));
		product.setCouponCode(couponCode);

		Product product2 = productDAO.createProduct(product);

		if (product2 != null) {
			try {
				response.getWriter().print("<h2>Product Created</h2>");
				response.getWriter().print(product2);
				response.getWriter().print("<br><a href='index.jsp'>Back</a>");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				response.getWriter().print("<h2>Coupon Not Found</h2><br/><a href='index.jsp'>Back</a> ");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
