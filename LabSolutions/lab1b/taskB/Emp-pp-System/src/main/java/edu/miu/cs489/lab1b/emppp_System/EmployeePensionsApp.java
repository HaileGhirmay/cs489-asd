package edu.miu.cs489.lab1b.emppp_System;

import edu.miu.cs489.lab1b.emppp_System.model.PensionPlan;
import edu.miu.cs489.lab1b.emppp_System.model.Employee;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
public class EmployeePensionsApp {

    private static List<Employee> employees;

    public EmployeePensionsApp() {

    }

    public static void main(String[] args) {


// Populate the employees list (you can load data from your data source here)
         employees = new ArrayList<>(Arrays.asList(
                new Employee(1L, "Daniel", "Agar", LocalDate.of(2018,1,17), LocalDate.of(2023,1,17),105945.50,"EX1089", 100.00),
                new Employee(2L, "Bernard", "Shaw", LocalDate.of(2018,10,3), null, 197750.50,  null, 100.00),
                new Employee(3L, "Carly", "Agar", LocalDate.of(2014,5,16), LocalDate.of(2019,11,4), 842000.75, "SM2307", 1555.50),
                new Employee(4L, "Wesley", "Schneider", LocalDate.of(2018,11,2),null,74500.00, null, 1000.00)
        ));

        printEmployeesInJSON(employees);
       printMonthlyUpcomingEnrolleesReport(employees);
    }

    public static  void printEmployeesInJSON(List<Employee> employees) {
        // Sort employees by last name in ascending order and then by yearly salary in descending order
        employees.sort(Comparator.comparing(Employee::getLastName)
                .thenComparing(Employee::getYearlySalary, Comparator.reverseOrder()));
        System.out.println(employees);


      /*  String json = employees.stream()
                .map(e -> "{ \"id\": " + e.getEmployeeId() +
                        ", \"firstName\": \"" + e.getFirstName() + "\"" +
                        ", \"lastName\": \"" + e.getLastName() + "\"" +
                        ", \"salary\": " + e.getYearlySalary() + "}"
                                  )
                .collect(Collectors.joining(", ", "[", "]"));
        System.out.println(json);*/
    }

    public static void printMonthlyUpcomingEnrolleesReport(List<Employee> employees) {

        LocalDate nextMonthFirstDay = LocalDate.now().plusMonths(1).withDayOfMonth(1);
        LocalDate nextMonthLastDay = nextMonthFirstDay.plusMonths(1).minusDays(1);

        List<Employee> upcomingEnrollees = employees.stream()
                .filter(employee -> employee.getEmploymentDate().plusYears(5).isBefore(nextMonthLastDay)
                        && employee.getEmploymentDate().plusYears(5).isAfter(nextMonthFirstDay)
                        && employee.getPensionPlan() == null)
                .sorted(Comparator.comparing(Employee::getEmploymentDate))
                .collect(Collectors.toList());
        System.out.println(upcomingEnrollees);

    }

}