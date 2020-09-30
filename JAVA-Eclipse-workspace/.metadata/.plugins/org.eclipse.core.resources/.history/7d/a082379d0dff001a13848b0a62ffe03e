package com.zensar.practice.beans;

public class WageEmployee extends Employee {
	/* public class WageEmployee extends Employee{ */
	private int hour;
	private int rate;
	private static int cnt = 0;
	private static WageEmployee we = null;

	public WageEmployee(int empId, String empName, Address address, int hour, int rate) {
		super(empId, empName, address);
		this.hour = hour;
		this.rate = rate;
		cnt++;
	}

	private WageEmployee() {
		super();
		cnt++;
		// TODO Auto-generated constructor stub
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	@Override
	public String toString() {
		return super.toString() + "WageEmployee [hour=" + hour + ", rate=" + rate + "]";
	}

	public double calculateArea() {
		return super.calculateArea() + hour * rate;
	}

	public static WageEmployee getInstance() {
		
		Address address = new Address(10, "Shree Apartment", "Vani-Pimpalgoan Road");
		if (cnt == 0) {
			we = new WageEmployee(1001, "Krutishil",address,10,1000);
		}
		return we;
	}
}
