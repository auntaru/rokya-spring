/*
 * http://programmaticponderings.wordpress.com/2013/10/21/spring-integration-with-eclipse-using-maven/
 * http://www.tutorialspoint.com/spring/spring_bean_definition.htm
 * 
 */

package com.blogpost.maven.maven_spring;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration(locations = "/Beans.xml")
public class VehicleTest extends AbstractJUnit4SpringContextTests {

	@Autowired
	private Vehicle vehicle1;

	@Test
	public void mainTest() {

		assertNotNull("The field should have been autowired.", vehicle1);
		assertEquals("Verifying the name of the vehicle configured as bean [" + vehicle1.getMake() + "].",
				this.vehicle1.getMake(), "Mercedes-Benz");

	}
}
