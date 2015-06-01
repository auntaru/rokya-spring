package org.timesheet.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.timesheet.domain.Employee;
import org.timesheet.domain.Manager;
import org.timesheet.domain.Task;
import org.timesheet.service.TimesheetService;
import org.timesheet.service.dao.EmployeeDao;
import org.timesheet.service.dao.ManagerDao;
import org.timesheet.web.editors.EmployeeEditor;
import org.timesheet.web.editors.ManagerEditor;

import java.util.List;

@Controller
@RequestMapping("/timesheet-service")
public class TimesheetServiceController {

    private TimesheetService service;
    private EmployeeDao employeeDao;
    private ManagerDao managerDao;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Employee.class, new EmployeeEditor(employeeDao));
        binder.registerCustomEditor(Manager.class, new ManagerEditor(managerDao));
    }

    @Autowired
    public void setService(TimesheetService service) {
        this.service = service;
    }

    @Autowired
    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Autowired
    public void setManagerDao(ManagerDao managerDao) {
        this.managerDao = managerDao;
    }

    /**
     * Shows menu of timesheet service:
     * that contains busiest task and employees and managers to
     * look for their assigned tasks.
     * @param model Model to put data to
     * @return timesheet-service/list
     */
    @RequestMapping(method = RequestMethod.GET)
    public String showMenu(Model model) {
        model.addAttribute("busiestTask", service.busiestTask());
        model.addAttribute("employees", employeeDao.list());
        model.addAttribute("managers", managerDao.list());

        return "timesheet-service/menu";
    }

    /**
     * Returns tasks for given manager
     * @param id ID of manager
     * @param model Model to put tasks and manager
     * @return timesheet-service/manager-tasks
     */
    @RequestMapping(value = "/manager-tasks/{id}", method = RequestMethod.GET)
    public String showManagerTasks(@PathVariable("id") long id, Model model) {
        Manager manager = managerDao.find(id);
        List<Task> tasks = service.tasksForManager(manager);

        model.addAttribute("manager", manager);
        model.addAttribute("tasks", tasks);

        return "timesheet-service/manager-tasks";
    }

    /**
     * Returns tasks for given employee
     * @param id ID of employee
     * @param model Model to put tasks and employee
     * @return timesheet-service/employee-tasks
     */
    @RequestMapping(value = "/employee-tasks/{id}", method = RequestMethod.GET)
    public String showEmployeeTasks(@PathVariable("id") long id, Model model) {
        Employee employee = employeeDao.find(id);
        List<Task> tasks = service.tasksForEmployee(employee);

        model.addAttribute("employee", employee);
        model.addAttribute("tasks", tasks);

        return "timesheet-service/employee-tasks";
    }
}
