package com.zensar.ticket_management.beans;

public class Ticket {

	private int ticketId;
	private String startLocation;
	private String destLocation;
	private String ticketDate;
	private String bookDate;
	private int passangerNo;
	private boolean payment;
	public String getBookDate() {
		return bookDate;
	}

	public void setBookDate(String bookDate) {
		this.bookDate = bookDate;
	}

	private boolean canceled = false;
	private int paymentAmount;

	public Ticket(int ticketId, String startLocation, String destLocation, String ticketDate,String bookDate, int passangerNo,
			boolean payment, boolean canceled, int paymentAmount) {
		super();
		this.ticketId = ticketId;
		this.startLocation = startLocation;
		this.destLocation = destLocation;
		this.ticketDate = ticketDate;
		this.bookDate=bookDate;
		this.passangerNo = passangerNo;
		this.payment = payment;
		this.canceled = canceled;
		this.paymentAmount = paymentAmount;
	}

	public Ticket(String startLocation, String destLocation,String ticketDate ,int paymentAmount) {
		super();
		this.startLocation = startLocation;
		this.destLocation = destLocation;
		this.ticketDate=ticketDate;
		this.paymentAmount = paymentAmount;
	}

	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public String getStartLocation() {
		return startLocation;
	}

	public void setStartLocation(String startLocation) {
		this.startLocation = startLocation;
	}

	public String getDestLocation() {
		return destLocation;
	}

	public void setDestLocation(String destLocation) {
		this.destLocation = destLocation;
	}

	public String getTicketDate() {
		return ticketDate;
	}

	public void setTicketDate(String ticketDate) {
		this.ticketDate = ticketDate;
	}

	public int getPassangerNo() {
		return passangerNo;
	}

	public void setPassangerNo(int passangerNo) {
		this.passangerNo = passangerNo;
	}

	public boolean isPayment() {
		return payment;
	}

	public void setPayment(boolean payment) {
		this.payment = payment;
	}

	public boolean isCanceled() {
		return canceled;
	}

	public void setCanceled(boolean canceled) {
		this.canceled = canceled;
	}

	public int getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(int paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", startLocation=" + startLocation + ", destLocation=" + destLocation
				+ ", travelDate=" + ticketDate + ", bookDate=" + bookDate + ", passangerNo=" + passangerNo
				+ ", payment=" + payment + ", canceled=" + canceled + ", paymentAmount=" + paymentAmount + "]";
	}

}
