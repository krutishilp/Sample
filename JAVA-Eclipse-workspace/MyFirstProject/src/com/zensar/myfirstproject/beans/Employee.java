package com.zensar.myfirstproject.beans;

import java.io.IOException;

public class Employee {
	private int empId;
	private String empName;
	private double empSalary;
	//private MyDate birthDay;

	public Employee(int empId, String empName, double empSalary) {
		this.empId = empId;
		this.empName = empName;
		this.empSalary = empSalary;
	}

	/*
	 * public Employee(int empId, String empName, double empSalary, MyDate birthDay)
	 * { this.empId = empId; this.empName = empName; this.empSalary = empSalary;
	 * this.birthDay = birthDay; }
	 */

	public Employee() {

	}

	/*
	 * public void printEmpDetails() {
	 * System.out.println(this.empId+"-"+this.empName+"-"+this.empSalary+"-"+
	 * birthDay.printDate()); //System.out.println(empId + "-" + empName + "-" +
	 * empSalary + "-" + birthDay.printDate()); }
	 */
	

	public int getEmpId() {
		return empId;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empSalary=" + empSalary+"]";
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public double getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}

	/*
	 * public MyDate getBirthDay() { return birthDay; }
	 * 
	 * public void setBirthDay(MyDate birthDay) { this.birthDay = birthDay; }
	 */
	public double calculateSalary(){
		return 0;
	}

	public boolean equals(Object emp) {
		Employee employee=(Employee)emp;
		
		if(employee.empId==this.empId && employee.empName==this.empName && employee.empSalary==this.empSalary) {
			return true;
		}
		return false;
	} 

}
