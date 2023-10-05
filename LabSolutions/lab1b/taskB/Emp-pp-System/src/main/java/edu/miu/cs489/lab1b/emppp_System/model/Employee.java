package edu.miu.cs489.lab1b.emppp_System.model;

import java.time.LocalDate;

public class Employee {
    private long employeeId;
    private String firstName;
    private String lastName;
    private LocalDate employmentDate;
    private LocalDate enrollmentDate;
    private double yearlySalary;
private String planReferenceNumber;
private PensionPlan pensionPlan; // Employee's associated PensionPlan (if any)



    public Employee(long employeeId, String firstName, String lastName, LocalDate employmentDate, LocalDate enrollmentDate, double yearlySalary, String planReferenceNumber, double monthlyContribution) {

        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.employmentDate = employmentDate;
        this.enrollmentDate = enrollmentDate;
        this.yearlySalary = yearlySalary;
        this.pensionPlan = (planReferenceNumber==null)?null : new PensionPlan(planReferenceNumber,enrollmentDate,monthlyContribution);
    }
    public Employee(){

    }


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

    public void setPlanReferenceNumber(String planReferenceNumber) {
        this.planReferenceNumber = planReferenceNumber;
    }

    public String getPlanReferenceNumber() {
        return planReferenceNumber;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Employee{");
        sb.append("employeeId=").append(employeeId);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", employmentDate=").append(employmentDate);
        sb.append(", yearlySalary=").append(yearlySalary);
        sb.append(", pensionPlan=").append(pensionPlan);
        sb.append('}');
        return sb.toString();
    }
}
