package org.timesheet.web;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.jdbc.SimpleJdbcTestUtils;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.timesheet.DomainAwareBase;
import org.timesheet.domain.Employee;
import org.timesheet.domain.Manager;
import org.timesheet.service.TimesheetService;
import org.timesheet.service.dao.EmployeeDao;
import org.timesheet.service.dao.ManagerDao;

import static org.junit.Assert.assertEquals;

/**
 * This test relies on fact that DAOs and Services are tested individually.
 * Only compares, if controller returns the same as individual services.
 */
@ContextConfiguration(locations = {"/persistence-beans.xml", "/controllers.xml"})
public class TimesheetServiceControllerTest extends DomainAwareBase {

    @Autowired
    private TimesheetServiceController controller;

    @Autowired
    private TimesheetService timesheetService;

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private ManagerDao managerDao;

    @Autowired
    private SimpleJdbcTemplate jdbcTemplate;

    private Model model;
    private final String createScript = "src/main/resources/sql/create-data.sql";

    @Before
    public void setUp() {
        model = new ExtendedModelMap();
        SimpleJdbcTestUtils.executeSqlScript(jdbcTemplate,
                new FileSystemResource(createScript), false);
    }

    @Test
    public void testShowMenu() {
        String view = controller.showMenu(model);
        assertEquals("timesheet-service/menu", view);
        assertEquals(timesheetService.busiestTask(),
                model.asMap().get("busiestTask"));

        // this should be done only on small data sample
        // might cause serious performance cost for complete
        assertEquals(employeeDao.list(), model.asMap().get("employees"));
        assertEquals(managerDao.list(), model.asMap().get("managers"));
    }

    @Test
    public void testShowManagerTasks() {
        // prepare some ID
        Manager manager = managerDao.list().get(0);
        long id = manager.getId();

        String view = controller.showManagerTasks(id, model);
        assertEquals("timesheet-service/manager-tasks", view);
        assertEquals(manager, model.asMap().get("manager"));
        assertEquals(timesheetService.tasksForManager(manager),
                model.asMap().get("tasks"));
    }

    @Test
    public void testShowEmployeeTasks() {
        // prepare some ID
        Employee employee = employeeDao.list().get(0);
        long id = employee.getId();

        String view = controller.showEmployeeTasks(id, model);
        assertEquals("timesheet-service/employee-tasks", view);
        assertEquals(employee, model.asMap().get("employee"));
        assertEquals(timesheetService.tasksForEmployee(employee),
                model.asMap().get("tasks"));
    }
}
