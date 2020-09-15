package com.zensar.practice.beans;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializationCode {

	public static void main(String[] args) {
		//Employee emp;
		WageEmployee emp;
		ObjectInputStream ois=null;
		try {
			ois=new ObjectInputStream(new FileInputStream("employee.ser"));
			//emp=(Employee)ois.readObject();
			emp=(WageEmployee)ois.readObject();
			System.out.println("Deserialization Successful...");
			System.out.println(emp);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(ois!=null) {
				try {
					ois.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
