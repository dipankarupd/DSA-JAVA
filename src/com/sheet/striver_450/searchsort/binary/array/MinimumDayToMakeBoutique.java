package com.sheet.striver_450.searchsort.binary.array;

import static com.sheet.striver_450.searchsort.binary.array.KokoEatingBanana.findMax;

// https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/description/
public class MinimumDayToMakeBoutique {
    public static void main(String[] args) {
        int[] arr = {1,10,3,10,2};
        int m = 3;
        int k = 2;

        System.out.println("hii");
        System.out.println(minDays(arr, m, k));
    }

    static int minDays(int[] arr, int m, int k) {

        if(arr.length < m * k) return -1;
        int s = 1;
        int e = findMax(arr);

        while(s < e) {
            int mid = s + (e-s)/2;

            if(canMake(arr, m, k, mid)) {
                e = mid;
            } else {
                s = mid+1;
            }
        }
        return s;

    }

    static boolean canMake(int[] arr, int m, int k, int mid) {
        int madeBoutiqes = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] <= mid) {
                count += 1;

                if(count == k) {

                    madeBoutiqes += 1;
                    count = 0;
                }
            } else {
                count = 0;
            }
            if(madeBoutiqes == m) {
                return true;
            }
        }
        return false;
    }
}
