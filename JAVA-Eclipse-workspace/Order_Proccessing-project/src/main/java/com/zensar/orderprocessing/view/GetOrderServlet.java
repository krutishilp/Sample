package com.zensar.orderprocessing.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zensar.order.processing.beans.Order;
import com.zensar.order.processing.exceptions.OrderNotFoundException;
import com.zensar.order.processing.service.OrderService;
import com.zensar.order.processing.serviceprovider.OrderServiceProvider;

/**
 * Servlet implementation class GetOrderServlet
 */
public class GetOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GetOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int orderId = Integer.parseInt(request.getParameter("orderId"));
		PrintWriter writer = response.getWriter();
		OrderService os=OrderServiceProvider.getService();

		writer.println("<html><head><link rel=\"stylesheet\"\r\n" + 
		 		"	href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\"\r\n" + 
		 		"	integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\"\r\n" + 
		 		"	crossorigin=\"anonymous\"><style>table{margin-left:50px;margin-top:10px}th{padding-left:10px;}td{padding-left:10px;}a{margin-top:10px;margin-left:50px;}</style></head><body>");  
		writer.println("<table border=1 width=50% ");
			writer.println("<tr><th>OrderId</th><th>OrderName</th><th>OrderPrice</th><th>OrderQuantity</th><th>OrderDate</th><tr>");
		try {
			Order order = os.getOrder(orderId);
			int orderId1=order.getOrderId();
			String orderName=order.getOrderName();
			double orderPrice=order.getOrderPrice();
			int orderQuantity=order.getOrderQuantity();
			String orderDate=order.getOrderDate();
			writer.println("<tr><td>" + orderId1 + "</td><td>" + orderName + "</td><td>" + orderPrice +  "</td><td>"+orderQuantity + "</td><td>"+orderDate+"</td></tr>");
			writer.println("</table>");
		} catch (OrderNotFoundException e) {
			/*
			 * writer.println("<h2>Sorry, Order with Id: " + orderId +
			 * " not Found !!</h2>"); writer.
			 * println("<a class=\"btn btn-primary\" href=\"index.jsp\">Back to Home</a>");
			 */
			RequestDispatcher dispatcher = request.getRequestDispatcher("orderNotFoundError.html");
			dispatcher.forward(request, response);
		}
		writer.println("<a class=\"btn btn-primary\" href=\"index.jsp\">Back to Home</a>");
		writer.println("</body></html>");
	}

}
