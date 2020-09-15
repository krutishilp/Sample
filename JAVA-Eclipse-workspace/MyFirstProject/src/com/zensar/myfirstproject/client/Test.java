package com.zensar.myfirstproject.client;

import java.util.ArrayList;
import java.util.Iterator;

public class Test {

	public static void main(String[] args) {
		
		/*
		 * MyDate date = new MyDate(29, 07, 1998); Employee employee = new
		 * Employee(1001, "Krutishil", 100055.00, date) ;
		 */

		// employee.printEmpDetails();

		/*
		 * Circle circle=new Circle(10); System.out.println(circle.calculateArea());
		 */

		/*
		 * WageEmployee wageEmployee=new WageEmployee(1001, "krutishil", 0, 10, 1000);
		 * System.out.println(wageEmployee.calculateSalary());
		 * System.out.println(wageEmployee);
		 */

		/*
		 * SalesPerson salesPerson=new SalesPerson(1001, "Krutishil ", 0, 10, 1000,
		 * 500); System.out.println(salesPerson.calculateSalary());
		 * System.out.println(salesPerson);
		 */

		/*
		 * Employee employee1 = new Employee(1001, "Krutishil", 20000); Employee
		 * employee2 = new Employee(1001, "Krutishil", 20000);
		 * 
		 * if (employee1.equals(employee2)) { System.out.println("Equals"); } else {
		 * System.out.println("Not Equals"); }
		 */
		
		/*
		 * Shape[] shape=new Shape[5];
		 * 
		 * shape[0]=new Circle(); shape[1]=new Circle(10); shape[2]=new Rectangle();
		 * shape[3]=new Rectangle(10,20); shape[4]=new Circle();
		 * 
		 * System.out.println("...............................................");
		 * 
		 * for (int i=0;i<shape.length;i++) {
		 * System.out.println("Area is "+shape[i].calculateArea()); }
		 */
		
		
		/*
		 * MyClass myClass=new MyClass(); myClass.print(); myClass.print1();
		 * myClass.display();
		 */
		/*
		 * DayOfWeek val=DayOfWeek.FRI; System.out.println(val.ordinal());
		 */
		  
		
		/*
		 * Inner i=new Outer.Inner(); i.display();
		 */
		
	
		int[][] a=new int[10][];
		ArrayList arr=new ArrayList();
		
		arr.add(10);
		arr.add(20);
		arr.add(30);
		arr.add(40);
		arr.add("xcvbbvcxz");
		arr.add(60);
		System.out.println(arr);
		System.out.println();
		
		Iterator iterator = arr.iterator();
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		
	}

}
