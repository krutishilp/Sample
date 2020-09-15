package com.zensar.spring.client;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.zensar.spring.beans.Student;
import com.zensar.spring.config.SpringConfiguration;

public class App 
{
    public static void main( String[] args )
    {
       AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(SpringConfiguration.class);
       Student student=(Student)context.getBean("student",Student.class);
       System.out.println(student);
       
    }
}
