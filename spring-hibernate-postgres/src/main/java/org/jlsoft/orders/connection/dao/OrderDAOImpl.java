package org.jlsoft.orders.connection.dao;

import java.util.List;

import org.jlsoft.orders.connection.model.ComenziVExt;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository

public class OrderDAOImpl implements OrderDAO {

	@Autowired
	private SessionFactory sessionFactory;

	
	public List<ComenziVExt> listOrders() {

		return sessionFactory.getCurrentSession().createQuery("from ComenziVExt where comId='0100896075'").list();

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
