package com.zensar.ticketmanagement_webapp.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zensar.ticket_management.beans.Passenger;
import com.zensar.ticket_management.exceptions.TicketNotFoundException;
import com.zensar.ticket_management.service.TicketService;
import com.zensar.ticket_management.serviceprovider.TicketServiceProvider;

/**
 * Servlet implementation class GetPassengerDetailsServlet
 */
public class GetPassengerDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetPassengerDetailsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		TicketService ts = TicketServiceProvider.getService();
		PrintWriter writer = response.getWriter();
		writer.println("<html><head><title>All Orders</title><link rel=\"stylesheet\"\r\n"
				+ "	href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\"\r\n"
				+ "	integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\"\r\n"
				+ "	crossorigin=\"anonymous\"></style></head><body>");
		HttpSession session = request.getSession(false);
		
		if (session != null) {
			int ticketId = (Integer) session.getAttribute("ticketId");
			try {
				Passenger passenger = ts.getPassengerDetails(ticketId);
				writer.println("<table border=1 width=70% ");
				writer.println(
						"<tr><th>Passenger ID</th><th>Passenger Name</th><th>Passenger Contact </th><th>Passenger Address</th><tr>");

				writer.println("<tr><td>" + passenger.getPassengerId()+ "</td><td>" +passenger.getPassengerName()+ "</td><td>"
						+ passenger.getPassengerContact() + "</td><td>" + passenger.getPassengerAddress()+"</td></tr>");
				
				writer.print("</table>");
				
				writer.println("<a class=\"btn btn-primary\" href=\"welcome.html\">Back</a>");
				
				writer.println("</body></html>");
			} catch (TicketNotFoundException e) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("ticketNotFoundError.html");
				dispatcher.forward(request, response);
			}

		}else {
			writer.println("<h3>Sorry,Something went Wrong!!</h3>");
			writer.println("<a class=\"btn btn-primary\" href=\"showAllTickets\">Back</a>");
			writer.println("</body></html>");
		}
	}

}
