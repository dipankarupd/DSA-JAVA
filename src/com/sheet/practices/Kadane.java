package com.sheet.practices;
//https://www.geeksforgeeks.org/problems/kadanes-algorithm-1587115620/1
public class Kadane {
    public static void main(String[] args) {
        int[] arr =     {2, 3, -8, 7, -1, 2, 3};
        System.out.println(kadane(arr));
    }

    static int kadane(int[] arr) {

        int currSum = arr[0];
        int maxSum = arr[0];

        for(int i=1; i<arr.length; i++) {
            currSum = Integer.max(currSum + arr[i], arr[i]);

            maxSum = Integer.max(maxSum, currSum);
        }
        return  maxSum;
    }
}
