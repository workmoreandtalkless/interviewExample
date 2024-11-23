package org.example.interview.interviewexample;

import java.util.*;

class ComparatorExample {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Alice", "Engineering", 85000),
                new Employee(2, "Bob", "Engineering", 90000),
                new Employee(3, "Charlie", "HR", 75000),
                new Employee(4, "Diana", "HR", 80000),
                new Employee(5, "Eve", "Finance", 95000),
                new Employee(6, "Frank", "Engineering", 88000)
        );

        // Comparator for sorting by salary
        Comparator<Employee> salaryComparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return Double.compare(e1.getSalary(), e2.getSalary());
            }
        };

        // Comparator for sorting by name
        Comparator<Employee> nameComparator = (e1, e2) -> e1.getName().compareTo(e2.getName());

        // Sort by salary
        Collections.sort(employees, salaryComparator);
        System.out.println("Sorted by Salary:");
        employees.forEach(System.out::println);

        // Sort by name
        Collections.sort(employees, nameComparator);
        System.out.println("\nSorted by Name:");
        employees.forEach(System.out::println);
    }
}

