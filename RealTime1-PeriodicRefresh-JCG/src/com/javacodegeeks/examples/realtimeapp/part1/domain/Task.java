package com.javacodegeeks.examples.realtimeapp.part1.domain;

public class Task {
	private TaskStatus status = TaskStatus.IDLE;
	private long duration;

	public TaskStatus getStatus() {
		return status;
	}

	public void setStatus(TaskStatus status) {
		this.status = status;
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public void decrementDuration() {
		this.duration--;
	}

	public boolean isRunning() {
		return this.status.equals(TaskStatus.RUNNING);
	}
	
	public String getName() {
		return this.toString();
	}

	public void start() {
		this.status = TaskStatus.RUNNING;
	}
	
	
}
