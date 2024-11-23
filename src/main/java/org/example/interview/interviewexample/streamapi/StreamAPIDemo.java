package org.example.interview.interviewexample.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamAPIDemo {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "Amanda");
        List<String> filtered = names.stream()
                .filter(name -> name.startsWith("A")) // Keep names starting with 'A'
                .collect(Collectors.toList());
        System.out.println("Filtered Names: " + filtered); // [Alice, Amanda]

        List<String> names1 = Arrays.asList("Alice", "Bob", "Charlie");
        List<Integer> nameLengths = names1.stream()
                .map(String::length) // Map each name to its length
                .collect(Collectors.toList());
        System.out.println("Name Lengths: " + nameLengths); // [5, 3, 7]

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sum = numbers.stream()
                .reduce(0, Integer::sum); // Sum all numbers
        System.out.println("Sum: " + sum); // 15


        List<String> names2 = Arrays.asList("Alice", "Bob", "Charlie");
        Set<String> uniqueNames = names2.stream()
                .collect(Collectors.toSet()); // Collect as a Set
        System.out.println("Unique Names: " + uniqueNames);


        List<String> names3 = Arrays.asList("Charlie", "Alice", "Bob");
        List<String> sortedNames = names3.stream()
                .sorted() // Natural sorting
                .collect(Collectors.toList());
        System.out.println("Sorted Names: " + sortedNames); // [Alice, Bob, Charlie]


        List<Integer> numbers1 = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
        List<Integer> distinctNumbers = numbers1.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Distinct Numbers: " + distinctNumbers); // [1, 2, 3, 4, 5]

        List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> limited = numbers2.stream()
                .limit(3) // Take only the first 3 elements
                .collect(Collectors.toList());
        System.out.println("Limited Numbers: " + limited); // [1, 2, 3]

        List<Integer> numbers3 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> skipped = numbers3.stream()
                .skip(2) // Skip the first 2 elements
                .collect(Collectors.toList());
        System.out.println("Skipped Numbers: " + skipped); // [3, 4, 5]

        List<String> names4 = Arrays.asList("Alice", "Bob", "Charlie");
        names4.stream()
                .forEach(System.out::println); // Print each name

        List<Integer> numbers4 = Arrays.asList(2, 4, 6, 8);
        boolean allEven = numbers4.stream().allMatch(num -> num % 2 == 0);
        boolean anyEven = numbers4.stream().anyMatch(num -> num % 2 == 0);
        boolean noneOdd = numbers4.stream().noneMatch(num -> num % 2 != 0);
        System.out.println("All Even: " + allEven); // true
        System.out.println("Any Even: " + anyEven); // true
        System.out.println("None Odd: " + noneOdd); // true


        List<Integer> numbers5 = Arrays.asList(10, 20, 30, 40);
        int max = numbers5.stream().max(Integer::compare).orElseThrow();
        int min = numbers5.stream().min(Integer::compare).orElseThrow();
        System.out.println("Max: " + max); // 40
        System.out.println("Min: " + min); // 10

        List<String> names5 = Arrays.asList("Alice", "Bob", "Charlie");
        long count = names5.stream().filter(name -> name.startsWith("A")).count();
        System.out.println("Count of Names Starting with 'A': " + count); // 1

        List<List<String>> nested = Arrays.asList(
                Arrays.asList("A", "B"),
                Arrays.asList("C", "D")
        );
        List<String> flattened = nested.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println("Flattened List: " + flattened); // [A, B, C, D]


        List<String> names6 = Arrays.asList("Alice", "Bob", "Charlie");
        int totalLength = names6.stream()
                .mapToInt(String::length)
                .sum(); // Calculate sum of all lengths
        System.out.println("Total Length: " + totalLength); // 15


        List<String> names7 = Arrays.asList("Alice", "Bob", "Charlie");
        List<String> peeked = names7.stream()
                .peek(name -> System.out.println("Processing: " + name))
                .collect(Collectors.toList());
        System.out.println("Peeked Names: " + peeked); // [Alice, Bob, Charlie]

    }
}
