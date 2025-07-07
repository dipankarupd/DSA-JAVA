package com.old.heaps.problems;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {

    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int stone : stones) {
            pq.add(stone);
        }

        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();
            if (first > second) {
                pq.add(first - second);
            }

        }
        return pq.isEmpty() ? 0 : pq.poll();
    }

    public static void main(String[] args) {
        System.out.println(lastStoneWeight(new int[] {2,7,4,1,8,1 }));
    }
}
