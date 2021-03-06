package com.zensar.productmanagement.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zensar.productmanagement.service.ProductService;
import com.zensar.productmanagement.serviceprovider.ServiceProvider;

public class CreateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductService ps = ServiceProvider.provideService();

	public CreateProductServlet() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter writer = response.getWriter();

		String productName = request.getParameter("productName");
		int productCost = Integer.parseInt(request.getParameter("productCost"));
		HttpSession session = request.getSession(false);
		if (session != null) {
			int userId = (Integer) session.getAttribute("userId");
			int product = ps.acceptProduct(productName, productCost, userId);
			if (product > 0) {
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("createProductSuccess.html");
				requestDispatcher.include(request, response);
			}
		} else {
			writer.println("<h3>Sorry,Something went Wrong!!</h3>");
			writer.println("</body></html>");
		}
	}

}