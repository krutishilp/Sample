package com.zensar.productmanagement.beans;

public class User {

	private int userId;
	private String userName;
	private long userContact;
	private String userAddress;
	
	
	
	
	public User(String userName, long userContact, String userAddress) {
		super();
		this.userName = userName;
		this.userContact = userContact;
		this.userAddress = userAddress;
	}


	public User(int userId, String userName, long userContact, String userAddress) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userContact = userContact;
		this.userAddress = userAddress;
	}
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public long getUserContact() {
		return userContact;
	}
	public void setUserContact(long userContact) {
		this.userContact = userContact;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userContact=" + userContact + ", userAddress="
				+ userAddress + "]";
	}
	
	
	
}
