package com.zensar.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zensar.spring.beans.Student;
@Configuration
public class SpringConfiguration {
	@Bean("student")
	public Student getStudent() {
		return new Student(1001,"Krutishil",50000);
	}
}
