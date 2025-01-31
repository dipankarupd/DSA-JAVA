package com.heaps.problems;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElement {
    public static int findKthLargest(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : arr) {
            pq.add(num);
        }

        for (int i = 0; i < k-1; i++) {
            pq.remove();
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[] { 3,2,3,1,2,4,5,5,6 }, 4));
    }
}
