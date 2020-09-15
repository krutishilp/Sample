package com.zensar.ticket_management.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.zensar.ticket_management.beans.Passenger;
import com.zensar.ticket_management.beans.Ticket;
import com.zensar.ticket_management.beans.User;
import com.zensar.ticket_management.exceptions.TicketNotFoundException;
import com.zensar.ticket_management.jdbc.ConnectionProvider;

public class TicketRepositoryJDBCImpl implements TicketRepository {
	static int ticketId = 100;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Connection con = ConnectionProvider.getConnection();

	@Override
	public boolean validateUser(int userId, String userPassword) {
		try {
			pstmt = con.prepareStatement("select userId,userPassword from login where userId=? and userPassword=?");
			pstmt.setInt(1, userId);
			pstmt.setString(2, userPassword);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public int registerUser(User user, String userPassword) {
		Random rand = new Random();
		user.setUserId(rand.nextInt(100));

		try {
			pstmt = con.prepareStatement("insert into login values(?,?)");
			pstmt.setInt(1, user.getUserId());
			pstmt.setString(2, userPassword);
			pstmt.executeUpdate();
			pstmt = con.prepareStatement("insert into user values(?,?,?,?)");
			pstmt.setInt(1, user.getUserId());
			pstmt.setString(2, user.getUserName());
			pstmt.setLong(3, user.getUserContact());
			pstmt.setString(4, user.getUserAddress());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return user.getUserId();
	}

	@Override
	public int createTicket(Passenger passenger, Ticket ticket, int userId) {
		Random rand = new Random();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		int random = rand.nextInt(50);
		int passId = rand.nextInt(50);
		ticket.setTicketId(random);
		ticket.setPassangerNo(passId);
		ticket.setBookDate(dtf.format(now));
		ticket.setPayment(true);
		ticket.setCanceled(false);
		passenger.setPassengerId(passId);

		try {
			pstmt = con.prepareStatement("insert into passenger values(?,?,?,?)");
			pstmt.setInt(1, passenger.getPassengerId());
			pstmt.setString(2, passenger.getPassengerName());
			pstmt.setLong(3, passenger.getPassengerContact());
			pstmt.setString(4, passenger.getPassengerAddress());

			pstmt.executeUpdate();

			pstmt = con.prepareStatement("insert into ticket values(?,?,?,?,?,?,?,?,?,?)");
			pstmt.setInt(1, passenger.getPassengerId());
			pstmt.setInt(2, ticket.getTicketId());
			pstmt.setString(3, ticket.getStartLocation());
			pstmt.setString(4, ticket.getDestLocation());
			pstmt.setString(5, ticket.getTicketDate());
			if (ticket.isPayment()) {
				pstmt.setInt(6, 1);
			} else {
				pstmt.setInt(6, 0);
			}

			if (ticket.isCanceled()) {
				pstmt.setInt(7, 1);
			} else {
				pstmt.setInt(7, 0);
			}

			pstmt.setInt(8, ticket.getPaymentAmount());
			pstmt.setInt(9, userId);
			pstmt.setString(10,ticket.getBookDate());

			pstmt.executeUpdate();

			/*
			 * pstmt.setString(2, ticket.getTicketName()); pstmt.setDouble(3,
			 * ticket.getTicketPrice()); pstmt.setInt(4, ticket.getTicketQuantity());
			 * pstmt.setString(5, ticket.getTicketDate());
			 */
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ticket.getTicketId();

	}

	@Override
	public Ticket[] displayAllTickets(int userId) {
		List<Ticket> list = new ArrayList<Ticket>();
		boolean payflag = false;
		boolean cancelflag = false;
		try {
			pstmt = con.prepareStatement(
					"select ticketId,startLocation,destinationLocation,ticketDate,bookDate,passengerId,isPayment,isCanceled,paymentAmount from ticket where userId=?");
			pstmt.setInt(1, userId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				if (rs.getInt(7) == 1) {
					payflag = true;
				} else {
					payflag = false;
				}
				if (rs.getInt(8) == 1) {
					cancelflag = true;
				} else {
					cancelflag = false;
				}

				list.add(new Ticket(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6),
						payflag, cancelflag, rs.getInt(9)));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Ticket[] ticket = new Ticket[list.size()];
		ticket = list.toArray(ticket);
		return ticket;
	}

	@Override
	public Ticket getTicket(int ticketId, int userId) throws TicketNotFoundException {
		Ticket ticket = null;
		boolean payflag = false;
		boolean cancelflag = false;
		try {
			pstmt = con.prepareStatement(
					"select ticketId,startLocation,destinationLocation,ticketDate,bookDate,passengerId,isPayment,isCanceled,paymentAmount from ticket where ticketId=? and userId=?");
			pstmt.setInt(1, ticketId);
			pstmt.setInt(2, userId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				if (rs.getInt(7) == 1) {
					payflag = true;
				} else {
					payflag = false;
				}
				if (rs.getInt(8) == 1) {
					cancelflag = true;
				} else {
					cancelflag = false;
				}

				ticket = new Ticket(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5), rs.getInt(6),
						payflag, cancelflag, rs.getInt(9));
				return ticket;
			} else {
				throw new TicketNotFoundException("Ticket Not Found");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ticket;
	}

	@Override
	public Ticket updateTicket(int ticketId, int userId) throws TicketNotFoundException {
		Scanner sc = new Scanner(System.in);
		Ticket ticket = null;
		boolean payflag = false;
		boolean cancelflag = false;
		try {
			pstmt = con.prepareStatement("select passengerId from ticket where ticketId=? and userId=?");
			pstmt.setInt(1, ticketId);
			pstmt.setInt(2, userId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				System.out.println("Please Enter Updated Name of Passenger :");
				String passName = sc.next();
				System.out.println("Please Enter Updated Contact Number of Passenger:");
				long contactNumber = sc.nextLong();
				try {
					pstmt = con.prepareStatement(
							"update passenger set passengerName=?,passengerContact=? where passengerId=?");
					pstmt.setString(1, passName);
					pstmt.setLong(2, contactNumber);
					pstmt.setInt(3, rs.getInt(1));
					int ch = pstmt.executeUpdate();
					if (ch > 0) {
						pstmt = con.prepareStatement(
								"select ticketId,startLocation,destinationLocation,ticketDate,bookDate,passengerId,isPayment,isCanceled,paymentAmount from ticket where ticketId=? and userId=?");
						pstmt.setInt(1, ticketId);
						pstmt.setInt(2, userId);
						rs = pstmt.executeQuery();
						if (rs.next()) {
							if (rs.getInt(7) == 1) {
								payflag = true;
							} else {
								payflag = false;
							}
							if (rs.getInt(8) == 1) {
								cancelflag = true;
							} else {
								cancelflag = false;
							}

							ticket = new Ticket(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),
									rs.getInt(6), payflag, cancelflag, rs.getInt(9));
							return ticket;

						}
					}
				} catch (SQLException e) { // TODO Auto-generated catch
					e.printStackTrace();
				}

			} else {
				throw new TicketNotFoundException("Ticket Not Found");
			}
		} catch (SQLException e1) { // TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return ticket;
	}

	@Override
	public boolean cancelTicket(int ticketId, int userId) throws TicketNotFoundException {

		try {
			pstmt = con.prepareStatement("update ticket set isCanceled=1 where ticketId=? and userId=?");
			pstmt.setInt(1, ticketId);
			pstmt.setInt(2, userId);
			int ch = pstmt.executeUpdate();
			if (ch > 0) {
				return true;
			} else {
				throw new TicketNotFoundException("Ticket Not Found");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	protected void finalize() throws Throwable {

		super.finalize();
		if (rs != null) {
			rs.close();
		}
		if (pstmt != null) {
			pstmt.close();
		}
		if (con != null) {
			con.close();
		}
	}

}
