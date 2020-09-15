package com.zensar.ticket_management.beans;

public class Passenger {

	private int passengerId;
	private String passengerName;
	private long passengerContact;
	private String passengerAddress;
	
	public Passenger() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Passenger(int passengerId, String passengerName, long passengerContact, String passengerAddress) {
		super();
		this.passengerId = passengerId;
		this.passengerName = passengerName;
		this.passengerContact = passengerContact;
		this.passengerAddress = passengerAddress;
	}

	public Passenger(String passengerName, long passengerContact, String passengerAddress) {
		super();
		this.passengerName = passengerName;
		this.passengerContact = passengerContact;
		this.passengerAddress = passengerAddress;
	}

	public long getPassengerContact() {
		return passengerContact;
	}

	public void setPassengerContact(long passengerContact) {
		this.passengerContact = passengerContact;
	}

	public int getPassengerId() {
		return passengerId;
	}
	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public String getPassengerAddress() {
		return passengerAddress;
	}
	public void setPassengerAddress(String passengerAddress) {
		this.passengerAddress = passengerAddress;
	}
	@Override
	public String toString() {
		return "Passenger [passengerId=" + passengerId + ", passengerName=" + passengerName + ", passengerAddress="
				+ passengerAddress + "]";
	}
	
	
}
