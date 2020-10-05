package com.zensar.spring.repository;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zensar.spring.beans.Product;
@Repository
public class ProductRepositoryImpl1 implements ProductRepository {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int insertProduct(Product product) {
		/*
		 * int productId=1; product.setProductId(productId);
		 */
		try (Session session = getSessionFactory().openSession()) {
			session.beginTransaction();
			session.save(product);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return product.getProductId();
	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> products = null;
		try (Session session = getSessionFactory().openSession()) {
			Query<Product> query = session.createQuery("FROM Product");
			products = query.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return products;

	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Product fetchProductById(int productId) {
		Product product = null;
		System.out.println("**********************");
		try (Session session = getSessionFactory().openSession()) {
			product = session.get(Product.class, productId);

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return product;
	}

	@Override
	public boolean deleteProductById(int productId) {
		try (Session session = getSessionFactory().openSession()) {
			session.beginTransaction();
			Query query = session.createQuery("delete from Product where productId= :productId");
			query.setParameter("productId", productId);
			int i = query.executeUpdate();
			if (i > 0) {
				return true;
			}
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Product updateProduct(Product product) {

		try (Session session = getSessionFactory().openSession()) {
			session.beginTransaction();
			session.update(product);
			product = session.get(Product.class, product.getProductId());
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return product;
	}

}
