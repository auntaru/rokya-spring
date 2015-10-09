/*
 * 
 * http://examples.javacodegeeks.com/core-java/real-time-applications-angularjs-java-part-1/
 * http://coenraets.org/blog/2011/12/restful-services-with-jquery-and-java-using-jax-rs-and-jersey/
 * http://examples.javacodegeeks.com/core-java/itext-pdfwriter-example/
 * http://www.javacodegeeks.com/2014/09/jquery-ajax-servlets-integration-building-a-complete-application.html
 * 
 * 
 */

package com.javacodegeeks.examples.realtimeapp.part1.controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javacodegeeks.examples.realtimeapp.part1.services.TaskService;

@ManagedBean(name = "taskController", eager=true)
@Component
@RequestScoped
public class TaskController {
	@Autowired
	private TaskService taskService;
	
	public void startTasks(ActionEvent event) throws InterruptedException {
		this.taskService.startIdleTasks();
	}
	
}
