package org.example.interview.interviewexample.algorithm;

public class ReverseWordsLineByLine {
    public static void main(String[] args) {
        // Input sentence
        String sentence = "Java is fun";

        // Step 1: Split the sentence into individual words
        String[] words = sentence.split(" "); // Split sentence into words using space as a delimiter

        // Step 2: Create a StringBuilder to store the reversed result
        StringBuilder reversedSentence = new StringBuilder();

        // Step 3: Iterate through each word
        for (String word : words) {
            // Step 4: Reverse the current word
            StringBuilder reversedWord = new StringBuilder(word); // Convert word to StringBuilder
            reversedWord.reverse(); // Reverse the word

            // Step 5: Append the reversed word to the final result
            reversedSentence.append(reversedWord).append(" "); // Add reversed word and a space
        }

        // Step 6: Trim the trailing space
        String result = reversedSentence.toString().trim();

        // Step 7: Print the original and reversed sentences
        System.out.println("Original Sentence: " + sentence);
        System.out.println("Reversed Words: " + result);
    }
}

