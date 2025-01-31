package com.practice;

import java.util.HashMap;

public class JumpGame2 {
    public static int jump(int[] arr) {
        return func(arr, arr.length, new HashMap<>());
    }

    private static int func(int[] arr, int n, HashMap<Integer, Integer> map) {

        if (n >= arr.length-1) {
            return 0;
        }

        if(map.containsKey(arr[n])) {
            return map.get(arr[n]);
        }

        int ans = Integer.MAX_VALUE;

        for(int i=0; i<= arr[n] + n && i < arr.length ; i++) {
            int val = func(arr, i, map);
            if(val != Integer.MAX_VALUE) {
                ans = Math.min(ans, val + 1);
            }
        }

        map.put(arr[n], ans);
        return ans;
    }
}
