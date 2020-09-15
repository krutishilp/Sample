package com.zensar.javaassignment;

public class FibonacciSeries {

	private int number;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void generateFibonacci() {
		int num1 = 0;
		int num2 = 1;
		int num3;
		System.out.print(num1 + " " + num2);
		for (int i = 2; i < number; i++) {
			num3 = num1 + num2;
			System.out.print(" " + num3);
			num1 = num2;
			num2 = num3;
		}

	}

	public static void main(String[] args) {
		FibonacciSeries fs = new FibonacciSeries();
		fs.setNumber(10);
		System.out.print("Fibonacci Series :- ");
		fs.generateFibonacci();
	}

}
