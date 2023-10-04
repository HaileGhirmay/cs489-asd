package edu.miu.cs489.lab1b.emppp_System.model;

import java.time.LocalDate;

public class Employee {
    private long employeeId;
    private String firstName;
    private String lastName;
    private LocalDate employmentDate;
    private LocalDate enrollmentDate;
    private double yearlySalary;
    private PensionPlan pensionPlan; // Employee's associated PensionPlan (if any)



    public Employee(long employeeId, String firstName, String lastName, LocalDate employmentDate, LocalDate enrollmentDate, double yearlySalary, PensionPlan pensionPlan) {

        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.employmentDate = employmentDate;
        this.enrollmentDate = enrollmentDate;
        this.yearlySalary = yearlySalary;
        this.pensionPlan = pensionPlan;
    }
    public Employee(long employeeId, String firstName, String lastName, LocalDate employmentDate, LocalDate enrollmentDate, double yearlySalary) {
        this(employeeId, firstName, lastName, employmentDate, enrollmentDate, yearlySalary, null);
    }

    public Employee(){
        this(0, null, null, null, null, 0.0, null);
    }
    // Getters and setters for all fields
    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }
    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }
    public PensionPlan getPensionPlan() {
        return pensionPlan;
    }
    public long getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public LocalDate getEmploymentDate() {
        return employmentDate;
    }
    public void setEmploymentDate(LocalDate employmentDate) {
        this.employmentDate = employmentDate;
    }
    public double getYearlySalary() {
        return yearlySalary;
    }
    public void setYearlySalary(double yearlySalary) {
        this.yearlySalary = yearlySalary;
    }

    public void setPensionPlan(PensionPlan pensionPlan) {
        this.pensionPlan = pensionPlan;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", employmentDate=" + employmentDate +
                ", enrollmentDate=" + enrollmentDate +
                ", yearlySalary=" + yearlySalary +
                ", pensionPlan=" + pensionPlan +
                '}';
    }
}
