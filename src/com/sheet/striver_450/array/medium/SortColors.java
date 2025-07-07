package com.sheet.striver_450.array.medium;

import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        int[] arr = {1,0,1,2,0,1,1,2,0,1,1,2,0,2,2,1,1,0};
        sortColors(arr);
        System.out.println(Arrays.toString(arr));
    }

//    static void sortColors(int[] arr) {
//        int zc = 0, oc = 0, tc = 0;
//
//        for(int x: arr) {
//            switch(x){
//                case 0:
//                    zc+=1;
//                    break;
//
//                case 1:
//                    oc += 1;
//                    break;
//                case 2:
//                    tc += 1;
//                    break;
//            }
//
//        }
//
//        int i = 0;
//        while (i<arr.length) {
//                while(zc > 0) {
//                    arr[i] = 0;
//                    i++;
//                    zc--;
//                }
//
//            while(oc > 0) {
//                arr[i] = 1;
//                i++;
//                oc--;
//            }
//            while(tc > 0) {
//                arr[i] = 2;
//                i++;
//                tc--;
//            }
//
//        }
//    }

    static void sortColors(int[] arr) {
        int s = 0, m = 0, e = arr.length-1;

        while(m <= e) {
            if(arr[m] == 1) m++;
            else if(arr[m] == 0) {
                swap(arr, m ,s);
                s++;
                m++;
            }
            else {
                swap(arr, m, e);
                e--;
            }
        }
    }
    static void swap(int[] arr, int a, int b){
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }

}
