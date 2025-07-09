package com.sheet.striver_450.array.medium;

import java.util.HashSet;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] arr = {100,5,200,1,3,2};
        System.out.println(longestConsecutive(arr));
    }

    static int longestConsecutive(int[] arr) {

        int res = 0;

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }

        for(int x: set) {
            int count = 1;

            if(!set.contains(x-1)) {
                while(set.contains(x+1)) {
                    count++;
                    x++;
                }
            }

            res = Math.max(count, res);
        }

        return res;
    }
}
