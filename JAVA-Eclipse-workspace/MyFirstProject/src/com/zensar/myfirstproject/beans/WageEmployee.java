package com.zensar.myfirstproject.beans;

import java.io.FileNotFoundException;
import java.io.IOException;

public class WageEmployee extends Employee {
	
	private int hour;
	private int rate;
	public WageEmployee(int empId, String empName, double empSalary, int hour, int rate) {
		super(empId, empName, empSalary);
		this.hour = hour;
		this.rate = rate;
	}
	public WageEmployee() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return super.toString()+" "+"WageEmployee [hour=" + hour + ", rate=" + rate + "]";
	}

	public double calculateSalary(){
		return super.calculateSalary()+hour*rate;
		
	}
	
}
