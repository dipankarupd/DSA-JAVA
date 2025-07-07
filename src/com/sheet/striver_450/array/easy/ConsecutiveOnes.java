package com.sheet.striver_450.array.easy;

public class ConsecutiveOnes {
    public static void main(String[] args) {
        int[] arr = {1,1,0,1,0,1,1};
        System.out.println(findMaxConsecutiveOnes(arr));
    }

    static int findMaxConsecutiveOnes(int[] arr) {
        int max = 0;
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 0) {
                max = Math.max(max, count);
                count = 0;
            }
            else {
                count++;
            }
        }
        max = Math.max(max, count);
        return max;
    }
}
