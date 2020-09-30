package com.zensar.practice.client;

public class App {

	
	public static void main(String[] args) {
		
		class Inner{
			public String msg;
			public Inner(String s) {
				msg=s;
			}
			
		}
		
		Object obj=new Inner("Inside Inner");
		Inner i=(Inner)obj;
		System.out.println(i.msg);
		
		
}
}
