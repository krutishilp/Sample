package com.zensar.spring.beans;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Student {

	private int studentId;
	private String studentName;
	private int studentMarks;
	private List<Address> address;
	private Properties certification;

	public Student() {
		super();
		System.out.println("Inside Default Constructor of Student....");
	}

	public Student(int studentId, String studentName, int studentMarks) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentMarks = studentMarks;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getStudentMarks() {
		return studentMarks;
	}

	public void setStudentMarks(int studentMarks) {
		this.studentMarks = studentMarks;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public Properties getCertification() {
		return certification;
	}

	public void setCertification(Properties certification) {
		this.certification = certification;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentMarks=" + studentMarks
				+ ", address=" + address + ", certification=" + certification + "]";
	}

}
