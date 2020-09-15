package com.zensar.spring.beans;

public class Address {

	private int pinCode;
	private String city;
	private String state;

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(int pinCode, String city, String state) {
		super();
		this.pinCode = pinCode;
		this.city = city;
		this.state = state;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Address [pinCode=" + pinCode + ", city=" + city + ", state=" + state + "]";
	}
}
