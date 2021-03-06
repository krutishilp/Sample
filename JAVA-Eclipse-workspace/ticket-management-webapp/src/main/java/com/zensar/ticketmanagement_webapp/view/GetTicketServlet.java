package com.zensar.ticketmanagement_webapp.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zensar.ticket_management.beans.Ticket;
import com.zensar.ticket_management.exceptions.TicketNotFoundException;
import com.zensar.ticket_management.service.TicketService;
import com.zensar.ticket_management.serviceprovider.TicketServiceProvider;

/**
 * Servlet implementation class GetTicketServlet
 */
@WebServlet("/getTicket")
public class GetTicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetTicketServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		TicketService os = TicketServiceProvider.getService();
		PrintWriter writer = response.getWriter();
		int ticketId = Integer.parseInt(request.getParameter("ticketId"));
		HttpSession session = request.getSession(false);
		writer.println("<html><head><title>All Tickets</title><link rel=\"stylesheet\"\r\n"
				+ "	href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\"\r\n"
				+ "	integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\"\r\n"
				+ "	crossorigin=\"anonymous\"><style>table{margin-left:50px;margin-top:10px}th{padding-left:10px;}td{padding-left:10px;}a{margin-top:10px;margin-left:50px;}</style></head><body>");

		if (session != null) {
			int userId = (Integer) session.getAttribute("userId");
			Ticket or;
			try {
				or = os.getTicket(ticketId, userId);

				writer.println("<table border=1 width=70% ");
				writer.println(
						"<tr><th>TicketId</th><th>PassengerId</th><th>Start Location</th><th>Destination Location</th><th>Booking Date</th><th>Travel Date</th><th>Payment</th><th>Payment Amount</th><th>Canceled</th><tr>");

				writer.println("<tr><td>" + or.getTicketId() + "</td><td>" + or.getPassangerNo() + "</td><td>"
						+ or.getStartLocation() + "</td><td>" + or.getDestLocation() + "</td><td>" + or.getBookDate()
						+ "</td><td>" + or.getTicketDate() + "</td><td>" + or.isPayment() + "</td><td>"
						+ or.getPaymentAmount() + "</td><td>" + or.isCanceled() + "</td></tr>");

			} catch (TicketNotFoundException e) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("ticketNotFoundError.html");
				dispatcher.forward(request, response);
			}

			writer.println("</table>");
			writer.println("<a class=\"btn btn-primary\" href=\"welcome.html\">Back to Home</a>");
			writer.println("</body></html>");
		} else {
			writer.println("<h3>Sorry,Something went Wrong!!</h3>");
			// writer.println("<a class=\"btn btn-primary\" href=\"welcome.html\">Back to
			// Home</a>");
			writer.println("</body></html>");
		}
	}

}
