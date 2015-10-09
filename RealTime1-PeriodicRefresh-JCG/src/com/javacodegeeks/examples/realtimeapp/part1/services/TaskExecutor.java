package com.javacodegeeks.examples.realtimeapp.part1.services;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.javacodegeeks.examples.realtimeapp.part1.domain.Task;
import com.javacodegeeks.examples.realtimeapp.part1.domain.TaskStatus;

@Component
@Scope("singleton")
public class TaskExecutor {
	private List<Task> pool = new LinkedList<>();
	
	@PostConstruct
	public void initialize() {
		Runnable taskPoolConsumer = () -> {
			while (true) {
				try {
					this.pool.stream()
							.filter(task -> task.isRunning() && task.getDuration() > 0)
							.forEach(task -> {
								task.decrementDuration();
							});
					
					this.pool.stream()
						.filter(task -> task.isRunning() && task.getDuration() == 0)
						.forEach(task -> task.setStatus(TaskStatus.SUCCESS));

					Thread.sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		
		new Thread(taskPoolConsumer).start();
	}
	
	public void startAllTasks() throws InterruptedException {
		this.pool.stream().forEach(task -> task.start());	
	}

	public List<Task> getPool() {
		return this.pool;
	}

	public void addTask(Task taskToAdd) {
		this.pool.add(taskToAdd);
	}

}
