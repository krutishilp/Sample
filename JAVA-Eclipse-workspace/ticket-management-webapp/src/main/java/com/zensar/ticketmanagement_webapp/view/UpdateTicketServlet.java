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
 * Servlet implementation class UpdateTicketServlet
 */
@WebServlet("/updateTicket")
public class UpdateTicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateTicketServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int ticketId = Integer.parseInt(request.getParameter("ticketId"));
		String passengerName = request.getParameter("passengerName");
		long passengerContact = Long.parseLong(request.getParameter("passengerContact"));
		PrintWriter writer = response.getWriter();
		TicketService os = TicketServiceProvider.getService();
		writer.println("<html><head><link rel=\"stylesheet\"\r\n"
				+ "	href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\"\r\n"
				+ "	integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\"\r\n"
				+ "	crossorigin=\"anonymous\"><style>table{margin-left:50px;margin-top:10px}th{padding-left:10px;}td{padding-left:10px;}a{margin-top:10px;margin-left:50px;}</style></head><body>");

		HttpSession session = request.getSession(false);
		if (session != null) {
			int userId = (Integer) session.getAttribute("userId");
			Ticket or;
			try {

				or = os.updateTicket(ticketId, userId, passengerName, passengerContact);
				writer.println("<table border=1 width=70% ");
				writer.println(
						"<tr><th>TicketId</th><th>PassengerId</th><th>Start Location</th><th>Destination Location</th><th>Booking Date</th><th>Travel Date</th><th>Payment</th><th>Payment Amount</th><th>Canceled</th><tr>");
				writer.println("<h4>Ticket Updated, Thank You :)</h4>");
				writer.println("<tr><td>" + or.getTicketId() + "</td><td>" + or.getPassangerNo() + "</td><td>"
						+ or.getStartLocation() + "</td><td>" + or.getDestLocation() + "</td><td>" + or.getBookDate()
						+ "</td><td>" + or.getTicketDate() + "</td><td>" + or.isPayment() + "</td><td>"
						+ or.getPaymentAmount() + "</td><td>" + or.isCanceled() + "</td></tr>");
				writer.println("</body></table>");
			} catch (TicketNotFoundException e1) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("ticketNotFoundError.html");
				dispatcher.forward(request, response);
			}
			writer.println("<a class=\"btn btn-primary\" href=\"welcome.html\">Back to Home</a>");
			writer.println("</body></html>");
		} else {
			writer.println("<h4>Sorry,Something Went Wrong !!</h4>");
			writer.println("</body></html>");
		}
	}

}
