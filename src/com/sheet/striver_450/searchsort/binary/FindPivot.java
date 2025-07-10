package com.sheet.striver_450.searchsort.binary;

public class FindPivot {
    public static void main(String[] args) {
        int[] arr = {11,12,13,15, 2,5,6,7};
        System.out.println(findPivot(arr));
    }

    static int findPivot(int[] arr) {

//        pivot element -> a[p] > a[p+1] and a[p] > a[p-1]

        int s = 0;
        int e = arr.length-1;

        while (s <= e) {

            int m = s + (e-s)/2;

            if(m < e && arr[m] > arr[m+1]) {
                return m;
            }

            if(m > s && arr[m] < arr[m-1]) {
                return m-1;
            }

            if(arr[s] > arr[m]) {
                e = m-1;
            }
            else {
                s = m+1;
            }
        }
        return -1;
    }
}
