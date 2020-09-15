package com.zensar.multithreading;

public class MyThread extends Thread {

	private static PrintName name=new PrintName();
	public MyThread(String name) {
		super(name);
	}

	@Override
	public void run() {
		name.print(Thread.currentThread().getName());
	}
}
