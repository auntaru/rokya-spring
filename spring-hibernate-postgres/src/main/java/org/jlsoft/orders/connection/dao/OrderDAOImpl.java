package org.jlsoft.orders.connection.dao;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Date;

import javax.persistence.NoResultException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
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
	
	// public Object[] getSumOfVasluesAndNrOfOrdersByDay(Date theDayOfLastOrder){
	// public Object[] getSumOfOrdersAndValuesByDay(){
	public String getSumOfOrdersValuesOnLastDay(Date dateOfLastOrder ){
		
/*		
		// Criteria criteria2 = getCurrentSession().createCriteria(ComenziVExt.class).setProjection(Projections.sum("valoare")); 
		// criteria2.setProjection(Projections.rowCount());
		// criteria2.add(Restrictions.like("dataC", dateOfLastOrder));
		Date lastDay = new Date();
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		    try {
		    	lastDay = formatter.parse("2015-08-28");
		    } catch (ParseException e) {
		        e.printStackTrace();
		    }
        criteria2.add(Restrictions.like("CAST(data_c as TEXT)",lastDay ));
        // select sum(valoare) from comenzi_v_ext where  CAST(data_c as TEXT) like '2015-08-28'
        // http://www.question-defense.com/2010/02/08/no-operator-matches-the-given-name-and-argument-types-you-might-need-to-add-explicit-type-casts
        Object oneObject = criteria2.uniqueResult();
        return (String) oneObject;
*/
		
		// criteria2.setMaxResults(1);
		// List<Object[]> oneObject = criteria2.list();
		// Object[] oneObject = (Object[]) criteria2.uniqueResult();
		
		// bethecoder.com/applications/tutorials/hibernate/hibernate-query-language/min-max-aggregate-functions.html

		// List<Object[]> list = criteria.list();  
		// for(Object[] arr : list){
        //    System.out.println(Arrays.toString(arr));
        // }
		
		// String hql = "select sum(valoare) from ComenziVExt where CAST(dataC as TEXT) like '2015-08-28'";
		// String hql = "select sum(valoare) from ComenziVExt where dataC = '2015-08-28'";
		String hql = "select sum(valoare) from ComenziVExt where dataC = :dlo";
		Query query = getCurrentSession().createQuery(hql);
		query.setParameter("dlo", dateOfLastOrder);
		List listResult = query.list();
		BigDecimal number = (BigDecimal) listResult.get(0);
		return number.toString();
	}

	public String getCountOfOrdersOnLastDay(Date dateOfLastOrder ){
		// select count(*) from comenzi_v_ext where data_c = '2015-08-31' 
		// => 71 ! 72 ? 
		String hql = "select count(*) from ComenziVExt where dataC = :dlo";
		Query query = getCurrentSession().createQuery(hql);
		query.setParameter("dlo", dateOfLastOrder);
		List listResult = query.list();
		Long number = (Long) listResult.get(0);
		return number.toString();
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
