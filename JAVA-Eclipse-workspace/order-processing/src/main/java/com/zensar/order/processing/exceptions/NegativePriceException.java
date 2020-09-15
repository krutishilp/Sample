package com.zensar.order.processing.exceptions;

public class NegativePriceException extends Exception {

	public NegativePriceException(String msg) {
		super(msg);
	}
}
