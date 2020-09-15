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

import com.zensar.ticket_management.exceptions.TicketNotFoundException;
import com.zensar.ticket_management.service.TicketService;
import com.zensar.ticket_management.serviceprovider.TicketServiceProvider;

/**
 * Servlet implementation class CancelTicketServlet
 */
@WebServlet("/cancelTicket")
public class CancelTicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CancelTicketServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int ticketId = Integer.parseInt(request.getParameter("ticketId"));
		PrintWriter writer = response.getWriter();
		boolean or = false;
		TicketService os = TicketServiceProvider.getService();
		writer.println("<html><head><link rel=\"stylesheet\"\r\n"
				+ "	href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\"\r\n"
				+ "	integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\"\r\n"
				+ "	crossorigin=\"anonymous\"><style>table{margin-left:50px;margin-top:10px}th{padding-left:10px;}td{padding-left:10px;}a{margin-top:10px;margin-left:50px;}</style></head><body>");

		HttpSession session = request.getSession(false);
		if (session != null) {
			int userId = (Integer) session.getAttribute("userId");

			try {
				or = os.cancelTicket(ticketId, userId);
			} catch (TicketNotFoundException e) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("ticketNotFoundError.html");
				dispatcher.forward(request, response);
			}
			if (or) {
				writer.println("<h3>Ticket Canceled Successfully !!</h3>");
				writer.println("<a class=\"btn btn-primary\" href=\"welcome.html\">Back to Home</a>");
			}
		} else {
			writer.println("<h4>Sorry,Something Went Wrong !!</h4>");
			writer.println("</body></html>");
		}
	}
}
