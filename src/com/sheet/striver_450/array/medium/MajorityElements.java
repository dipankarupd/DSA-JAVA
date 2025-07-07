package com.sheet.striver_450.array.medium;

// https://leetcode.com/problems/majority-element/description/
public class MajorityElements {
    public static void main(String[] args) {
        int[] arr = {1,1,2,0,4,3,4,0,1,1};
        System.out.println(majorityElement(arr));
    }

    static int majorityElement(int[] arr) {
        int res = arr[0];
        int count = 1;

        for(int i = 1; i<arr.length; i++) {
            if(arr[i] == res) {
                count++;
            } else {
                count --;

            }

            if(count == 0) {
                res = arr[i];
                count = 1;
            }
        }

        return res;
    }
}
