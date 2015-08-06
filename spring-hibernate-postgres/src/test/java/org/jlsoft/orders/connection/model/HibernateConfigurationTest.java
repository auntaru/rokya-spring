package org.jlsoft.orders.connection.model;


import static org.junit.Assert.*;

// import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import java.math.BigDecimal;

@ContextConfiguration(locations = "/main-persistence-beans.xml")
public class HibernateConfigurationTest extends AbstractJUnit4SpringContextTests {
	
	@Autowired
	private SessionFactory sessionFactory;

//  @Autowired
//  public void setSessionFactory(SessionFactory sessionFactory) {
//      this.sessionFactory = sessionFactory;
//  }

    protected Session currentSession() {
        return sessionFactory.getCurrentSession();
    }
	
	
	@Test
	public void testHibernateConfiguration() {
		// Spring IOC container instantiated and prepared sessionFactory
		assertNotNull (sessionFactory); 
	}

//	-- select * from facturi_v_c where data_f='2015-08-06'
//	-- select * from comenzi_v_ext where data_c='2015-08-04'
//	-- com_id = "0100896075" + data_c="2015-08-04" + valoare=874

    @Test
    public void testFindOrderByID() {

    	BigDecimal orderValue = new BigDecimal(874);
    	String iD = new String("0100896075");

    	Session session = sessionFactory.openSession();
    	ComenziVExt theOrder = (ComenziVExt) session.get(ComenziVExt.class, iD);
    	session.close();
    	
    	assertNotNull (theOrder);
    	assertEquals(orderValue, theOrder.getValoare().setScale(0));

    }
	
}
