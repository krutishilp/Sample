package com.zensar.spring.exception;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ArithmeticException.class)
	public String exceptionHandler() {
		return "arithmeticException";
	}
	
	@ExceptionHandler(Exception.class)
	public String allExceptionHandler() {
		return "allException";
	}
}
