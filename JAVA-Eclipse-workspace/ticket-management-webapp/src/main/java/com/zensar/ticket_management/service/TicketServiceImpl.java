package com.zensar.ticket_management.service;

import com.zensar.ticket_management.beans.Passenger;
import com.zensar.ticket_management.beans.Ticket;
import com.zensar.ticket_management.beans.User;
import com.zensar.ticket_management.exceptions.TicketNotFoundException;
import com.zensar.ticket_management.repository.TicketRepository;
import com.zensar.ticket_management.repositoryprovider.TicketRepositoryProvider;

public class TicketServiceImpl implements TicketService {

	TicketRepository orImpl = TicketRepositoryProvider.getRepository();

	public boolean validateUser(int userId, String userPassword) {

		return orImpl.validateUser(userId, userPassword);
	}

	public int registerUser(String userName, long userContact, String userAddress, String userPassword) {
		return orImpl.registerUser(new User(userName, userContact, userAddress), userPassword);
	}

	public Ticket[] displayAllTickets(int userId) {
		return orImpl.displayAllTickets(userId);
	}

	public Ticket getTicket(int ticketId, int userId) throws TicketNotFoundException {

		return orImpl.getTicket(ticketId, userId);
	}

	public Ticket updateTicket(int ticketId, int userId, String passengerName, long passengerContact)
			throws TicketNotFoundException {
		return orImpl.updateTicket(ticketId, userId, passengerName, passengerContact);
	}

	public boolean cancelTicket(int ticketId, int userId) throws TicketNotFoundException {
		return orImpl.cancelTicket(ticketId, userId);
	}

	public int placeTicket(String passengerName, long passengerContact, String passengerAddress, String startLocation,
			String destinationLocation, String ticketDate, int paymentAmount, int userId) {
		return orImpl.createTicket(new Passenger(passengerName, passengerContact, passengerAddress),
				new Ticket(startLocation, destinationLocation, ticketDate, paymentAmount), userId);
	}

	public Passenger getPassengerDetails(int ticketId) throws TicketNotFoundException {
		// TODO Auto-generated method stub
		return orImpl.getPassengerDetails(ticketId);
	}

}
