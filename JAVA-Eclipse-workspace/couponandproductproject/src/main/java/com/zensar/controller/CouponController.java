package com.zensar.controller;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zensar.DAO.CouponDAO;
import com.zensar.model.Coupon;

/**
 * Servlet implementation class CouponController
 */
public class CouponController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CouponController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equals("createCoupon")) {
			createCoupon(request, response);
		} else if (action.equals("findCoupon")) {
			findCoupon(request, response);
		}

	}

	private void createCoupon(HttpServletRequest request, HttpServletResponse response) {
		Coupon coupon = new Coupon();
		String couponCode = request.getParameter("couponName");
		BigDecimal couponDiscount = new BigDecimal(request.getParameter("couponDiscount"));
		String couponEXPDate = request.getParameter("couponExpiryDate");

		response.setContentType("text/html");
		coupon.setCouponCode(couponCode);
		coupon.setCouponDiscount(couponDiscount);
		coupon.setCouponEXPDate(couponEXPDate);

		CouponDAO couponDAO = new CouponDAO();
		Coupon coupon2 = couponDAO.createCoupon(coupon);

		if (coupon2 != null) {
			try {
				response.getWriter().print("<h2>Coupon Created</h2><br/><a href='index.jsp'>Back</a> ");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				response.getWriter().print("<h2>Coupon Creation Failed</h2><br/><a href='index.jsp'>Back</a> ");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void findCoupon(HttpServletRequest request, HttpServletResponse response) {
		String couponCode = request.getParameter("couponName");
		response.setContentType("text/html");
		CouponDAO couponDAO = new CouponDAO();
		Coupon coupon = couponDAO.findCoupon(couponCode);

		if (coupon != null) {
			try {
				response.getWriter().print(coupon);
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
