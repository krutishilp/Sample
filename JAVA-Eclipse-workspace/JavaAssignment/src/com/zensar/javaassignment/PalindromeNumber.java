package com.zensar.javaassignment;
public class PalindromeNumber {
	
	private int number;
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	public void checkPalindrome() {
		int temp=number;
		int digit=0;
		int rev=0;
		while(number>0) {
			digit=number%10;
			rev=(rev*10)+digit;
			number=number/10;
		}
		if(rev==temp) {
			System.out.println("The Number: "+temp+" is palindrome");
		}else {
			System.out.println("The Number: "+temp+" is not palindrome");
		}
	}

	public static void main(String[] args) {
		PalindromeNumber pn=new PalindromeNumber();
		int num; 
		num=252;
		pn.setNumber(num);
		pn.checkPalindrome();
		
		num=486;
		pn.setNumber(num);
		pn.checkPalindrome();
		
		
	}

}
