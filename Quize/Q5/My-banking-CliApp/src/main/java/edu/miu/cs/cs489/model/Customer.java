package edu.miu.cs.cs489.model;

import java.time.LocalDate;

public class Customer {
    private long customerId;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private Account account;

    public Customer(long customerId, String firstName, String lastName, LocalDate dateOfBirth) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public long getCustomerId() {
        return customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {

    	return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
    			+ ", dateOfBirth=" + dateOfBirth + ", account=" + account + "]";
    }
}
