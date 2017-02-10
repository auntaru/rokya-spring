// http://viralpatel.net/blogs/tutorial-save-get-blob-object-spring-3-mvc-hibernate/
package net.viralpatel.docmanager.dao;

import java.util.List;

import net.viralpatel.docmanager.model.Document;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class DocumentDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public void save(Document document) {
		Session session = sessionFactory.getCurrentSession();
		session.save(document);
	}
	
	@Transactional
	public List<Document> list() {
		Session session = sessionFactory.getCurrentSession();
		List<Document> documents = null;
		try {
			documents = (List<Document>)session.createQuery("from Document").list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return documents;
	}
	
	@Transactional
	public Document get(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		return (Document)session.get(Document.class, id);
	}

	@Transactional
	public void remove(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		
		Document document = (Document)session.get(Document.class, id);
		
		session.delete(document);
	}
}
/*
The Data Access (DAO) Layer

The DAO layer of Document Manager application consist of a class DocumentDAO. 
Ideal solution will be to create an interface (DocumentDAO) and its corresponding implementation class DocumentDAOImpl. 
But for sake of simplicity we will create just normal DAO class DocumentDAO.java.

Methods:

    list() Method – This method gets the list of all documents stored in documents table and return a List of Document objects.
    save() Method – This method is used to store a new document (including BLOB) into database.
    get() Method – This method returns Document entry for a given ID from database. 
                    Used in download functionality to download a stored document from database.
    remove() Method – This method is used to delete a document with specific ID from database.
    
Note that we have used two Spring annotations @Repository and @Autowired. 
Classes marked with annotations are candidates for auto-detection by Spring 
when using annotation-based configuration and classpath scanning. 

The @Repository annotation is yet another stereotype that was introduced in Spring 2.0. 
This annotation is used to indicate that a class functions as a repository 
and needs to have exception translation applied transparently on it. 
The benefit of exception translation is that the service layer only has to deal with 
exceptions from Spring’s DataAccessException hierarchy, even when using plain JPA in the DAO classes.

Another annotation used in DocumentDAO is @Autowired. 
This is used to autowire the dependency of the DocumentDAO on the SessionFactory.

Also note that we have used @Transactional annotation on each method. 
Ideally the DAO layer is access from a Service layer and transaction management needs to be specified at Service layer. 
But again for sake of simplicity we will not include service layer in our example 
and directly call the DAO layer from Spring Controller. 
Again, feel free to change this implementation and add your own service layer in between.

For more information about A layered application with Services in Spring MVC and Hibernate read this tutorial:
   << Spring MVC Hibernate Maven example >>
viralpatel.net/blogs/spring3-mvc-hibernate-maven-tutorial-eclipse-example/
Tutorial:Create Spring 3 MVC Hibernate 3 Example using Maven in Eclipse
by Viral Patel · November 10, 2010

*/
