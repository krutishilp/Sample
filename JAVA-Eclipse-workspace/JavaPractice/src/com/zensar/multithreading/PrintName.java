package com.zensar.multithreading;

public class PrintName {

	synchronized void print(String name) {
		for(int i=0;i<10;i++) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Hello: "+name);
		}
	}
	
	
}
