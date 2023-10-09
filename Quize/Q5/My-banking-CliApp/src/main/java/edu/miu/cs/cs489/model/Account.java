package edu.miu.cs.cs489.model;

import java.time.LocalDate;

public class Account {
    private String accountNo;
    private LocalDate dateOpened;
    private double balance;
    private Customer customer;

    public Account(String accountNo, LocalDate dateOpened, double balance) {
        this.accountNo = accountNo;
        this.dateOpened = dateOpened;
        this.balance = balance;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public LocalDate getDateOpened() {
        return dateOpened;
    }

    public double getBalance() {
        return balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    @Override
    public String toString() {
    	return "Account [accountNo=" + accountNo + ", dateOpened=" + dateOpened + ", balance=" + balance + ", customer="
    			+ customer + "]";
    }
}

