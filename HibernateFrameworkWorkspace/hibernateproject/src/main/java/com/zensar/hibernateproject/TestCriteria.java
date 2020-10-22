package com.zensar.hibernateproject;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.zensar.hibernateproject.entity.Student;
//Criteria in hibernate
public class TestCriteria {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Configuration configuration=new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Student.class);
		//criteria.add(Restrictions.eq("studentName", "KP"));
		//criteria.add(Restrictions.gt("studentAge",24));
		//criteria.add(Restrictions.lt("studentAge",24));
		//criteria.add(Restrictions.like("studentName", "KP%"));
		//criteria.add(Restrictions.between("studentAge",18,24));
		
		/*
		 * Criterion age = Restrictions.gt("studentAge", 20); Criterion name =
		 * Restrictions.like("studentName","s%");
		 * 
		 * //LogicalExpression orExp = Restrictions.or(age, name); LogicalExpression
		 * orExp = Restrictions.and(age, name); criteria.add( orExp );
		 */
		
		//criteria.setProjection(Projections.avg("studentAge"));
		//criteria.setProjection(Projections.min("studentAge"));
		//criteria.setProjection(Projections.max("studentAge"));
		//criteria.setProjection(Projections.rowCount());
		
		//criteria.addOrder(Order.asc("studentId"));
		criteria.addOrder(Order.desc("studentId"));
		
		List<Student> list = criteria.list();
		Iterator<Student> iterator = list.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		transaction.commit();
	}

}
