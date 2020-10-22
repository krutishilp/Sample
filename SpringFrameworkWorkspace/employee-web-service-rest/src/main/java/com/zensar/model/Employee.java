package com.zensar.model;

public class Employee {

	private int Id;
	private String userName;
	private String password;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int iD, String userName, String password) {
		super();
		this.Id = iD;
		this.userName = userName;
		this.password = password;
	}

	public int getId() {
		return Id;
	}

	public void setId(int iD) {
		Id = iD;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Employee [ID=" + Id + ", userName=" + userName + ", password=" + password + "]";
	}

}
