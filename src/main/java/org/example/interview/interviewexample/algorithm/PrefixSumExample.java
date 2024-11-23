package org.example.interview.interviewexample.algorithm;

public class PrefixSumExample {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int L = 1, R = 3;

        // Calculate prefix sum
        int[] prefixSum = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }

        // Calculate sum from L to R
        int sum = prefixSum[R + 1] - prefixSum[L];
        System.out.println("Sum of elements from index " + L + " to " + R + ": " + sum);
    }
}
