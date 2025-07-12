package com.sheet.striver_450.searchsort.binary.array;

import static com.sheet.striver_450.searchsort.binary.array.FirstAndLastOccurance.searchRange;

public class CountOccurance {
    public static void main(String[] args) {
        int[] arr = {1,2,2,2,2,4};
        int t = 4;

        System.out.println(countOccurance(arr, t));
    }

    static int countOccurance(int[] arr, int t) {

//        find the first and last occurance of the number:
        int[] occurances = searchRange(arr, t);
        if(occurances[0] == -1) return 0;
        return occurances[1] - occurances[0] + 1;
    }
}
