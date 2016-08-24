package com.javacodegeeks.example;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateTutorialTest {
	private static SessionFactory factory;
	private static ServiceRegistry serviceRegistry;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Configuration config = new Configuration();
		config.configure();
		config.addAnnotatedClass(User.class);
		config.addResource("User.hbm.xml");
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		factory = config.buildSessionFactory(serviceRegistry);
		
		HibernateTutorialTest hbTest = new HibernateTutorialTest();
		hbTest.insertUser(1,"Mark","Johnson","mark.johnson@gmail.com","mjohnson");
		hbTest.insertUser(2,"Samuel","Johnson","sam.johnson@gmail.com","sjohnson");
		
		List<User> users = hbTest.listUsers();
		for(User u : users){
			System.out.print(u.getId() + " ");
			System.out.print(u.getFirstname() + " ");
			System.out.print(u.getLastname() + " ");
			System.out.print(u.getEmail() + " ");
			System.out.print(u.getUsername() + " ");
			System.out.println();
		}

	}
	
	private int insertUser(int id, String fname, String lname, String email, String username)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		Integer userIdSaved = null;
		try {
			tx = session.beginTransaction();
			User u = new User(id,fname,lname,email,username);
			userIdSaved = (Integer) session.save(u);
			tx.commit();
		} catch(HibernateException ex) {
			if(tx != null)
				tx.rollback();
			ex.printStackTrace();
		} finally {
			session.close();
		}
		
		return userIdSaved;
		
	}
	
	private List listUsers()
	{
		Session sesn = factory.openSession();
		Transaction tx = null;
		List users = new ArrayList();
		try{
			tx = sesn.beginTransaction();
			users = (List)sesn.createQuery("From User").list();
			tx.commit();
		} catch(HibernateException e) {
			e.printStackTrace();
		} finally {
			sesn.close();
		}
		
		return users;
	}

}
