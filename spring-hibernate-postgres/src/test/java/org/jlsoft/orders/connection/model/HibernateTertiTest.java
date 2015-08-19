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
import java.util.Set;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@ContextConfiguration(locations = "/main-persistence-beans.xml")
public class HibernateTertiTest extends AbstractJUnit4SpringContextTests {
	
	@Autowired
	private SessionFactory sessionFactory;


    protected Session currentSession() {
        return sessionFactory.getCurrentSession();
    }
	
	
	@Test
	public void testHibernateConfiguration() {
		// Spring IOC container instantiated and prepared sessionFactory
		assertNotNull (sessionFactory); 
	}

    @Test
    public void tertiTest() {
    	
    	String iD = new String("010030333");
        String pL = new String("DEPOZIT CEFIN                                                                             ");
        // Set<Terti> tertiSet;
        
    	Session session = sessionFactory.openSession();
    	
    	Terti oneTert = (Terti) session.get(Terti.class, iD);
    	assertNotNull (oneTert);
    	assertEquals(pL, oneTert.getDenumire());
    	
    	// tertiSet = oneTert.getTheterti();
    	// assertNotNull (tertiSet);
    	
    	session.close();
    }
}
