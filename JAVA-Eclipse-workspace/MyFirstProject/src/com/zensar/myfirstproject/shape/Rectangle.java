package com.zensar.myfirstproject.shape;

import com.zensar.myfirstproject.beans.Shape;

public class Rectangle extends Shape{
	private int length;
	private int breadth;

	public Rectangle(int length, int breadth) {
		this.length = length;
		this.breadth = breadth;
	}

	public Rectangle() {
		length = 5;
		breadth = 10;
	}

	public void setLength(int len) {
		length = len;
	}

	public void setBreadth(int bth) {
		breadth = bth;
	}

	public double calculateArea() {
		return (length * breadth);
	}

	@Override
	public void display() {
		//This is method of MyInterface bcz Shape is implemented MyInterface
		
	}
}
