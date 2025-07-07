package com.sheet.practices;

import java.util.Arrays;

public class SortZeroOneTwo {
    public static void main(String[] args) {
        int[] arr = {0,0,2,1,0,2,2,1};
        System.out.println(Arrays.toString(sort(arr)));
    }

//    static int[] sort(int[] arr) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//
//        for(int i: arr) {
//            if (map.containsKey(i)) {
//                map.put(i, map.get(i) + 1);
//            } else {
//                map.put(i, 1);
//            }
//        }
//        System.out.println(map.toString());
//
//        int[] res = new int[arr.length];
//        int zc = map.get(0), oc = map.get(1), tc = map.get(2);
//        int i = 0;
//
//        for(int j = 0; j<zc; j++) {
//            res[i++] = 0;
//        }
//
//        for(int j = 0; j<oc; j++) {
//            res[i++] = 1;
//        }
//
//        for(int j = 0; j<tc; j++) {
//            res[i++] = 2;
//        }
//        return res;
//    }

    static int[] sort(int[] arr) {

        int s = 0, e = arr.length - 1, m = 0;

        while(m <= e) {
            if(arr[m] == 0) {
                swap(arr, s, m);
                s++;
                m++;
            } else if(arr[m] == 1) {
                m++;
            } else {
                swap(arr, m, e);
                e--;
            }
        }
        return arr;
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
