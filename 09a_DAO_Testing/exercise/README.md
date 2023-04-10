# DAO testing exercises

The `EmployeeTimesheets` database is very similar to the database used in the previous exercise, it includes a new `timesheet` table. A new DAO exists to handle creating, reading, updating, and deleting records from the `timesheet` table. For this exercise, you'll be responsible for writing integration tests and using them to identify bugs in this new DAO. You'll then fix the bugs you've found and report them in a bug report.

## Learning objectives

After completing this exercise, you'll understand:

* How to write integration tests.
* How to use integration tests to find bugs in a DAO.

## Evaluation criteria and functional requirements

The instruction team evaluates your code for this assignment based on the following criteria:

* The project must not have any build errors.
* You must fill out the provided `BugReport.txt` file for four bugs you found and fixed.
* Each provided DAO test method must be complete and passing.
* Code is clean, concise, and readable.

## Getting started

1. In the `/database` folder, there's an `EmployeeTimesheets.sql` SQL script that drops and recreates the tables and data in the `EmployeeTimesheets` database. You can run that script to create a copy of the database to reference while working. Be aware, however, that the tests don't use that database. The tests use a temporary database with the same structure. You'll find the SQL for that temporary database in `src/test/resources/test-data.sql`.
2. Import the DAO Testing exercises project into IntelliJ.

## Step One: Explore starting material

Before you begin:
 - Review the provided classes in the `model` and `dao` packages.
 - Familiarize yourself with the provided test classes and the `test-data.sql` file.
 - Open the `BugReport.txt` file and note what steps you must take to report the bugs you find during this exercise.


## Step Two: Implement the `JdbcTimesheetDaoTests` methods

In the eight test methods, replace the `Assert.fail()` with the code necessary to implement the test described by the method name. You can refer to the comments in the `TimesheetDao` interface for descriptions of what each DAO method does.

Use this unit's reading and the integration tests from the previous DAO exercises as examples to reference while working. Static constant `Timesheet`s have been provided that you can use in your tests.

When fully implemented, four of the tests pass, and four continue to fail due to bugs in `JdbcTimesheetDao`.

## Step Three: Complete bug reports and fix bugs

Fill out `BugReport.txt` with information about the four bugs you've identified in `JdbcTimesheetDao` using the DAO tests.

---
### An example of reporting and fixing a bug

Consider the following `deleteTimesheet()` method:

```java
    public void deleteTimesheet(int timesheetId) {
        String sql = "DELETE FROM timesheet WHERE timesheet_id = ?";
        jdbcTemplate.update(sql, 1);
    }
```

This method contains a bug. It always deletes the record with a `timesheet_id` of 1 rather than using the value of `timesheetId`.

There are several ways this could cause the `deleted_timesheet_cant_be_retrieved` test to fail. 

If the test called `deleteTimesheet(2)` and then verified whether the timesheet was deleted using `getTimesheetById(2)`, the timesheet will still be retrieved and the test would fail.

After that test fails, you'd fix the `deleteTimesheet()` method like this:

```java
public void deleteTimesheet(int timesheetId) {
    String sql = "DELETE FROM timesheet WHERE timesheet_id = ?";
    jdbcTemplate.update(sql, timesheetId);
}
```

Then, in this scenario you fill-out the fields in `BugReport.txt` like so:

```
Test that demonstrates problem:
    deleted_timesheet_cant_be_retrieved
Expected output:
    getTimesheet(2) returns null after calling deleteTimesheet(2)
Actual output:
    getTimesheet(2) was still returning a Timesheet object
How did you fix this bug?
    Replaced hardcoded value of 1 in deleteTimesheet with timesheetId so it doesn't always delete the same timesheet.
```
---

After you've found, fixed, and documented the four bugs all of the tests in `TimesheetSqlDao` pass, and the exercise is ready to be submitted to your instructor.