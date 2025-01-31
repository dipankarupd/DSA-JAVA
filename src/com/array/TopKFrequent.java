package com.array;

import java.util.ArrayList;
import java.util.HashMap;

public class TopKFrequent {
    static int[] topKFrequent(int[] arr, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i:arr) {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i: map.keySet()) {
            if (map.get(i)>=k) {
                ans.add(i);
            }
        }
        // System.out.println(ans);
        return ans.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args) {
        System.out.println(topKFrequent(new int[]{1,1,1,2,2,3}, 2));
    }
}
