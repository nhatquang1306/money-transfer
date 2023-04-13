package com.techelevator.projects.dao;

import com.techelevator.projects.model.Timesheet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

public class JdbcTimesheetDaoTests extends BaseDaoTests {

    private static final Timesheet TIMESHEET_1 = new Timesheet(1, 1, 1,
            LocalDate.parse("2021-01-01"), 1.0, true, "Timesheet 1");
    private static final Timesheet TIMESHEET_2 = new Timesheet(2, 1, 1,
            LocalDate.parse("2021-01-02"), 1.5, true, "Timesheet 2");
    private static final Timesheet TIMESHEET_3 = new Timesheet(3, 2, 1,
            LocalDate.parse("2021-01-01"), 0.25, true, "Timesheet 3");
    private static final Timesheet TIMESHEET_4 = new Timesheet(4, 2, 2,
            LocalDate.parse("2021-02-01"), 2.0, false, "Timesheet 4");

    private JdbcTimesheetDao dao;

    private Timesheet testTimesheet;

    @Before
    public void setup() {
        dao = new JdbcTimesheetDao(dataSource);
    testTimesheet = new Timesheet(5, 1, 2,
                LocalDate.parse("2021-02-11"), 2.0, false, "Timesheet 5");
    }

    @Test
    public void getTimesheetById_returns_correct_timesheet_for_id() {
        Timesheet timesheet = dao.getTimesheetById(1);
        assertTimesheetsMatch(TIMESHEET_1, timesheet);
    }

    @Test
    public void getTimesheetById_returns_null_when_id_not_found() {

        Timesheet timesheet = dao.getTimesheetById(50);
        Assert.assertNull(timesheet);
    }
    @Test
    public void getTimesheetsByEmployeeId_returns_list_of_all_timesheets_for_employee() {
        List<Timesheet> timesheetList = dao.getTimesheetsByEmployeeId(1);
        Assert.assertEquals(2, timesheetList.size());

        assertTimesheetsMatch(TIMESHEET_1, timesheetList.get(0));
        assertTimesheetsMatch(TIMESHEET_2, timesheetList.get(1));
    }

    @Test
    public void getTimesheetsByProjectId_returns_list_of_all_timesheets_for_project() {
        List <Timesheet> timesheetList = dao.getTimesheetsByProjectId(1);
        Assert.assertEquals(3, timesheetList.size());

    }

    @Test
    public void created_timesheet_has_expected_values_when_retrieved() {
      // created timesheet
        Timesheet timesheet = dao.createTimesheet(testTimesheet);
      //check if timesheet received an appropriate ID
        int newID = timesheet.getTimesheetId();
        Assert.assertTrue(newID>4); // greater than 4 because we have 4

        //retrieve created timesheet
        Timesheet retrievedTimesheet = dao.getTimesheetById(newID);
        assertTimesheetsMatch(timesheet, retrievedTimesheet);

    }

    @Test
    public void updated_timesheet_has_expected_values_when_retrieved() {
        Timesheet updatedTimesheet = dao.getTimesheetById(1);
        updatedTimesheet.setDescription("updated timesheet");
        updatedTimesheet.setBillable(false);
        dao.updateTimesheet(updatedTimesheet);

        Timesheet retrievedTimesheet = dao.getTimesheetById(1);
        assertTimesheetsMatch(updatedTimesheet, retrievedTimesheet);
    }

    @Test
    public void deleted_timesheet_can_no_longer_be_retrieved() {
        dao.deleteTimesheetById(1);

        Timesheet retrievedTimesheet = dao.getTimesheetById(1);
        Assert.assertNull(retrievedTimesheet);
    }

    @Test
    public void getBillableHours_returns_correct_total() {
     Double actualBillableHours = dao.getBillableHours(1,1);
     Double nonBillableHours = dao.getBillableHours(2,2);

    Assert.assertEquals(2.5, actualBillableHours, 0.000);
    Assert.assertEquals( 0,nonBillableHours, 0.000);

    }

    private void assertTimesheetsMatch(Timesheet expected, Timesheet actual) {
        Assert.assertEquals(expected.getTimesheetId(), actual.getTimesheetId());
        Assert.assertEquals(expected.getEmployeeId(), actual.getEmployeeId());
        Assert.assertEquals(expected.getProjectId(), actual.getProjectId());
        Assert.assertEquals(expected.getDateWorked(), actual.getDateWorked());
        Assert.assertEquals(expected.getHoursWorked(), actual.getHoursWorked(), 0.001);
        Assert.assertEquals(expected.isBillable(), actual.isBillable());
        Assert.assertEquals(expected.getDescription(), actual.getDescription());
    }

}
