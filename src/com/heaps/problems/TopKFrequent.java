package com.heaps.problems;

import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFrequent {

    public static int[] topKFrequent(int[] arr, int k) {
        int[] res = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();

        // Count frequency of elements
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        // Use max-heap based on frequency
        PriorityQueue<Integer> heap =
                new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));

        for (int key : map.keySet()) {
            heap.add(key);
        }

        // Extract top k elements
        for (int i = 0; i < k; i++) {
            res[i] = heap.poll();
        }

        return res;
    }

    public static void main(String[] args) {
        int[] result = topKFrequent(new int[]{-1,-1}, 1);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
