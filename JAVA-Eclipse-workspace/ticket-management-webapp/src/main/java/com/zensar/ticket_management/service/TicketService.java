package com.zensar.ticket_management.service;

import com.zensar.ticket_management.beans.Passenger;
import com.zensar.ticket_management.beans.Ticket;
import com.zensar.ticket_management.exceptions.TicketNotFoundException;

public interface TicketService {

	boolean validateUser(int userId,String userPassword);
	
	int registerUser(String userName,long userContact,String userAddress,String userPassword);
	
	int placeTicket(String passengerName,long passengerContact,String passengerAddress,String startLocation,String destinationLocation,String ticketDate,int paymentAmount,int userId);

	Ticket[] displayAllTickets(int userId);

	Ticket getTicket(int ticketId,int userId) throws TicketNotFoundException;

	Ticket updateTicket(int ticketId,int userId,String passengerName,long passengerContact) throws TicketNotFoundException;

	boolean cancelTicket(int ticketId,int userId) throws TicketNotFoundException;
	Passenger getPassengerDetails(int ticketId)  throws TicketNotFoundException;
}
