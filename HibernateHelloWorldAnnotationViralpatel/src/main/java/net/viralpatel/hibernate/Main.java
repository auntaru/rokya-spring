/*
 *    http://viralpatel.net/blogs/hibernate-hello-world-example-annotation/
 * 
 */


package net.viralpatel.hibernate;

import java.sql.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class Main {

	public static void main(String[] args) {
		
		
		// Read
		System.out.println("******* READ *******");
		List employees = list();
		System.out.println("Total Employees: " + employees.size());
		
		
		// Write
		System.out.println("******* WRITE *******");
		Employee empl = new Employee("Jack", "Bauer", new Date(System.currentTimeMillis()), "911");
		empl = save(empl);
		
		Long id;
		id=empl.getId();

		
		empl = read(id);
		System.out.printf("%d %s %s \n", empl.getId(), empl.getFirstname(), empl.getLastname());
		
		
		
		// Update
		System.out.println("******* UPDATE *******");
		// Employee empl2 = read(id); // read employee with id 1
		Employee empl2 = read(empl.getId());
		System.out.println("Name Before Update:" + empl2.getFirstname());
		empl2.setFirstname("James");
		update(empl2);	// save the updated employee details
		
		empl2 = read(id); // read again employee with id 1
		System.out.println("Name Aftere Update:" + empl2.getFirstname());
		
		
		// Delete
		System.out.println("******* DELETE *******");
		delete(empl); 
		Employee empl3 = read(empl.getId());
		System.out.println("Object:" + empl3);
	}
	
	

	private static List list() {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		List employees = session.createQuery("from Employee").list();
		session.close();
		return employees;
	}
	private static Employee read(Long id) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		Employee employee = (Employee) session.get(Employee.class, id);
		session.close();
		return employee;
	}
	private static Employee save(Employee employee) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		session.beginTransaction();

		Long id = (Long) session.save(employee);
		employee.setId(id);
		
		session.getTransaction().commit();
		
		session.close();

		return employee;
	}

	private static Employee update(Employee employee) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		session.beginTransaction();

		session.merge(employee);
		
		session.getTransaction().commit();
		
		session.close();
		return employee;

	}

	private static void delete(Employee employee) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		
		session.beginTransaction();
		
		session.delete(employee);
		
		session.getTransaction().commit();
		
		session.close();
	}
	
}


/*
http://viralpatel.net/blogs/hibernate-hello-world-example-annotation/

CREATE TABLE `employee` (
    `id` BIGINT(10) NOT NULL AUTO_INCREMENT,
    `firstname` VARCHAR(50) NULL DEFAULT NULL,
    `lastname` VARCHAR(50) NULL DEFAULT NULL,
    `birth_date` DATE NOT NULL,
    `cell_phone` VARCHAR(15) NOT NULL,
    PRIMARY KEY (`id`)
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
ROW_FORMAT=DEFAULT
AUTO_INCREMENT=0

Connection URL: jdbc:mysql://localhost:3306/tutorial

*/
