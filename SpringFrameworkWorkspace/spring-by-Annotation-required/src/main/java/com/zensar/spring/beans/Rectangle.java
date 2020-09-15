package com.zensar.spring.beans;

import org.springframework.stereotype.Component;

@Component
public class Rectangle implements Shapeable {

	public String area() {
		return "This is area of Reactangle";
	}

}
