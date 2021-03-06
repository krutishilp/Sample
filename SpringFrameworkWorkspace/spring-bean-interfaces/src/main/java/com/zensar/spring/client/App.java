package com.zensar.spring.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zensar.spring.beans.Circle;
import com.zensar.spring.beans.Shapeable;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Shapeable shape = context.getBean("shape", Shapeable.class);
		System.out.println(shape.area());
	}
}
