package com.zensar.hibernate.client;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.zensar.hibernate.entity.Address;
import com.zensar.hibernate.entity.Employee;

public class Test {

	public static void main(String[] args) {

		/*
		 * Employee employee=new Employee(1002,"SK",60000);
		 * 
		 * Configuration configuration=new Configuration(); SessionFactory
		 * sessionFactory = configuration.configure().buildSessionFactory(); Session
		 * session = sessionFactory.openSession(); Transaction transaction =
		 * session.beginTransaction(); session.save(employee);
		 * 
		 * transaction.commit();
		 *
		 *
		 * 
		 */

		Employee employee = new Employee(1002, "SK", 5000);
		Address address1=new Address("Maharashtra", 422215);
		Address address2=new Address("MP", 422260);
		List<Address> addresses=new ArrayList<Address>();
		addresses.add(address1);
		addresses.add(address2);
		employee.setAddress(addresses);
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		session.save(employee);
		session.save(address1);
		session.save(address2);
		t.commit();

	}

}
