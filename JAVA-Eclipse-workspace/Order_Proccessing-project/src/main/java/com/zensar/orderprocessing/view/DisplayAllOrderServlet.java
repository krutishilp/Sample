package com.zensar.orderprocessing.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zensar.order.processing.beans.Order;
import com.zensar.order.processing.service.OrderService;
import com.zensar.order.processing.serviceprovider.OrderServiceProvider;

/**
 * Servlet implementation class DisplayAllOrderServlet
 */
public class DisplayAllOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DisplayAllOrderServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		OrderService os = OrderServiceProvider.getService();
		PrintWriter out = response.getWriter();
		Order[] orders = os.displayAllOrders();
		out.println("<html><head><title>All Orders</title><link rel=\"stylesheet\"\r\n"
				+ "	href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\"\r\n"
				+ "	integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\"\r\n"
				+ "	crossorigin=\"anonymous\"><style>table{margin-top:10px;width:70%;margin-left:20px;margin-right:20px;}th{padding-left:10px;}td{padding-left:10px;height:30px;}a{margin-top:10px;margin-left:50px;}</style></head><body>");
		out.println("<table border=1");
		out.println(
				"<tr><th>Order Id</th><th>Order Name</th><th>Order Price</th><th>Order Quantity</th><th>Order Date</th><th>Delete Order</th><th>Edit Order</th></tr>");

		for (Order or : orders) {
			if (or != null) {
				int orderId = or.getOrderId();
				String orderName = or.getOrderName();
				double orderPrice = or.getOrderPrice();
				int orderQuantity = or.getOrderQuantity();
				String orderDate = or.getOrderDate();
				out.println("<tr><td>" + orderId + "</td><td>" + orderName + "</td><td>" + orderPrice + "</td><td>"
						+ orderQuantity + "</td><td>" + orderDate + "</td><td><a href='deleteParticularOrder?orderId=" + or.getOrderId() + "'" + ""
								+ ">Delete</a></td><td>" + "<a href= 'updateAllDetails.html?orderId=" + or.getOrderId()
								+ "&orderName=" + or.getOrderName() + "&orderpPrice=" + or.getOrderPrice()
								+ "&orderQuantity=" + or.getOrderQuantity()+ "&orderDate=" + or.getOrderDate() + "'>Edit</a></td></tr>");

			}
		}

		/*
		 * for (int i = 0; i < orders.length; i++) { if (orders[i] != null)
		 * out.println("<tr><td>" + orders[i].getOrderId() + "</td><td>" +
		 * orders[i].getOrderName() + "</td>" + "<td>" + orders[i].getOrderPrice() +
		 * "</td><td>" + orders[i].getOrderQuantity() +
		 * "</td><td><a href='display?orderid=" + orders[i].getOrderId() + "'" + "" +
		 * ">delete</a></td><td>" + "<a href= 'edit.html?orderid=" +
		 * orders[i].getOrderId() + "&ordername=" + orders[i].getOrderName() +
		 * "&orderprice=" + orders[i].getOrderPrice() + "&orderquantity=" +
		 * orders[i].getOrderQuantity() + "'>edit</a></td></tr>"); }
		 */
		/*
		 * "</td><td><a href='display?orderid=" + orders[i].getOrderId() + "'" + "" +
		 * ">delete</a></td><td>"
		 */
		out.println("</table>");
		out.println("<a class=\"btn btn-primary\" href=\"index.jsp\">Back to Home</a>");
		out.println("</body></html>");
	}

}
