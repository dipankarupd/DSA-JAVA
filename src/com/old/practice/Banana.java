package com.old.practice;

public class Banana {
    public static int minEatingSpeed(int[] arr, int h) {
        int ans = 0;
        int s = 0;
        int e = arr[0];

        // find the maximum time taken
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > e) {
                e = arr[i];
            }
        }

        // the speed will be between 0 and e
        while(s < e) {
            int m=(s+e)/2;
            if(check(arr,m,h)) {
                ans = m;
                e = m-1;
            } else {
                s = m + 1;
            }
        }

        return ans;
    }

    static boolean check(int[] arr, int m, int h) {
        int ans = 0;
        for (int i: arr) {
            ans += Math.ceil((double)i / (double)m);
        }
        return ans <= h;
    }

}
