package edu.miu.cs.cs489;

import edu.miu.cs.cs489.model.Account;
import edu.miu.cs.cs489.model.Customer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class BankingApp {
        private static List<Customer> customers = new ArrayList<>();
        private static List<Account> accounts = new ArrayList<>();

        public static void main(String[] args) {
            // Initialize data
            initializeCustomers();
            initializeAccounts();
            associateCustomersWithAccounts();

            // Implement your CLI functionality here
            // You can call methods to print JSON data and perform other operations
        }

        // Method to initialize customer data
        private static void initializeCustomers() {
            customers.add(new Customer(1, "Daniel", "Agar", LocalDate.of(1978, 1, 17)));
            customers.add(new Customer(2, "Benard", "Shaw", LocalDate.of(2004, 10, 20)));
            customers.add(new Customer(3, "Carly", "DeFiori", LocalDate.of(2014, 5, 16)));
            customers.add(new Customer(4, "Wesley", "Schneider", LocalDate.of(2001, 11, 2)));
        }

        // Method to initialize account data
        private static void initializeAccounts() {
            accounts.add(new Account("SV1089", LocalDate.of(2013, 10, 10), 950.00));
            accounts.add(new Account("CK1007", LocalDate.of(2013, 10, 9), 100005.00));
            accounts.add(new Account("SV2307", LocalDate.of(2019, 11, 4), 1555.50));
            accounts.add(new Account("CK1423", LocalDate.of(2012, 1, 15), 125009.55));
        }

        // Method to associate customers with accounts
        private static void associateCustomersWithAccounts() {
            customers.get(0).setAccount(accounts.get(0));
            customers.get(1).setAccount(accounts.get(1));
            customers.get(2).setAccount(accounts.get(2));
            customers.get(3).setAccount(accounts.get(3));
        }

        // Method to print the list of all Customers in JSON format, sorted by Last Name
        public static void printAllCustomersJSON() {
            // Implement JSON printing logic here

            List<Customer> sortedCustomers = customers.stream()
                    .sorted(Comparator.comparing(Customer::getLastName))
                    .collect(Collectors.toList());


        }

        // Method to print the data of Platinum Account Customers in JSON format, sorted by balance and account number
        public static void printPlatinumCustomersJSON() {
            // Implement Platinum Customer JSON printing logic here
          //Filter customers who qualify as platinum account holders (balance >= $100,000)
        var  platinumCustomers = customers.stream()
                    .filter(customer -> customer.getAccount() != null && customer.getAccount().getBalance() >= 100000.00)
                    .collect(Collectors.toList());
            System.out.println(platinumCustomers);



            // Sort platinum customers by balance (descending) and then by account number
            platinumCustomers.sort((c1, c2) -> {
                if (c1.getAccount().getBalance() != c2.getAccount().getBalance()) {
                    return Double.compare(c2.getAccount().getBalance(), c1.getAccount().getBalance());
                } else {
                    return c1.getAccount().getAccountNo().compareTo(c2.getAccount().getAccountNo());
                }
            });

        }
    }
