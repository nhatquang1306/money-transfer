package com.techelevator;

public class Employee {

    //INSTANCE VARIABLES
    private int employeeId;
    private String firstName;
    private String lastName;
    private String fullName;
    private String department;
    private double annualSalary;

    //CONSTRUCTOR
    public Employee(int employeeId, String firstName, String lastName, double annualSalary) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.annualSalary = annualSalary;
        this.fullName = lastName + ", " + firstName;
    }

    //SETTERS GETTERS
    public int getEmployeeId() {
        return employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public String getDepartment() {
        return department;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDepartment(String department) {
        this.department = department;
    }


    //METHOD
    public void raiseSalary(double percent) { // return type is void, accepts the double percent
        double raise = annualSalary * (percent/100); // since the percent raise is given as a whole number, we must divide the percentage provided by 100 to make it a decimal
        annualSalary += raise; //We then add the raise onto the annual salary to represent our new salary with raise
    }


}
