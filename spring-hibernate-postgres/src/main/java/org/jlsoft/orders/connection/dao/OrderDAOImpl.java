package org.jlsoft.orders.connection.dao;

import java.util.List;
import java.util.Date;

import javax.persistence.NoResultException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.jlsoft.orders.connection.model.ComenziVExt;
import org.jlsoft.orders.connection.model.Terti;
import org.hibernate.SessionFactory;
import org.hibernate.NonUniqueResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository

public class OrderDAOImpl implements OrderDAO  {

	@Autowired
	private SessionFactory sessionFactory;
	// Date LastorderDate;

	// http://www.tutorialspoint.com/hibernate/hibernate_criteria_queries.htm 
	// Session session = sessionFactory.openSession();
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public String getClientHqNameByCui(String cui) {
		String theHqName = new String(" ");
		// CMS =2  : tert incorect sau inactiv ?  
		Query query = getCurrentSession().createQuery("from Terti where cui= :cui and plt='00' and cms<>2");
		query.setParameter("cui", cui);
		// List<Terti> list = query.list();
		try {
			Terti oneTert = (Terti) query.uniqueResult();
			theHqName = oneTert.getDenumire(); 
		} 
		catch (NoResultException e) {
			 return null;
		}	
		catch(NonUniqueResultException e) {
	        throw new RuntimeException("Two Terti found with same cui ");
	    }
		
		return theHqName;
	}

	public Date getDateOfLastOrder(){
		Criteria criteria = getCurrentSession().createCriteria(ComenziVExt.class).setProjection(Projections.max("dataC")); 
		Date dateOfLastOrder = (Date)criteria.uniqueResult();
		return dateOfLastOrder;
	}
	
	
	public List<ComenziVExt> listOrders() {
		

        // Query taskQuery = getCurrentSession().createQuery(
        //         "from Timesheet t where t.task.id = :id");
        // taskQuery.setParameter("id", task.getId());
		
//		Criteria criteria = session
//			    .createCriteria(Person.class)
//			    .setProjection(Projections.max("age"));
//			Integer maxAge = (Integer)criteria.uniqueResult();
	
			// getDateOfLastOrder() => 
			Criteria criteria = getCurrentSession().createCriteria(ComenziVExt.class).setProjection(Projections.max("dataC")); 
			Date dateOfLastOrder = (Date)criteria.uniqueResult();
			
			// select * from Comenzi_V_Ext where com_id='0100896075' => OK ! 
			// 0100896774 => "Found shared references to a collection: org.jlsoft.orders.connection.model.Terti.cuisipuncte"

		// http://stackoverflow.com/questions/8984837/org-hibernate-objectnotfoundexception-no-row-with-the-given-identifier-exists
		//    Set log level to TRACE to see all steps and look for generated SQL when retrieving the objects.
		//    http://docs.jboss.org/hibernate/core/3.3/reference/en/html/session-configuration.html#configuration-logging
		//    http://stackoverflow.com/questions/436276/configuring-hibernate-logging-using-log4j-xml-config-file
		//    
		// http://stackoverflow.com/questions/9598890/hibernate-exception-found-two-representations-of-the-same-collection   
		//    
		// 
		// getCurrentSession().clear();
		
		// -- 
		//return sessionFactory.getCurrentSession().createQuery("from ComenziVExt where comId='0100896774'").list();
		// -- 
		
		// return ???!!! sessionFactory.getCurrentSession().get(ComenziVExt.class, new String("0100896774"));

	
			Query query = getCurrentSession().createQuery("from ComenziVExt where dataC= :dateOfLastOrder order by valoare desc");
			query.setParameter("dateOfLastOrder", dateOfLastOrder);
			// crit.addOrder(Order.asc("salary"));
			
			return query.list();


/*			
			How to work with Projection in Hibernate Criteria Query (HCQ)
			In this article we will discuss about making use of projections in Hibernate Criteria Query (HCQ).
			http://mrbool.com/how-to-work-with-projection-in-hibernate-criteria-query-hcq/26369

			Hibernate Criteria Example Tutorial
			http://www.journaldev.com/2963/hibernate-criteria-example-tutorial
			
*/
			
		// www.mkyong.com/hibernate/hibernate-query-examples-hql/
		// HQL Select Query Example
		// Query query = session.createQuery("from Stock where stockCode = '7277' ");
		// Query query = session.createQuery("from Stock where stockCode = :code ");
		// query.setParameter("code", "7277");
		// List list = query.list();

		// www.mkyong.com/hibernate/hibernate-native-sql-queries-examples/
		// Native SQL queries example
		// Query query = session.createSQLQuery("select s.stock_code from stock s where s.stock_code = :stockCode").setParameter("stockCode", "7277");
		// Query query = session.createSQLQuery("select * from stock s where s.stock_code = :stockCode").addEntity(Stock.class).setParameter("stockCode", "7277");
		// List result = query.list();
		
	}
}
