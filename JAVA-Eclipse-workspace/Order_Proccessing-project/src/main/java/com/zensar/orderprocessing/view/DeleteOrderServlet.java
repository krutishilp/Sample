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
 * Servlet implementation class DeleteOrderServlet
 */
public class DeleteOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DeleteOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int orderId = Integer.parseInt(request.getParameter("orderId"));
		PrintWriter writer = response.getWriter();
		OrderService os=OrderServiceProvider.getService();
		boolean or = false;
		/*
		 * writer.println("<html><head><link rel=\"stylesheet\"\r\n" +
		 * "	href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\"\r\n"
		 * +
		 * "	integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\"\r\n"
		 * + "	crossorigin=\"anonymous\"><style></style></head><body>");
		 */
		
		try {
			or = os.deleteOrder(orderId);
		} catch (OrderNotFoundException e) {
			/*
			 * writer.println("<h2>Sorry, Order with Id: " + orderId +
			 * " not Found !!</h2>"); writer.
			 * println("<a class=\"btn btn-primary\" href=\"index.jsp\">Back to Home</a>");
			 */
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("orderNotFoundError.html");
			dispatcher.forward(request, response);
		}
		if (or) {
			/*
			 * writer.println("<h2>Order Deleted Successfully !!</h2>"); writer.
			 * println("<a class=\"btn btn-primary\" href=\"index.jsp\">Back to Home</a>");
			 */
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("orderDeleteSuccess.html");
			dispatcher.forward(request, response);
		}
		
		//writer.println("</body></html>");
	}

}
