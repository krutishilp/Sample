package com.zensar.productmanagement.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zensar.productmanagement.beans.Product;
import com.zensar.productmanagement.service.ProductService;
import com.zensar.productmanagement.serviceprovider.ServiceProvider;

/**
 * Servlet implementation class ShowAllProductsServlet
 */
@WebServlet("/displayAllProducts")
public class DisplayAllProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProductService os = ServiceProvider.provideService();
		PrintWriter writer = response.getWriter();
		HttpSession session = request.getSession(false);
		writer.println("<html><head><title>All Products</title><link rel=\"stylesheet\"\r\n"
				+ "	href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\"\r\n"
				+ "	integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\"\r\n"
				+ "	crossorigin=\"anonymous\"><style>table{margin-left:50px;margin-top:10px}th{padding-left:10px;}td{padding-left:10px;}a{margin-top:10px;margin-left:50px;}</style></head><body>");

		if (session != null) {
			int userId = (Integer) session.getAttribute("userId");
			Product[] products = os.getAllProducts(userId);

			writer.println("<table border=1 width=70% ");
			writer.println(
					"<tr><th>Product Id</th><th>Product Name</th><th>Product Cost</th><th>Delete Product</th></tr>");
			for (Product product : products) {
				if (product != null) {
					writer.println(
							"<tr><td>" + product.getProductId() + "</td><td>" + product.getProductName() + "</td><td>"
									+ product.getProductCost() + "</td><td><a href='deleteParticularProduct?productId="
									+ product.getProductId() + "'" + ">Delete</a></td></tr>");

				}
			}
			writer.println("</table>");
			writer.println("<a class=\"btn btn-primary\" href=\"welcome.html\">Back to Home</a>");
			writer.println("</body></html>");
		} else {
			writer.println("<h3>Sorry,Something went Wrong!!</h3>");
			writer.println("</body></html>");
		}

	}

}