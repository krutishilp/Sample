package com.zensar.spring.beans;

import org.springframework.beans.factory.annotation.Required;

public class Student {
	
	private int studentId;
	private String studentName;
	private int studentMarks;

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
	@Required
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

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentMarks=" + studentMarks
				+ "]";
	}

}
