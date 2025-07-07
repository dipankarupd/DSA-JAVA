package com.sheet.striver_450.array.easy;

import java.util.HashMap;

public class SingleNumber {
    public static void main(String[] args) {
        int[] arr = {4,1,2,1,2};

        System.out.println(singleNumber2(arr));
    }
//    hash-map o(n) space and time
    static int singleNumber(int[] arr) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int x: arr) {
            if(!map.containsKey(x)) {
                map.put(x, 1);
            } else {
                map.put(x, map.get(x)+1);
            }
        }

        for(int x: map.keySet()) {
            if (map.get(x) == 1) {
                return x;
            }
        }
        return -1;
    }

//    better approach : x-or bit
    static int singleNumber2(int[] arr) {
//        a ^ a = 0 and a ^ 0 = a
        int res = 0;
        for(int x: arr) {
            res = res ^ x;
        }
        return res;
    }
}
