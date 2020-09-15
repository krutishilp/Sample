package com.zensar.ticketmanagement_webapp.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zensar.ticket_management.service.TicketService;
import com.zensar.ticket_management.serviceprovider.TicketServiceProvider;

/**
 * Servlet implementation class BookTicketServlet
 */
@WebServlet("/bookTicket")
public class BookTicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookTicketServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		TicketService ts = TicketServiceProvider.getService();
		PrintWriter writer = response.getWriter();
		boolean flag = false;
		String passengerName = request.getParameter("passengerName");
		long passengerContact = Long.parseLong(request.getParameter("passengerContact"));
		String passengerAddress = request.getParameter("passengerAddress");
		String startLocation = request.getParameter("startLocation");
		String destinationLocation = request.getParameter("destinationLocation");
		String travelDate = request.getParameter("travelDate");
		int payment = Integer.parseInt(request.getParameter("paymentAmount"));
		writer.println("<html><head><title>All Orders</title><link rel=\"stylesheet\"\r\n"
				+ "	href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\"\r\n"
				+ "	integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\"\r\n"
				+ "	crossorigin=\"anonymous\"></style></head><body>");
		HttpSession session = request.getSession(false);
		if (session != null) {
			int userId = (Integer) session.getAttribute("userId");

			if (!startLocation.equalsIgnoreCase(destinationLocation)) {

				if (startLocation.equalsIgnoreCase("Nashik") && destinationLocation.equalsIgnoreCase("Pune")) {
					if (payment == 500) {
						flag = true;
						writer.println("<h3>Thank You, Payment Successful....</h3>");

					} else {
						writer.println("<h3>Sorry,Payment Failed</h3>");

					}
				}

				if (startLocation.equalsIgnoreCase("Nashik") && destinationLocation.equalsIgnoreCase("Mumbai")) {
					if (payment == 400) {
						flag = true;
						writer.println("<h3>Thank You, Payment Successful....</h3>");

					} else {
						writer.println("<h3>Sorry,Payment Failed</h3>");

					}
				}

				if (startLocation.equalsIgnoreCase("Pune") && destinationLocation.equalsIgnoreCase("Nashik")) {

					if (payment == 500) {
						flag = true;
						writer.println("<h3>Thank You, Payment Successful....</h3>");

					} else {
						writer.println("<h3>Sorry,Payment Failed</h3>");

					}
				}

				if (startLocation.equalsIgnoreCase("Pune") && destinationLocation.equalsIgnoreCase("Mumbai")) {
					if (payment == 600) {
						flag = true;
						writer.println("<h3>Thank You, Payment Successful....</h3>");

					} else {
						writer.println("<h3>Sorry,Payment Failed</h3>");

					}
				}

				if (startLocation.equalsIgnoreCase("Mumbai") && destinationLocation.equalsIgnoreCase("Nashik")) {
					if (payment == 400) {
						flag = true;
						writer.println("<h3>Thank You, Payment Successful....</h3>");

					} else {
						writer.println("<h3>Sorry,Payment Failed</h3>");

					}
				}

				if (startLocation.equalsIgnoreCase("Mumbai") && destinationLocation.equalsIgnoreCase("Pune")) {
					if (payment == 600) {
						flag = true;
						writer.println("<h3>Thank You, Payment Successful....</h3>");

					} else {
						writer.println("<h3>Sorry,Payment Failed</h3>");

					}
				}

				if (flag) {
					int ticketNumber = ts.placeTicket(passengerName, passengerContact, passengerAddress, startLocation,
							destinationLocation, travelDate, payment, userId);
					if (ticketNumber > 0) {
						writer.println("<h3>Your Ticket Number is: " + ticketNumber + "</h3>");
						writer.println("<a class=\"btn btn-primary\" href=\"welcome.html\">Back to Home</a>");
					}

				} else {
					writer.println("<h3>Booking Failed !!</h3>");
					writer.println("<a class=\"btn btn-primary\" href=\"bookTicket.html\">Back</a>");
				}

			} else {
				writer.println("<h3>Sorry, Start and Destination should not be Same !!</h3>");
				writer.println("<a class=\"btn btn-primary\" href=\"bookTicket.html\">Back</a>");
			}

			writer.print("</body></html>");
		} else {
			writer.println("<h3>Something went Wrong!!</h3>");
			writer.println("<a class=\"btn btn-primary\" href=\"bookTicket.html\">Back</a>");
			writer.print("</body></html>");
		}

	}
}
