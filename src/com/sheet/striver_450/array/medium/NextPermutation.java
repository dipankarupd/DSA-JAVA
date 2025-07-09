package com.sheet.striver_450.array.medium;

import java.util.Arrays;

// https://leetcode.com/problems/next-permutation/description/
public class NextPermutation {

    public static void main(String[] args) {
        int[] arr = {2,1,5,4,3};
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void nextPermutation(int[] arr ){

//        step 1: find the idx i from behind satisfying a[i] < a[i+1]
        int i = -1;
        for(int x = arr.length - 2; x>=0; x--) {
            if(arr[x] < arr[x+1]) {
                i = x;
                break;
            }
        }

//        step 2: if i is still -1, this is the very last permutation. So just return the first one
        if(i == -1) {
            reverse(arr, 0, arr.length-1);
        } else {
//            step 3: if not, find the first element > a[i]
            for(int x = arr.length - 1; x >= 0; x--) {
                if(arr[x] > arr[i]) {
                    swap(arr, x, i);
                    break;
                }
            }

//            step 4: finally reverse the array from i+1 to end
            reverse(arr, i+1, arr.length-1);
        }


    }

    static void reverse(int[] arr, int s, int e){

        while(s < e) {
            swap(arr,s,e);
            s++;
            e--;
        }
    }

    static void swap(int[] arr, int a, int b) {
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }
}
