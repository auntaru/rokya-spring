package org.timesheet.service;

import org.timesheet.domain.Employee;
import org.timesheet.domain.Manager;
import org.timesheet.domain.Task;

import java.util.List;

/**
 * Business that defines operations on timesheets
 */
public interface TimesheetService {
	
	/**
	 * @return Finds the busiest task (with the most of employees).
     * Returns {@code null} when tasks are empty.
	 */
	Task busiestTask();
	
	/**
	 * Finds all the tasks for the employee.
	 * @param e Employee
	 * @return Tasks
	 */
	List<Task> tasksForEmployee(Employee e);
	
	/**
	 * Finds all the tasks for the manager.
	 * @param m Manager
	 * @return Tasks
	 */
	List<Task> tasksForManager(Manager m);
	
}
