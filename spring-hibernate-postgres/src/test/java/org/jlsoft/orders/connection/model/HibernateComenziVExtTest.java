package org.jlsoft.orders.connection.model;


import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import java.util.*;


@ContextConfiguration(locations = "/main-persistence-beans.xml")
public class HibernateComenziVExtTest extends AbstractJUnit4SpringContextTests {
	
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
	
    @Test
    public void orderTest() {
    	
    	String iD = new String("0100896774");
        String pL = new String("DEPOZIT CEFIN                                                                             ");
        Terti oneTert;
        //Terti tertiIterator;
        //int i=1;
        
    	Session session = sessionFactory.openSession();
  
    	ComenziVExt oneOrder = (ComenziVExt) session.get(ComenziVExt.class, iD);
    	assertNotNull (oneOrder);
    	oneTert = oneOrder.getTerti();
    	assertNotNull (oneTert);
    	// -- tert_id = '010033531' = "PROFI ROM FOOD SRL                                                                        "  
    	// 330 puncte lucru per CUi ! 
    	
    	
    	Set <Terti> cuiPuncte;
    	cuiPuncte = oneTert.getCuisipuncte(); 
    	assertNotNull (cuiPuncte);
    	assertEquals(330,cuiPuncte.size());
    	
      	session.close();

      	// select * from Comenzi_V_Ext where com_id='0100896075' => OK !
		// 0100896774 => "Found shared references to a collection: org.jlsoft.orders.connection.model.Terti.cuisipuncte"
		// return sessionFactory.getCurrentSession().createQuery("from ComenziVExt where comId='0100896774'").list();
      	
      	
      	
    }

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
*/
