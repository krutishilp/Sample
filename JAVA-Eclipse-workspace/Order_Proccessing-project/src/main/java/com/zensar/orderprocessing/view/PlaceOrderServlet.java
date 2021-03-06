package com.zensar.orderprocessing.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zensar.order.processing.exceptions.NegativePriceException;
import com.zensar.order.processing.exceptions.NegativeQuantityException;
import com.zensar.order.processing.service.OrderService;
import com.zensar.order.processing.serviceprovider.OrderServiceProvider;

/**
 * Servlet implementation class PlaceOrderServlet
 */
public class PlaceOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PlaceOrderServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String orderName = request.getParameter("orderName");
		double orderPrice = Double.parseDouble(request.getParameter("orderPrice"));
		int orderQuantity = Integer.parseInt(request.getParameter("orderQuantity"));
		String orderDate = request.getParameter("orderDate");
		OrderService os = OrderServiceProvider.getService();
		PrintWriter writer = response.getWriter();
		RequestDispatcher dispatcher=null;
		int result;
		try {
			result = os.placeOrder(orderName, orderPrice, orderQuantity, orderDate);
			if (result > 0) {
				//writer.println("<h1>Order Placed Successfully with OrderId: " + result + "</h1>");
				dispatcher = request.getRequestDispatcher("orderPlaceSuccess.html");
				dispatcher.forward(request, response);
			} else {
				writer.println("<h1>Order Insertion Failed !!</h1>");
			}
		} catch (NegativePriceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NegativeQuantityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
		}
	}
}