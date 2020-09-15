package com.zensar.javaassignment;

public class SwapNumbers {

	public static void main(String[] args) {
		int num1 = 10;
		int num2 = 20;
		System.out.println("Swapping two Number without using third variable...");
		
		System.out.println("Before Swapping: ");
		System.out.println("Number1:" + num1 + " Number2:" + num2);

		num1 = num1 + num2;
		num2 = num1 - num2;
		num1 = num1 - num2;

		System.out.println("After Swapping: ");
		System.out.println("Number1:" + num1 + " Number2:" + num2);

	}

}
