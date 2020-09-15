package com.zensar.practice.client;

import com.zensar.multithreading.MyThread;

public class MultithreadingClient {

	public static void main(String[] args) {
		
		MyThread t1=new MyThread("Dhoni");
		MyThread t2=new MyThread("Sachine");
		MyThread t3=new MyThread("Yuvi");
		t1.start();
		t2.start();
		t3.start();
		
		/*
		 * MyThreadRunnable mr1=new MyThreadRunnable(); Thread thread1=new Thread(mr1);
		 * thread1.start();
		 */
		
		//System.out.println(Thread.currentThread());
	}
}
