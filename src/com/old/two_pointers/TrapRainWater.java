package com.old.two_pointers;

public class TrapRainWater {
    public static void main(String[] args) {
        System.out.println(trap(new int[] {0,2,0,3,1,0,1,3,2,1}));
    }

    static int trap(int[] height) {
        int ans = 0;

        int[] ml = maxLeft(height);
        int[] mr = maxRight(height);

        for(int i=0; i<height.length; i++) {
            int res = Math.min(ml[i], mr[i]) - height[i];
            ans += res;
        }
        return ans;
    }

    static int[] maxLeft(int[] arr) {
        int[] res = new int[arr.length];
        res[0] = arr[0];
        for(int i=1; i<arr.length; i++) {
            res[i] = Math.max(res[i-1], arr[i]);
        }
        return res;
    }

    static int[] maxRight(int[] arr) {
        int[] res = new int[arr.length];
        res[arr.length-1] = arr[arr.length-1];
        for(int i=arr.length-2; i>=0; i--) {
            res[i] = Math.max(res[i+1], arr[i]);
        }
        return res;
    }
}
