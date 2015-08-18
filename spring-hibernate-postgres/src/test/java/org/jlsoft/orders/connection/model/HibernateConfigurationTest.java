package org.jlsoft.orders.connection.model;


import static org.junit.Assert.*;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import java.math.BigDecimal;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

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

/* 
 * 
 *  Spring CRUD Example using One to One Mapping of Two Tables
 *  http://www.dineshonjava.com/2013/05/spring-crud-example-using-one-to-one.html
 *  <td><c:out value="${publication.category.categoryName}"/></td>  
 *  
 *   Lazy fetching decides whether to load child objects while loading the Parent Object.
 *   Lazy = true (means not to load child) ; By default the lazy loading of the child objects is true.
 *  @ManyToOne(fetch = FetchType.LAZY) 
 *  @ManyToOne(fetch = FetchType.EAGER)
 *    
 */
    @Test
    public void testFindOrderByID() {
    	BigDecimal orderValue = new BigDecimal(874);
    	String iD = new String("0100896075");
        String aG = new String("DOGARU CRISTIAN - BRASOV                ");
    	Session session = sessionFactory.openSession();
    	ComenziVExt theOrder = (ComenziVExt) session.get(ComenziVExt.class, iD);
    	// daca nu se face "Hibernate.initialize(theOrder.getNumereLucru());" && 
    	// iar session.close(); se face inainte de assert  ==>> ERROR : 
    	// << org.hibernate.LazyInitializationException: could not initialize proxy - no Session
    	//    at org.hibernate.proxy.AbstractLazyInitializer.initialize >> 
    	// Hibernate.initialize(theOrder.getNumereLucru());
    	NumereLucru theAgent = theOrder.getNumereLucru(); 
    	assertNotNull (theAgent);
    	assertNotNull (theOrder);
    	assertEquals(orderValue, theOrder.getValoare().setScale(0));
    	assertEquals(aG, theAgent.getDenumire());
    	session.close();
    }
    //	-- select * from comenzi_v_ext where data_c='2015-08-04'
    //	-- com_id = "0100896075" + data_c="2015-08-04" + valoare=874
    // 	-- select * from numere_lucru where nrlc_id='0100427'
    //     	=> "DOGARU CRISTIAN - BRASOV                "
    //	-- select * from facturi_v_c where data_f='2015-08-06'
}
