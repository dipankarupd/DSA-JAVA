package com.array;

import java.util.HashMap;

public class Occurance {

    public static int singleDuplicate(int[] arr) {
        if(arr.length == 1) {
            return arr[0];
        }

        int s = 0, e = arr.length - 1;

        while(s < e) {
            int m =  s + (e-s)/2;
            if(m % 2 == 1) {
                m--;
            }

            if(arr[m] == arr[m+1]) {
                s = m+2;
            }
            else {
                e = m;
            }
        }
        return arr[s];
    }

    static int duplicate(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {

            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        int ans = 0;
        for (int key : map.keySet()) {
            if (map.get(key) == 1) {
                ans = key;
            }
        }
        return ans;
    }

    static int duplicate2(int[] arr) {
        int res = 0;
        for(int i:arr) {
            res = res ^ i;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(singleDuplicate(new int[]{1,2,2,3,3,4,4}));
        System.out.println(duplicate(new int[]{1,1,2,3,3,4,4}));
        System.out.println(duplicate2(new int[]{1,1,2,2,3,4,4}));
    }
}
