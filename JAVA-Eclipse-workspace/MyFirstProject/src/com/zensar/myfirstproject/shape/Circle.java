package com.zensar.myfirstproject.shape;

import com.zensar.myfirstproject.beans.Shape;

public class Circle extends Shape{

	private int radius;

	public Circle(int radius) {
		this.radius = radius;

	}

	public Circle() {
		radius = 5;

	}

	public void setRadius(int rad) {
		radius = rad;
	}

	public double calculateArea() {
		return (3.14 * radius * radius);
	}

	@Override
	public void display() {
		//This is method of MyInterface bcz Shape is implemented MyInterface
		
	}

}
