package com.zensar.orderprocessing.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zensar.order.processing.exceptions.OrderNotFoundException;
import com.zensar.order.processing.service.OrderService;
import com.zensar.order.processing.serviceprovider.OrderServiceProvider;

/**
 * Servlet implementation class DeleteParticularOrderServlet
 */
public class DeleteParticularOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteParticularOrderServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int orderId = Integer.parseInt(request.getParameter("orderId"));
		//PrintWriter writer = response.getWriter();
		OrderService os = OrderServiceProvider.getService();
		boolean or = false;
		
		try {
			or = os.deleteOrder(orderId);
		} catch (OrderNotFoundException e) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("orderNotFoundError.html");
			dispatcher.forward(request, response);
		}
		if (or) {

			RequestDispatcher dispatcher = request.getRequestDispatcher("deleteParticularOrder.html");
			dispatcher.forward(request, response);
		}

	}

}
