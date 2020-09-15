package com.zensar.myfirstproject.beans;

public abstract class Shape implements MyInterface {
	//here no need to implement methods of an MyInterface bcz Shape is a abstract class
	public Shape() {
		//we can create constructor of an abstract class and we invoke abstract constructor by using constructor of its child class
		System.out.println();
	}

	public void print() {
		System.out.println("Inside Shape...");
	}

	public abstract double calculateArea();
}
