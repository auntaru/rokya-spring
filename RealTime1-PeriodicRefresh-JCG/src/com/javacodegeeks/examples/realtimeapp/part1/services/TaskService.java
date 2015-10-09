package com.javacodegeeks.examples.realtimeapp.part1.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javacodegeeks.examples.realtimeapp.part1.domain.Task;

@RestController
@RequestMapping("/api/task")
public class TaskService {
	@Autowired
	private TaskExecutor taskExecutor;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Task> getTasks() {
		return this.taskExecutor.getPool();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void addTask(@RequestBody Task taskToAdd) {
		this.taskExecutor.addTask(taskToAdd);
	}
	
	public void startIdleTasks() throws InterruptedException {
		this.taskExecutor.startAllTasks();
	}
	
}
