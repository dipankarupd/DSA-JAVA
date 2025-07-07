package com.sheet.striver_450.array.easy;

//https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
public class RemoveDuplicate {
    public static void main(String[] args) {
        int[] arr = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(arr));
    }

    static int removeDuplicates(int[] arr) {

        int i = 0;
        int j = 1;

        while(j<arr.length) {
            if(arr[i] != arr[j]) {
                i++;
                arr[i] = arr[j];
            }
            j++;
        }
        return i+1;
    }
}
