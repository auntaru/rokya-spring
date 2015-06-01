package org.timesheet.web.editors;

import org.timesheet.domain.Employee;
import org.timesheet.service.dao.EmployeeDao;

import java.beans.PropertyEditorSupport;

/**
 * Will convert ID from combobox to employee's instance.
 */
public class EmployeeEditor extends PropertyEditorSupport {

    private EmployeeDao employeeDao;

    public EmployeeEditor(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        long id = Long.parseLong(text);
        Employee employee = employeeDao.find(id);
        setValue(employee);
    }
}
