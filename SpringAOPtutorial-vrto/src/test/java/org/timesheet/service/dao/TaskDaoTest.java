package org.timesheet.service.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.timesheet.DomainAwareBase;
import org.timesheet.domain.Employee;
import org.timesheet.domain.Manager;
import org.timesheet.domain.Task;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

@ContextConfiguration(locations = "/persistence-beans.xml")
public class TaskDaoTest extends DomainAwareBase {
    
    @Autowired
    private TaskDao taskDao;

    @Autowired
    private ManagerDao managerDao;

    @Autowired
    private EmployeeDao employeeDao;

    @Test
    public void testAdd() {
        int size = taskDao.list().size();

        Task task = newSpringTask();
        taskDao.add(task);

        assertTrue(size < taskDao.list().size());
    }

    @Test
    public void testUpdate() {
        Task task = newSpringTask();
        taskDao.add(task);
        
        // update task
        task.setDescription("Learn Spring 3.1");
        taskDao.update(task);

        Task found = taskDao.find(task.getId());
        assertEquals("Learn Spring 3.1", found.getDescription());
    }

    @Test
    public void testFind() {
        Task task = newSpringTask();
        taskDao.add(task);
        
        assertEquals(task, taskDao.find(task.getId()));
    }
    
    @Test
    public void testList() {
        assertEquals(0, taskDao.list().size());
        Task templateTask = newSpringTask();
        
        List<Task> tasks = Arrays.asList(
                newTaskFromTemplate(templateTask, "1"),
                newTaskFromTemplate(templateTask, "2"),
                newTaskFromTemplate(templateTask, "3")
        );
        for (Task task : tasks) {
            taskDao.add(task);
        }

        List<Task> found = taskDao.list();
        assertEquals(3, found.size());
        for (Task task : found) {
            assertTrue(tasks.contains(task));
        }
    }
    
    @Test
    public void testRemove() {
        Task task = newSpringTask();
        taskDao.add(task);
        
        // successfully added
        assertEquals(task, taskDao.find(task.getId()));
        
        // try to remove
        taskDao.remove(task);
        assertNull(taskDao.find(task.getId()));
    }

    /**
     * @return Dummy task for testing
     */
    private Task newSpringTask() {
        Manager bob = new Manager("Bob");
        managerDao.add(bob);

        Employee steve = new Employee("Steve", "Business");
        Employee woz = new Employee("Woz", "Engineering");
        employeeDao.add(steve);
        employeeDao.add(woz);

        return new Task("Learn Spring", bob, steve, woz);
    }

    /**
     * Creates dummy task fo testing as copy of existing task and
     * adds aditional information to every field.
     * @param templateTask Task to copy
     * @param randomInfo Info to append everywhere
     * @return Random task for testing
     */
    private Task newTaskFromTemplate(Task templateTask, 
            String randomInfo) {
        String description = templateTask.getDescription() 
                + randomInfo;
        
        Manager manager = new Manager(
                templateTask.getManager().getName());
        managerDao.add(manager);

        List<Employee> templateEmployees = templateTask.getAssignedEmployees();
        Employee[] employees = new Employee[templateEmployees.size()];

        int idx = 0;
        for (Employee templateEmployee : templateEmployees) {
            Employee employee = new Employee(
                    templateEmployee.getName() + randomInfo,
                    templateEmployee.getDepartment() + randomInfo);
            employees[idx++] = employee;
            employeeDao.add(employee);
        }

        return new Task(description, manager, employees);
    }
}
