package com.old.array;

public class KokoEatingBanana {

    public static int minEatingSpeed(int[] arr, int h) {
        int k = 0;
        int e = arr[0];
        int s = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > e) {
                e = arr[i];
            }
        }

        while (s < e) {
            int m = (s+e)/2;
            if(accept(arr, m, h)) {
                k = m;
                e  = m-1;
            } else {
                s = m + 1;
            }
        }
        return k;
    }

    private static boolean accept(int[] arr, int m, int h) {
        int ans = 0;
        for(int x: arr) {
            ans = (int) (ans + Math.ceil((double)x/(double)m));
        }
        if (ans <= h) return true;
        return false;
    }
    public static void main(String[] args) {
        System.out.println(minEatingSpeed(new int[]{3,6,7,11}, 8));
    }
}
