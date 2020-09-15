package com.zensar.ticket_management.service;

import com.zensar.ticket_management.beans.Passenger;
import com.zensar.ticket_management.beans.Ticket;
import com.zensar.ticket_management.beans.User;
import com.zensar.ticket_management.exceptions.TicketNotFoundException;
import com.zensar.ticket_management.repository.TicketRepository;
import com.zensar.ticket_management.repositoryprovider.TicketRepositoryProvider;

public class TicketServiceImpl implements TicketService {

	TicketRepository orImpl = TicketRepositoryProvider.getRepository();

	@Override
	public boolean validateUser(int userId, String userPassword) {

		return orImpl.validateUser(userId, userPassword);
	}

	@Override
	public int registerUser(String userName, long userContact, String userAddress, String userPassword) {

		return orImpl.registerUser(new User(userName, userContact, userAddress), userPassword);
	}

	@Override
	public Ticket[] displayAllTickets(int userId) {
		return orImpl.displayAllTickets(userId);
	}

	@Override
	public Ticket getTicket(int ticketId, int userId) throws TicketNotFoundException {

		return orImpl.getTicket(ticketId, userId);
	}

	@Override
	public Ticket updateTicket(int ticketId,int userId) throws TicketNotFoundException {
		return orImpl.updateTicket(ticketId,userId);
	}

	@Override
	public boolean cancelTicket(int ticketId, int userId) throws TicketNotFoundException {

		return orImpl.cancelTicket(ticketId, userId);
	}

	@Override
	public int placeTicket(String passengerName, long passengerContact, String passengerAddress, String startLocation,
			String destinationLocation,String ticketDate, int paymentAmount, int userId) {

		return orImpl.createTicket(new Passenger(passengerName, passengerContact, passengerAddress),
				new Ticket(startLocation, destinationLocation,ticketDate, paymentAmount), userId);
	}

}
