package com.sheet.striver_450.searchsort.binary.array;

// https://leetcode.com/problems/koko-eating-bananas/
public class KokoEatingBanana {
    public static void main(String[] args) {
        int[] arr = {30,11,23,4,20};
        int h = 6;

        System.out.println(minEatingSpeed(arr, h));
    }

    static int minEatingSpeed(int[] arr, int h) {

        int s = 1;
        int e = findMax(arr);

        while(s<e) {
            int m = s+(e-s)/2;

            if(isAccepted(arr, m, h)) {
                e = m;
            } else {
                s = m+1;
            }
        }
        return s;

    }

    static int findMax(int[] arr) {
        int max = arr[0];
        for(int i: arr) {
            if(i > max) {
                max = i;
            }
        }
        return max;
    }

    static boolean isAccepted(int[] arr, int possibleAns, int h) {
        int totalTime = 0;

        for(int i: arr) {
            totalTime += (int) Math.ceil((double)i / (double) possibleAns);
        }

        return totalTime <= h;
    }
}
