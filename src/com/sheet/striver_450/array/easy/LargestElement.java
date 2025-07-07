package com.sheet.striver_450.array.easy;

public class LargestElement {
    public static void main(String[] args) {
        int[] arr = {3,5,2,4,8,7,9,1};
        System.out.println(largest(arr));
    }

    static int largest(int[] arr) {
        int largest = arr[0];

        for(int i = 1; i< arr.length; i++) {
            if(arr[i] > largest) {
                largest = arr[i];
            }
        }
        return largest;
    }
}
