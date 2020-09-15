package com.zensar.javaassignment;

public class ArmstrongNumber {

	private int number;


	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void checkArmstrong() {
		int temp = number;
		int digit = 0;
		int sum = 0;
		while (number > 0) {
			digit = number % 10;
			number = number / 10;
			sum = sum + (digit * digit * digit);
		}
		if (sum == temp) {
			System.out.println("The number is Armstrong Number.....");
		} else {
			System.out.println("The number is not Armstrong Number.....");
		}
	}

	public static void main(String[] args) {
		ArmstrongNumber an = new ArmstrongNumber();
		an.setNumber(153);
		System.out.println("Number: " + an.getNumber());
		an.checkArmstrong();
		an.setNumber(155);
		System.out.println("Number: " + an.getNumber());
		an.checkArmstrong();

	}

}
