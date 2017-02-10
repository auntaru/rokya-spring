// http://viralpatel.net/blogs/tutorial-save-get-blob-object-spring-3-mvc-hibernate/
package net.viralpatel.docmanager.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.viralpatel.docmanager.dao.DocumentDAO;
import net.viralpatel.docmanager.model.Document;

import org.apache.commons.io.IOUtils;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class DocumentController {
	
	@Autowired
	private DocumentDAO documentDao;
	
	@RequestMapping("/index")
	public String index(Map<String, Object> map) {
		try {
			map.put("document", new Document());
			map.put("documentList", documentDao.list());
		}catch(Exception e) {
			e.printStackTrace();
		}

		return "documents";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(
			@ModelAttribute("document") Document document,
			@RequestParam("file") MultipartFile file) {
		
		
		System.out.println("Name:" + document.getName());
		System.out.println("Desc:" + document.getDescription());
		System.out.println("File:" + file.getName());
		System.out.println("ContentType:" + file.getContentType());
		
		try {
			Blob blob = Hibernate.createBlob(file.getInputStream());

			document.setFilename(file.getOriginalFilename());
			document.setContent(blob);
			document.setContentType(file.getContentType());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			documentDao.save(document);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/index.html";
	}

	@RequestMapping("/download/{documentId}")
	public String download(@PathVariable("documentId")
			Integer documentId, HttpServletResponse response) {
		
		Document doc = documentDao.get(documentId);
		try {
			response.setHeader("Content-Disposition", "inline;filename=\"" +doc.getFilename()+ "\"");
			OutputStream out = response.getOutputStream();
			response.setContentType(doc.getContentType());
			IOUtils.copy(doc.getContent().getBinaryStream(), out);
			out.flush();
			out.close();
		
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

	@RequestMapping("/remove/{documentId}")
	public String remove(@PathVariable("documentId")
			Integer documentId) {
		
		documentDao.remove(documentId);
		
		return "redirect:/index.html";
	}
	
}
/*
The spring controller defines four methods to manipulate document manager application.

    index method – This method uses list() method of DocumentDAO to fetch the list of all documents from database. 
       Note that we have mapped request “/index” to this method. 
       Thus Spring will automatically calls this method whenever it encounters this url in request.
    save method – This method adds a new document to document list. 
       The document details are fetched in Document object using @ModelAttribute annotation. 
       Also note that the request “/save” is mapped with this method. 
       The request method should also be POST. 
       Once the document is added in document list, we redirect to /index.html page 
       which in turn calls index() method to display document list to user. 
       One more thing to note here is @RequestParam. 
       We are mapping MultipartFile object using @RequestParam(“file”) annotation. 
       Spring automatically detects “file” data from request and map it with MultipartFile object. 
       This object is later converted to BLOB object and set in the Document content.
    
    download method – This method is used to download a selected testcase. 
       Note that we are fetching the document content from database using DAO class and thn set the Data stream in Response. 
       Also note that we are using response.setHeader() method to set "Content-Disposition". 
       This will raise a Save As dialog box in browser whenever user tries to download a document.
    remove method – This methods removes a document from the document list. 
    Similar to save() this method also redirects user to /index.html page once the document is removed. 
    One thing to note in this method is the way we have mapped request url using @RequestMapping annotation. 
    The url “/remove/{documentId}” is mapped thus whenever user send a request /remove/12.html, 
    the remove method will try to delete document with ID:12.

Related: Forms in Spring MVC
http://viralpatel.net/blogs/spring-3-mvc-handling-forms/
Spring 3 MVC: Handling Forms in Spring 3.0 MVC
by Viral Patel · July 5, 2010

*/