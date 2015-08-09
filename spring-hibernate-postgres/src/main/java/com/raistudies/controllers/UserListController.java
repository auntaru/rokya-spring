/*
 * http://www.javacodegeeks.com/2012/02/ajax-with-spring-mvc-3-using.html
 * http://www.raistudies.com/spring/spring-mvc/ajax-spring-mvc-3-annonations-jquery/
 * 
 */
package com.raistudies.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.raistudies.domain.User;

@Controller
public class UserListController {
	private List<User> userList = new ArrayList<User>(); 
	
	@RequestMapping(value="/AddUser.htm",method=RequestMethod.GET)
	public String showForm(){
		return "AddUser";
	}
	
	@RequestMapping(value="/AddUser.htm",method=RequestMethod.POST)
	public @ResponseBody String addUser(@ModelAttribute(value="user") User user, BindingResult result ){
		String returnText;
		if(!result.hasErrors()){
			userList.add(user);
			returnText = "User has been added to the list. Total number of users are " + userList.size();
		}else{
			returnText = "Sorry, an error has occur. User has not been added to list.";
		}
		return returnText;
	}

	@RequestMapping(value="/ShowUsers.htm")
	public String showUsers(ModelMap model){
		model.addAttribute("Users", userList);
		return "ShowUsers";
	}
}


/*
 
Java Code Geeks on Steroids
newsletter@javacodegeeks.com

Spring Framework tutorials Extravaganza

JSF 2, PrimeFaces 3, Spring 3 & Hibernate 4 Integration Project
http://www.javacodegeeks.com/2012/04/jsf-2-primefaces-3-spring-3-hibernate-4.html
This article shows how to integrate JSF2, PrimeFaces3, Spring3 and Hibernate4 Technologies. It provides a general project template for Java developers. Also if Spring is not used for Business and Data Access layer, JSF – PrimeFaces & Hibernate Integration Project can be offered.


JAX-WS with Spring and Maven Tutorial
http://www.javacodegeeks.com/2010/11/jaxws-with-spring-and-maven-tutorial.html
Spring framework provides remoting support for web services via JAX–WS, in fact, as stated in Spring reference documentation, there are three ways of exposing Spring POJO services as a JAX–WS web services : Exposing Servlet – based web services (suitable for Java EE 5 environments), Exporting standalone web services (suitable when utilizing Sun’s JDK 1.6 build–in JAX–WS provider), Exporting web services using the JAX–WS RI’s Spring support.

Ajax with Spring MVC 3 using Annotations and JQuery
http://www.javacodegeeks.com/2012/02/ajax-with-spring-mvc-3-using.html
Its always been fun for me to work with Ajax! Is not it ? I will make it easy for you to use Ajax with Spring MVC 3 and JQuery. This post will illustrate you how to use Ajax in real life practices of industrial coding. As usual, we will take an practical example of Ajax in Spring MVC 3 framework and will implement it and I will make the implementation easy by make you understand the topic.

Spring JPA Data + Hibernate + MySQL + Maven
http://www.javacodegeeks.com/2013/05/spring-jpa-data-hibernate-mysql-maven.html
Development of web-applications with the help of Spring MVC implies creation of several logical layers of architecture. One of the layers is a DAO (Repository) layer. It is responsible for communication with a database. If you developed the DAO layer at least once, you should know that it involves a lot of boilerplate code. A Spring Data take a part of the routine job related to the DAO on itself.

"Introduction to Spring" Tutorial Series
http://www.javacodegeeks.com/2012/09/introduction-to-spring-tutorial-series.html
I am glad to present you this “Introduction to Spring” tutorial series! It is a series of articles originally written by our JCG partner Michal Vrtiak at the vrtoonjava blog. A timesheet management application is gradually created in this series and each tutorial builds on top of the previous one. All main aspects of a web application are taken care of, including both server side and client side functionality.

Spring and Quartz: Multi-Job Scheduling Service
http://www.javacodegeeks.com/2012/02/spring-and-quartz-multi-job-scheduling.html
Job Scheduling is so important requirement for the applications. Especially in large-scale projects, working with a lot of jobs can be a problem. Spring and Quartz have brought significant benefits for the solution of this problem. This article shows how to schedule multi jobs easily by using Spring and Quartz.

Set up a Spring 3 development environment
http://www.javacodegeeks.com/2012/02/set-up-spring-3-development-environment.html
This tutorial explains in short how to set-up a typical environment to develop Spring based applications. There is no prerequesite to this tutorial other then a working Windows XP client with sufficient CPU power and memory. During the tutorial we will need to install the following components: Java 6 JDK Update 26, Eclipse IDE for Java EE Developers 3.6.2 (Helios), Maven 3.0.3, Tomcat 7.0.14.

Spring Data JPA Tutorial Part One: Configuration
http://www.javacodegeeks.com/2013/07/spring-data-jpa-tutorial-part-one-configuration.html
http://www.petrikainulainen.net/spring-data-jpa-tutorial/
Spring Data JPA is a project which aims both to simplify the creation of JPA based repositories and to reduce the amount of code needed to communicate with a database. I have been using it for a while at my work and in my personal hobby projects and it has indeed make things a lot more simpler and cleaner. Now it is time to share my knowledge with you.

Concurrency - Executors and Spring Integration
http://www.javacodegeeks.com/2012/06/concurrency-executors-and-spring.html
Thread Pool/Executors Based Implementation: A better approach than the raw thread version, is a Thread pool based one, where an appropriate thread pool size is defined based on the system where the task is running – Number of CPU’s/(1-Blocking Coefficient of Task).

Spring Integration - Application from scratch
http://www.javacodegeeks.com/2013/03/spring-integration-application-from-scratch-part-1.html
In this tutorial you will learn what is Spring Integration, how to use it and what kind of problems does it help to solve. We will build a sample application from the scratch and demonstrate some of the core components of Spring Integration. If you’re new to Spring check out another tutorial on Spring written by me – Shall we do some Spring together?

*/