package com.zensar.hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Address {

	private String state;
	@Id
	private int pinCode;

	//@OneToOne
	//private Employee employee;
	
	
	public Address() {
		super();
	}

	public Address(String state, int pinCode) {
		super();
		this.state = state;
		this.pinCode = pinCode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	/*
	 * public Employee getEmployee() { return employee; }
	 * 
	 * public void setEmployee(Employee employee) { this.employee = employee; }
	 */

	@Override
	public String toString() {
		return "Address [state=" + state + ", pinCode=" + pinCode + "]";
	}

}
