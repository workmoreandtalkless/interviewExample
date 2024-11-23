package org.example.interview.interviewexample;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // List of Employees
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Alice", "Engineering", 85000),
                new Employee(2, "Bob", "Engineering", 90000),
                new Employee(3, "Charlie", "HR", 75000),
                new Employee(4, "Diana", "HR", 80000),
                new Employee(5, "Eve", "Finance", 95000),
                new Employee(6, "Frank", "Engineering", 88000)
        );

        // 1. Using Map to store department-wise average salaries
        Map<String, Double> avgSalariesByDepartment = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(emp -> emp.salary)
                ));
        System.out.println("Average Salaries by Department: " + avgSalariesByDepartment);

        // 2. Using PriorityQueue to sort employees by salary in descending order
        PriorityQueue<Employee> pq1 = new PriorityQueue<>((e1, e2) -> Double.compare(e2.salary, e1.salary));
        pq1.addAll(employees);
        // Define an explicit comparator for sorting employees by salary in descending order
        Comparator<Employee> salaryComparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return Double.compare(e2.getSalary(), e1.getSalary());
            }
        };

        // Use the comparator with PriorityQueue
        PriorityQueue<Employee> pq = new PriorityQueue<>(salaryComparator);
        pq.addAll(employees);
        System.out.println("\nEmployees sorted by salary (descending):");
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }

        // 3. Using Stream API with groupingBy to group employees by department
        Map<String, List<Employee>> employeesByDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        System.out.println("\nEmployees grouped by department:");
        employeesByDepartment.forEach((department, empList) -> {
            System.out.println(department + ": " + empList);
        });
    }
}
/*
Average Salaries by Department: {Engineering=87666.66666666667, Finance=95000.0, HR=77500.0}

Employees sorted by salary (descending):
Employee{id=5, name='Eve', department='Finance', salary=95000.0}
Employee{id=2, name='Bob', department='Engineering', salary=90000.0}
Employee{id=6, name='Frank', department='Engineering', salary=88000.0}
Employee{id=1, name='Alice', department='Engineering', salary=85000.0}
Employee{id=4, name='Diana', department='HR', salary=80000.0}
Employee{id=3, name='Charlie', department='HR', salary=75000.0}

Employees grouped by department:
Engineering: [Employee{id=1, name='Alice', department='Engineering', salary=85000.0}, Employee{id=2, name='Bob', department='Engineering', salary=90000.0}, Employee{id=6, name='Frank', department='Engineering', salary=88000.0}]
Finance: [Employee{id=5, name='Eve', department='Finance', salary=95000.0}]
HR: [Employee{id=3, name='Charlie', department='HR', salary=75000.0}, Employee{id=4, name='Diana', department='HR', salary=80000.0}]
 */