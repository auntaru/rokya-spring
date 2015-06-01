package org.timesheet.web.commands;

import org.hibernate.validator.constraints.Range;
import org.timesheet.domain.Timesheet;

import javax.validation.constraints.NotNull;

public class TimesheetCommand {

    @NotNull
    @Range(min = 1, message = "Hours must be 1 or greater")
    private Integer hours;
    private Timesheet timesheet;

    // default c-tor for bean instantiation
    public TimesheetCommand() {}

    public TimesheetCommand(Timesheet timesheet) {
        hours = timesheet.getHours();
        this.timesheet = timesheet;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public Timesheet getTimesheet() {
        return timesheet;
    }

    public void setTimesheet(Timesheet timesheet) {
        this.timesheet = timesheet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TimesheetCommand that = (TimesheetCommand) o;

        if (hours != null ? !hours.equals(that.hours) : that.hours != null) {
            return false;
        }
        if (timesheet != null ? !timesheet.equals(that.timesheet) : that.timesheet != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = hours != null ? hours.hashCode() : 0;
        result = 31 * result + (timesheet != null ? timesheet.hashCode() : 0);
        return result;
    }
}
