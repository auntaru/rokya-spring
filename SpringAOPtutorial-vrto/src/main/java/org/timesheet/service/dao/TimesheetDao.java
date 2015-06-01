package org.timesheet.service.dao;

import org.timesheet.domain.Timesheet;
import org.timesheet.service.GenericDao;

/**
 * DAO of Timesheet.
 */
public interface TimesheetDao extends GenericDao<Timesheet, Long> {
    // no additional business operations atm
}
