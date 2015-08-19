package org.jlsoft.orders.connection.dao;

import java.util.List;
import java.util.Date;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.jlsoft.orders.connection.model.ComenziVExt;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository

public class OrderDAOImpl implements OrderDAO {

	@Autowired
	private SessionFactory sessionFactory;
	// Date LastorderDate;

	// http://www.tutorialspoint.com/hibernate/hibernate_criteria_queries.htm 
	// Session session = sessionFactory.openSession();
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	
	public List<ComenziVExt> listOrders() {
		

        // Query taskQuery = getCurrentSession().createQuery(
        //         "from Timesheet t where t.task.id = :id");
        // taskQuery.setParameter("id", task.getId());
		
//		Criteria criteria = session
//			    .createCriteria(Person.class)
//			    .setProjection(Projections.max("age"));
//			Integer maxAge = (Integer)criteria.uniqueResult();
	
			Criteria criteria = getCurrentSession().createCriteria(ComenziVExt.class).setProjection(Projections.max("dataC")); 
			Date dateOfLastOrder = (Date)criteria.uniqueResult();
		
			// return sessionFactory.getCurrentSession().createQuery("from ComenziVExt where comId='0100896075'").list();
			
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
