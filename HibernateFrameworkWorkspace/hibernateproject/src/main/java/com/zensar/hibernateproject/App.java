package com.zensar.hibernateproject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.zensar.hibernateproject.entity.Product;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {

		/*//xml way
		 * Student student=new Student(11, "KP", 22); Configuration configuration=new
		 * Configuration(); SessionFactory sessionFactory =
		 * configuration.configure().buildSessionFactory();
		 */
    	//annotation way
    	Product product=new Product(10,"Laptop",2500);
    	AnnotationConfiguration a=null;
    	SessionFactory sessionFactory =new AnnotationConfiguration().configure().addAnnotatedClass(Product.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		//Product product=(Product)session.get(Product.class, 10);
	session.save(product);
		//System.out.println(product);
		transaction.commit();
		
		
    }
}
