package com.zensar.practice.beans;

import java.io.Serializable;

public class Address implements Serializable{
	private int flatNo;
	private String buildingName;
	private String streetName;
	
	
	public Address(int flatNo, String buildingName, String streetName) {
		super();
		this.flatNo = flatNo;
		this.buildingName = buildingName;
		this.streetName = streetName;
	}
	
	public int getFlatNo() {
		return flatNo;
	}


	public void setFlatNo(int flatNo) {
		this.flatNo = flatNo;
	}


	public String getBuildingName() {
		return buildingName;
	}


	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}


	public String getStreetName() {
		return streetName;
	}


	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}


	@Override
	public String toString() {
		return "Address [flatNo=" + flatNo + ", buildingName=" + buildingName + ", streetName=" + streetName + "]";
	}


	
	
	

}
