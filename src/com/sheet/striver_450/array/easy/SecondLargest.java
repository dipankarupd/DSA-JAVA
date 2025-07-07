package com.sheet.striver_450.array.easy;

public class SecondLargest {
    public static void main(String[] args) {
        int[] arr = {3,5,2,4,8,7,9,1};
        System.out.println(second(arr));
    }

    static int second(int[] arr) {
        int largest = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for(int i = 0; i< arr.length; i++) {
            if(arr[i] > largest) {
                second = largest;
                largest = arr[i];
            }

            if(arr[i] > second && arr[i] != largest) {
                second = arr[i];
            }
        }
        return  second;
    }
}
