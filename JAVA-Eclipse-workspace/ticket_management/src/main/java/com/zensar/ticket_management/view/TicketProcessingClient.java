package com.zensar.ticket_management.view;

import java.util.Scanner;

import com.zensar.ticket_management.beans.Ticket;
import com.zensar.ticket_management.exceptions.NegativePriceException;
import com.zensar.ticket_management.exceptions.NegativeQuantityException;
import com.zensar.ticket_management.exceptions.TicketNotFoundException;
import com.zensar.ticket_management.service.TicketService;
import com.zensar.ticket_management.serviceprovider.TicketServiceProvider;

public class TicketProcessingClient {

	public static void main(String[] args) {

		TicketService os = TicketServiceProvider.getService();
		Scanner sc = new Scanner(System.in);
		String resp = "", response = "";
		int choice;
		int ticketId;
		Ticket ticket = null;
		String startLocation = "";
		String destinationLocation = "";
		int userId = 0;
		String userPassword;
		String passengerName;
		String passengerAddress;
		long passengerContact;
		boolean flag = false;
		int payment = 0;
		String ticketDate;
		boolean validatePassenger = false;
		do {
			System.out.println("**************** Welcome to Ticket Processing System *****************");
			System.out.println("Please Select your Choice:");
			System.out.println("1.Login");
			System.out.println("2.Register");
			choice = sc.nextInt();
			switch (choice) {

			case 1:
				System.out.println("Please Enter your User Id: ");
				userId = sc.nextInt();
				System.out.println("Please Enter your Password: ");
				userPassword = sc.next();
				validatePassenger = os.validateUser(userId, userPassword);
				System.out.println(validatePassenger);
				break;
			case 2:
				System.out.println("Please Enter your Name: ");
				String userName = sc.next();
				System.out.println("Please Enter your  Contact Number: ");
				long userContact = sc.nextLong();
				System.out.println("Please Enter your  Address: ");
				String userAddress = sc.next();
				System.out.println("Please Enter Password: ");
				userPassword = sc.next();
				int regId = os.registerUser(userName, userContact, userAddress, userPassword);
				System.out.println("Your Registration Id is: " + regId);
				break;

			default:
				System.out.println("Invalid Choice..");
			}

			if (validatePassenger) {

				do {
					System.out.println("**************** Welcome to Ticket Processing System *****************");
					System.out.println("1.Book a Ticket");
					System.out.println("2.Display All Booked Tickets");
					System.out.println("3.View Particular Ticket");
					System.out.println("4.Update an Ticket");
					System.out.println("4.Cancel an Ticket");

					System.out.println("Please Enter Your Choice: ");
					choice = sc.nextInt();

					switch (choice) {

					case 1:

						do {
							System.out.println("Please Enter Passenger Name: ");
							passengerName = sc.next();
							System.out.println("Please Enter Passenger Contact Number: ");
							passengerContact = sc.nextLong();
							System.out.println("Please Enter Passenger Address: ");
							passengerAddress = sc.next();

							System.out.println("Please Select Start Location:");
							System.out.println("1.Nashik");
							System.out.println("2.Pune");
							System.out.println("3.Mumbai");

							System.out.println("Start Location: ");
							choice = sc.nextInt();
							switch (choice) {

							case 1:
								startLocation = "Nashik";
								break;
							case 2:
								startLocation = "Pune";
								break;
							case 3:
								startLocation = "Mumbai";
								break;
							default:
								System.out.println("Invalid Choice..");
							}

							System.out.println("Please Enter Destination Location:");
							System.out.println("1.Nashik");
							System.out.println("2.Pune");
							System.out.println("3.Mumbai");
							System.out.println("Destination Location: ");
							choice = sc.nextInt();
							switch (choice) {

							case 1:
								destinationLocation = "Nashik";
								break;
							case 2:
								destinationLocation = "Pune";
								break;
							case 3:
								destinationLocation = "Mumbai";
								break;
							default:
								System.out.println("Invalid Choice..");
							}
							System.out.println("Please Enter Travel Date: (DD/MM/YYYY)");
							ticketDate=sc.next();
							if (!startLocation.equalsIgnoreCase(destinationLocation)) {

								if (startLocation.equalsIgnoreCase("Nashik")
										&& destinationLocation.equalsIgnoreCase("Pune")) {
									System.out.println("Please Pay Amount(Rs.500):");
									payment = sc.nextInt();
									if (payment == 500) {
										flag = true;
										System.out.println("Thank You, Payment Successful....");

									} else {
										System.out.println("Sorry,Payment Failed");
									}
								}

								if (startLocation.equalsIgnoreCase("Nashik")
										&& destinationLocation.equalsIgnoreCase("Mumbai")) {
									System.out.println("Please Pay Amount(Rs.400):");
									payment = sc.nextInt();
									if (payment == 400) {
										flag = true;
										System.out.println("Thank You, Payment Successful....");

									} else {
										System.out.println("Sorry,Payment Failed");
									}
								}

								if (startLocation.equalsIgnoreCase("Pune")
										&& destinationLocation.equalsIgnoreCase("Nashik")) {
									System.out.println("Please Pay Amount(Rs.500):");
									payment = sc.nextInt();
									if (payment == 500) {
										flag = true;
										System.out.println("Thank You, Payment Successful....");

									} else {
										System.out.println("Sorry,Payment Failed");
									}
								}

								if (startLocation.equalsIgnoreCase("Pune")
										&& destinationLocation.equalsIgnoreCase("Mumbai")) {
									System.out.println("Please Pay Amount(Rs.600):");
									payment = sc.nextInt();
									if (payment == 600) {
										flag = true;
										System.out.println("Thank You, Payment Successful....");
									} else {
										System.out.println("Sorry,Payment Failed");
									}
								}

								if (startLocation.equalsIgnoreCase("Mumbai")
										&& destinationLocation.equalsIgnoreCase("Nashik")) {
									System.out.println("Please Pay Amount(Rs.400):");
									payment = sc.nextInt();
									if (payment == 400) {
										flag = true;
										System.out.println("Thank You, Payment Successful....");

									} else {
										System.out.println("Sorry,Payment Failed");
									}
								}

								if (startLocation.equalsIgnoreCase("Mumbai")
										&& destinationLocation.equalsIgnoreCase("Pune")) {
									System.out.println("Please Pay Amount(Rs.600):");
									payment = sc.nextInt();
									if (payment == 600) {
										flag = true;
										System.out.println("Thank You, Payment Successful....");

									} else {
										System.out.println("Sorry,Payment Failed");
									}
								}
								
								
								if (flag) {
									int ticketNumber = os.placeTicket(passengerName, passengerContact, passengerAddress,
											startLocation, destinationLocation,ticketDate, payment, userId);
									System.out.println("Your Ticket Number is: " + ticketNumber);

								}

							} else {
								System.out.println("Sorry, Start and Destination should not be Same !!");
							}

							System.out.println("Do you want to book more Tickets ?(Yes/No)");
							resp = sc.next();
						} while (resp.equalsIgnoreCase("Yes"));

						break;

					case 2:
						Ticket[] tickets = os.displayAllTickets(userId);
						for (Ticket or : tickets) {
							if (or != null) {
								System.out.println(or);
							}
						}
						break;
					case 3:
						System.out.println("Please Enter Ticket Id:");
						ticketId = sc.nextInt();
						try {
							ticket = os.getTicket(ticketId, userId);
							System.out.println(ticket);
						} catch (TicketNotFoundException e) {
							System.out.println("Sorry, Ticket with Id: " + ticketId + " not Found !!");
						}
						break;

					case 4:
						System.out.println("Please Enter Ticket Id:");
						ticketId = sc.nextInt();
						try {
							ticket = os.updateTicket(ticketId,userId);
							System.out.println("Updated ticket: " + ticket);
						} catch (TicketNotFoundException e1) {
							System.out.println("Sorry, Ticket with Id: " + ticketId + " not Found !!");
						}
						break;

					case 5:
						System.out.println("Please Enter Ticket Id:");
						ticketId = sc.nextInt();
						boolean or = false;
						try {
							or = os.cancelTicket(ticketId, userId);
						} catch (TicketNotFoundException e) {
							System.out.println("Sorry, Ticket with Id: " + ticketId + " not Found !!");
						}
						if (or) {
							System.out.println("Ticket Canceled Successfully !!");
						}
						break;

					default:
						System.out.println("Invalid Choice..");
					}

					System.out.println("Do you want to Continue ?(Yes/No)");
					response = sc.next();
					if (response.equalsIgnoreCase("No")) {
						System.out.println("Thank You ");
					}
				} while (response.equalsIgnoreCase("Yes"));

			}else {
				System.out.println("Sorry,Login failed Invalid userId or Password !!");
			}

			System.out.println("Do You want to Exit from Application ?(Yes/No)");
			response = sc.next();
			if (response.equalsIgnoreCase("yes")) {
				System.out.println("Thank you for using our Service :) ");
			}
		} while (response.equalsIgnoreCase("no"));
	}

}