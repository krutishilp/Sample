package com.zensar.hibernate.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.zensar.hibernate.entity.Employee;
import com.zensar.hibernate.entity.WageEmployee;

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
		Employee wageemployee = new WageEmployee(1001, "KRuti", 1000, 20, 1000);
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		session.save(employee);
		session.save(wageemployee);
		t.commit();

	}

}
