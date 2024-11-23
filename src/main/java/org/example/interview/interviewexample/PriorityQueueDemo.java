package org.example.interview.interviewexample;

import java.util.PriorityQueue;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        // Create a PriorityQueue of integers
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> b-a);

        // Add elements to the PriorityQueue using add() and offer()
        pq.add(20); // Adds 20 to the queue
        pq.offer(15); // Adds 15 to the queue
        pq.add(30);
        pq.offer(10);

        // Display the PriorityQueue
        System.out.println("PriorityQueue: " + pq);

        // Retrieve the head of the queue without removing it using peek()
        System.out.println("Peek (head of the queue): " + pq.peek());

        // Retrieve and remove the head of the queue using poll()
        System.out.println("Poll (remove head): " + pq.poll());

        // Check the PriorityQueue after poll()
        System.out.println("PriorityQueue after poll: " + pq);

        // Remove a specific element using remove()
        pq.remove(20);
        System.out.println("PriorityQueue after removing 20: " + pq);

        // Check if the queue contains a specific element
        System.out.println("Contains 15? " + pq.contains(15));

        // Iterate over the elements using for-each loop
        System.out.println("Iterating through the PriorityQueue:");
        for (int num : pq) {
            System.out.println(num);
        }

        // Clear all elements in the PriorityQueue
        pq.clear();
        System.out.println("PriorityQueue after clear: " + pq);

        // Check if the PriorityQueue is empty
        System.out.println("Is PriorityQueue empty? " + pq.isEmpty());
    }
}
/*
PriorityQueue: [10, 15, 30, 20] level order
Peek (head of the queue): 10
Poll (remove head): 10
PriorityQueue after poll: [15, 20, 30]
PriorityQueue after removing 20: [15, 30]
Contains 15? true
Iterating through the PriorityQueue:
15
30
PriorityQueue after clear: []
Is PriorityQueue empty? true
 */
