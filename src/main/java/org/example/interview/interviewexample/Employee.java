package org.example.interview.interviewexample;

import java.util.*;
import java.util.stream.Collectors;

class Employee implements Comparable<Employee>{
    int id;
    String name;
    String department;
    double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }

    // Getter methods
    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }
    @Override
    public int compareTo(Employee other) {
        // Natural order based on id
        return Integer.compare(this.id, other.id);
    }


}
class ComparableExample {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Alice", "Engineering", 85000),
                new Employee(2, "Bob", "Engineering", 90000),
                new Employee(3, "Charlie", "HR", 75000),
                new Employee(4, "Diana", "HR", 80000),
                new Employee(5, "Eve", "Finance", 95000),
                new Employee(6, "Frank", "Engineering", 88000)
        );

        Collections.sort(employees); // Uses Comparable
        System.out.println("Sorted by ID (Natural Order):");
        employees.forEach(System.out::println);
    }
}



