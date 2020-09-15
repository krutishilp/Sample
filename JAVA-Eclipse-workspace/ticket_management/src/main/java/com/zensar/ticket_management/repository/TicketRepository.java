package com.zensar.ticket_management.repository;

import com.zensar.ticket_management.beans.Passenger;
import com.zensar.ticket_management.beans.Ticket;
import com.zensar.ticket_management.beans.User;
import com.zensar.ticket_management.exceptions.TicketNotFoundException;

public interface TicketRepository {

	boolean validateUser(int userId,String userPassword);

	int registerUser(User user,String userPassword);

	int createTicket(Passenger passenger,Ticket ticket,int userId);

	Ticket[] displayAllTickets(int userId);

	Ticket getTicket(int ticketId,int userId) throws TicketNotFoundException;

	Ticket updateTicket(int ticketId,int userId) throws TicketNotFoundException;

	boolean cancelTicket(int ticketId,int userId) throws TicketNotFoundException;
}
