package com.zensar.myfirstproject.beans;

public class SalesPerson extends WageEmployee {
	
	private int commission;
	
	public SalesPerson(int empId, String empName, double empSalary, int hour, int rate, int commission) {
		super(empId, empName, empSalary, hour, rate);
		this.commission = commission;
	}
	
	public SalesPerson() {
		// TODO Auto-generated constructor stub
	}
	
	public double calculateSalary() {
		return super.calculateSalary()+commission;
	}


	@Override
	public String toString() {
		return super.toString()+" "+"SalesPerson [commission=" + commission + "]";
	}
	
	
}
