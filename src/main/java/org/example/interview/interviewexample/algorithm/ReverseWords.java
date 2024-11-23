package org.example.interview.interviewexample.algorithm;

public class ReverseWords {
    public static void main(String[] args) {
        String sentence = "Java is fun";
        String reversed = reverseWords(sentence);
        System.out.println("Original Sentence: " + sentence);
        System.out.println("Reversed Words: " + reversed);
    }

    public static String reverseWords(String sentence) {
        String[] words = sentence.split(" "); // Split into words
        StringBuilder reversed = new StringBuilder();

        for (String word : words) {
            reversed.append(new StringBuilder(word).reverse()).append(" ");
        }

        return reversed.toString().trim(); // Trim trailing space
    }
}

