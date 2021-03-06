package com.zensar.orderprocessing.view;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zensar.order.processing.exceptions.OrderNotFoundException;
import com.zensar.order.processing.service.OrderService;
import com.zensar.order.processing.serviceprovider.OrderServiceProvider;

/**
 * Servlet implementation class UpdateParticularOrderServlet
 */
public class UpdateParticularOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateParticularOrderServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int orderId = Integer.parseInt(request.getParameter("orderId"));
		String orderName = request.getParameter("orderName");
		double orderPrice = Double.parseDouble(request.getParameter("orderPrice"));
		int orderQuantity = Integer.parseInt(request.getParameter("orderQuantity"));
		String orderDate = request.getParameter("orderDate");
		OrderService os = OrderServiceProvider.getService();

		try {
			int particularOrder = os.updateParticularOrder(orderId, orderName, orderPrice, orderQuantity, orderDate);
			if (particularOrder > 0) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("updateParticularOrderSuccess.html");
				dispatcher.forward(request, response);
			}
		} catch (OrderNotFoundException e) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("orderNotFoundError.html");
			dispatcher.forward(request, response);
		}

	}

}
