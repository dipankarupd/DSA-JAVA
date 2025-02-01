package com.two_pointers;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,7,2,5,4,7,3,6}));
    }

    static int maxArea(int[] arr) {

        int ans = 0;
        int s = 0;
        int e = arr.length - 1;

        while (s < e) {

            ans = Math.max(ans, (e-s)*Math.min(arr[s], arr[e]));

            if (arr[s] < arr[e]) {
                s++;
            }
            else  e--;
        }
        return ans;
    }
}
