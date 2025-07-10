package com.sheet.striver_450.searchsort.binary;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = {11,12,15,18, 2,5, 6,8};

        int t = 12;
        System.out.println(search(arr, t));
    }

    static int search(int [] arr, int t) {
        int minIdx = findMin(arr);
        int res = bSearch(arr, 0, minIdx-1, t);
        if(res == -1) {
            return bSearch(arr, minIdx, arr.length-1, t);
        }
        return res;
    }

    static int findMin(int[] arr) {

//        many ways to find the minimum index:
        int s = 0;
        int e = arr.length-1;

        while (s < e) {
            int m = s + (e-s)/2;
            if(arr[m] > arr[e]) {
                s = m+1;
            } else {
                e = m;
            }
        }
        return s;
    }

    static int bSearch(int[] arr, int s, int e, int t) {
        while (s <= e) {
            int m = s + (e-s)/2;

            if(arr[m] < t) {
                s = m+1;
            } else if(arr[m] > t) {
                e = m-1;
            }
            else {
                return m;
            }
        }
        return -1;
    }
}
