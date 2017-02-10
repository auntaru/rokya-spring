// http://viralpatel.net/blogs/tutorial-save-get-blob-object-spring-3-mvc-hibernate/
package net.viralpatel.docmanager.model;

import java.sql.Blob;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="documents")
public class Document {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id;

	@Column(name="name")
	private String name;

	@Column(name="description")
	private String description;

	@Column(name="filename")
	private String filename;

	@Column(name="content")
	@Lob
	private Blob content;
	
	@Column(name="content_type")
	private String contentType;
	
	@Column(name="created")
	private Date created;
	
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public String getFilename() {
		return filename;
	}
	public Blob getContent() {
		return content;
	}
	public Date getCreated() {
		return created;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public void setContent(Blob content) {
		this.content = content;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
}
/*
The first thing you’ll notice is that the import statements import from javax.persistence 
rather than a Hibernate or Spring package. 
Using Hibernate with Spring, the standard JPA annotations work just as well and that’s what I’m using here.

    First we’ve annotated the class with @Entity which tells Hibernate that this class represents an object that we can persist.
    The @Table(name = "documents") annotation tells Hibernate which table to map properties in this class to documents table. 
    	The first property in this class on line 20 is our object ID which will be unique for all events persisted. 
    	This is why we’ve annotated it with @Id.
    The @GeneratedValue annotation says that this value will be determined by the datasource, not by the code.
    The @Column(name = "filename") annotation is used to map this property to the FILENAME column in the DOCUMENTS table.

*/
