
/*
 * http://www.journaldev.com/2954/hibernate-query-language-hql-example-tutorial
 * Hibernate Query Language (HQL) Example Tutorial
 * 
 * 
 * http://websystique.com/hibernate/hibernate-one-to-one-unidirectional-with-foreign-key-associations-annotation-example/
 * Hibernate One-To-One Unidirectional with Foreign Key Associations (Annotation)
 * 
 * http://websystique.com/hibernate/hibernate-one-to-one-bidirectional-with-shared-primary-key-annotation-example/
 * Hibernate One-To-One Bidirectional with Shared Primary Key (Annotation)
 * 
 * 
 * http://viralpatel.net/blogs/hibernate-many-to-many-annotation-mapping-tutorial/
 * Hibernate Many To Many Annotation Mapping Tutorial
 * 
 * http://viralpatel.net/blogs/hibernate-one-to-many-annotation-tutorial/
 * Hibernate One To Many Annotation tutorial
 * 
 * http://websystique.com/hibernate/hibernate-many-to-one-unidirectional-annotation-example/
 * Hibernate Many-To-One Unidirectional (Annotation)
 * 
 * 
 * https://docs.jboss.org/hibernate/orm/3.6/reference/en-US/html/collections.html
 * Hibernate Reference Documentation ; Chapter 7. Collection mapping
 * 
 * 
 * http://what-when-how.com/hibernate/advanced-entity-association-mappings-hibernate/
 * Advanced entity association mappings (Hibernate)
 * 
 * 
 * SQL , FOREIGN KEY Constraint = A FOREIGN KEY in one table points to a PRIMARY KEY in another table. 
 * http://www.w3schools.com/sql/sql_foreignkey.asp
 * 
 * A foreign key is a field (or collection of fields) in one table that uniquely identifies a row of another table
 * https://en.wikipedia.org/wiki/Foreign_key
 * 
 * 
 */

package com.journaldev.hibernate.main;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.journaldev.hibernate.model.Employee;
import com.journaldev.hibernate.util.HibernateUtil;

public class HQLExamples {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		//Prep work
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		
		//Get All Employees
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from Employee");
		List<Employee> empList = query.list();
		for(Employee emp : empList){
			System.out.println("List of Employees::"+emp.getId()+","+emp.getAddress().getCity());
		}
		
		//Get Employee with id
		query = session.createQuery("from Employee where id= :id");
		query.setLong("id", 3);
		Employee emp = (Employee) query.uniqueResult();
		System.out.println("Employee Name="+emp.getName()+", City="+emp.getAddress().getCity());
		
		//Update Employee
		query = session.createQuery("update Employee set name= :name where id= :id");
		query.setParameter("name", "Pankaj Kumar");
		query.setLong("id", 1);
		int result = query.executeUpdate();
		System.out.println("Employee Update Status="+result);

		//Delete Employee, we need to take care of foreign key constraints too
		query = session.createQuery("delete from Address where id= :id");
		query.setLong("id", 4);
		result = query.executeUpdate();
		System.out.println("Address Delete Status="+result);
		
		query = session.createQuery("delete from Employee where id= :id");
		query.setLong("id", 4);
		result = query.executeUpdate();
		System.out.println("Employee Delete Status="+result);
		
		//Aggregate function examples
		query = session.createQuery("select sum(salary) from Employee");
		double sumSalary = (Double) query.uniqueResult();
		System.out.println("Sum of all Salaries= "+sumSalary);
		
		//join examples
		query = session.createQuery("select e.name, a.city from Employee e "
				+ "INNER JOIN e.address a");
		List<Object[]> list = query.list();
		for(Object[] arr : list){
			System.out.println(Arrays.toString(arr));
		}
		
		//rolling back to save the test data
		tx.rollback();
		
		//closing hibernate resources
		sessionFactory.close();
	}

}
