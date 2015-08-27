package org.jlsoft.orders.connection.model;


import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import java.util.Set;

import java.util.*;


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
}	
/*
    // @Test
    public void tertiTest() {
    	
    	String iD = new String("010030333");
        String pL = new String("DEPOZIT CEFIN                                                                             ");
        Set<Terti> tertiSet;
        Terti tertiIterator;
        int i=1;
        
    	Session session = sessionFactory.openSession();
    	
    	Terti oneTert = (Terti) session.get(Terti.class, iD);
    	assertNotNull (oneTert);
    	assertEquals(pL, oneTert.getDenumire());
    	
    	tertiSet = oneTert.getCuisipuncte();
    	assertNotNull (tertiSet);
    	
    	Iterator<Terti> iterator = tertiSet.iterator();
    	tertiIterator = (Terti) iterator.next();
    	assertNotNull (tertiIterator);
    	while (iterator.hasNext()) {
    		i=i+1;
    		tertiIterator = (Terti) iterator.next();
    		assertNotNull (tertiIterator);
    		if (tertiIterator.getPlt().equals("00")){
    			assertEquals(tertiIterator.getDenumire(),"CARREFOUR ROMANIA SA                                                                      ");
    		}
    	}
    	assertEquals(i, 36);
    	
    	session.close();
    }


   select denumire ,tert_id, cui,plt, localitate, judet from terti where cui= ( select t1.cui from terti t1 where tert_id='010030333' )
   "CARREFOUR ROMANIA SA                                                                      "
*/
