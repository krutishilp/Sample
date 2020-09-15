package com.zensar.javaassignment;

public class ConvertNumber {
	
	public void decToBinary(int num) {
		int[] binNumber=new int[40];
		int i=0;
		while(num>0) {
			binNumber[i]=num%2;
			num=num/2;
			i++;
		}
		
		for(int j=i-1;j>=0;j--) {
			System.out.print(binNumber[j]);
		}
		
	}
	
	public void binToDecimal(int binNum) {
		int cnt=1;
		int decimal=0;
		while(binNum>0) {
			int rem=binNum%10;
			decimal=decimal+rem*cnt;
			binNum=binNum/10;
			cnt=cnt*2;	
		}
		System.out.println(decimal);
	}

	public static void main(String[] args) {
		
		ConvertNumber cn=new ConvertNumber();
		System.out.print("Binary Representation: ");
		cn.decToBinary(6);
		System.out.println();
		System.out.print("Decimal Representation: ");
		cn.binToDecimal(110);
		 
	}

}
