package com.zensar.spring.client;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import com.zensar.spring.beans.Employee;

public class Test {

	public static void main(String[] args) {

		/*
		 * ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
		 */
		Resource resource=new FileSystemResource("beans.xml");
		BeanFactory factory=new XmlBeanFactory(resource);
		Employee employee=(Employee)factory.getBean("emp");
		
		System.out.println(employee);
	}

}
