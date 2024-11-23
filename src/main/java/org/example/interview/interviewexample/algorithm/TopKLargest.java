package org.example.interview.interviewexample.algorithm;

import java.util.PriorityQueue;

public class TopKLargest {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 3;

        System.out.println("Top " + k + " Largest Numbers: " + findTopK(nums, k));
    }

    public static PriorityQueue<Integer> findTopK(int[] nums, int k) {
        // Min-heap with size k
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : nums) {
            pq.offer(num);
            if (pq.size() > k) {
                pq.poll(); // Remove the smallest element if heap size exceeds k
            }
        }

        return pq; // Contains top K largest numbers
    }
}
