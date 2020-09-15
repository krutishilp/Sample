package com.zensar.hibernate.entity;

/*@Entity
@Table(name="wageemployee")*/
public class WageEmployee extends Employee {

	private int hour;
	private int rate;
	public WageEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public WageEmployee(int employeeId, String employeeName, double employeeSalary,int hour,int rate) {
		super(employeeId, employeeName, employeeSalary);
		this.hour=hour;
		this.rate=rate;
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
	
	
}
