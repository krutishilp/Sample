package com.zensar.myfirstproject.beans;

public class MyClass implements Printable,MyInterface {

	@Override
	public void print() {
		System.out.println("This is 1st from Interface Printable");
	}

	@Override
	public void print1() {
		//a=10;  //gives error bcz its Interface property which is by default final
		System.out.println(Printable.a); //here 'a' is an Interface property which is static by default 
		System.out.println("This is 2nd from Interface Printable");
	}

	@Override
	public void display() {
		System.out.println("This is from MyInterface");
		
	}

}
