package com.zensar.myfirstproject.beans;

public class Outer {

	private static int value=10;
	
	public static class Inner{
		int a=20;
		public void display() {
			
			System.out.println("Inner Class");
		}
	}
	
	void m1() {
		Inner i=new Outer.Inner();
		System.out.println(i.a);
	}
	
}
