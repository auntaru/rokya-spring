package org.timesheet.web.editors;

import org.timesheet.domain.Manager;
import org.timesheet.service.dao.ManagerDao;

import java.beans.PropertyEditorSupport;

/**
 * Will convert ID from combobox to manager's instance
 */
public class ManagerEditor extends PropertyEditorSupport {

    private ManagerDao managerDao;

    public ManagerEditor(ManagerDao managerDao) {
        this.managerDao = managerDao;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        long id = Long.parseLong(text);
        Manager manager = managerDao.find(id);
        setValue(manager);
    }
}
