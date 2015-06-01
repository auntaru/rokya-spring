package org.timesheet.web.exceptions;

import org.timesheet.domain.Manager;

/**
 * When manager cannot be deleted
 */
public class ManagerDeleteException extends Exception {

    private Manager manager;

    public ManagerDeleteException(Manager manager) {
        this.manager = manager;
    }

    public Manager getManager() {
        return manager;
    }
}
