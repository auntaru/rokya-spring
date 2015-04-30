package com.sprhib.init;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class Initializer implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext)
			throws ServletException {
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(WebAppConfig.class);
		servletContext.addListener(new ContextLoaderListener(ctx));

		ctx.setServletContext(servletContext);

		Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);
	}

}

/*

Professional Java for Web Applications

CHAPTER 12  Introducing Spring Framework - pag.328


Understanding Application Contexts

There are a number of interfaces that extend and classes that implement ApplicationContext:

For programmatically configuring Spring using Java instead of XML, the
AnnotationConfigApplicationContext and AnnotationConfigWebApplicationContext
classes work in standalone and Java EE web applications, respectively.


Bootstrapping Spring Framework

Programmatically Bootstrapping Spring in an Initializer

The org.springframework.web.SpringServletContainerInitializer class implements
ServletContainerInitializer, and because the JAR containing this class includes a service
provider file listing the class’s name, its onStartup method is called when your application starts up.
This class then scans your application for implementations of the org.springframework.web
.WebApplicationInitializer interface and calls the onStartup method of any matching classes
it finds. Within a WebApplicationInitializer implementation class, you can programmatically
configure listeners, Servlets, filters, and more, all without writing a single line of XML. More
important, you can bootstrap Spring from within this class.

*/