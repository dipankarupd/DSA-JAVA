package com.sheet.striver_450.searchsort.binary.array;


import static com.sheet.striver_450.searchsort.binary.array.SearchInRotatedSortedArray.bSearch;

public class SearchInRotatedSortedWithDuplicates {
    public static void main(String[] args) {
        int[] arr = {2,2,3,9,2,2};
        System.out.println(search(arr, 3));
    }

    static boolean search(int[] arr, int t) {
        int piv = findPiv(arr);

        int res = bSearch(arr, 0, piv, t);
        if(res != -1) {
            return true;
        } else {
            res = bSearch(arr, piv+1, arr.length-1, t);
        }
        return res != -1;
    }


    static int findPiv(int [] arr) {

        int s = 0;
        int e = arr.length - 1;

        while (s <= e) {

            int m = s + (e-s)/2;

//            case 1: a[m] > a[m+1]
            if(arr[m]   > arr[m+1]) {
                return m;
            }

//            case 2, m < m-1
            if(arr[m] < arr[m-1]) {
                return  m-1;
            }

            if(arr[s] == arr[m] &&  arr[e] == arr[m]) {
//                decrement both start and end
//                before doing, check if the start index is the ans:
                if(arr[s] > arr[s+1]) {
                    return s;
                }
                s++;

                if(arr[e] > arr[e-1]) {
                    return e;
                }
                e--;
            }
//           case 3: s < m or s = m and m > e:
            if(arr[s] < arr[m] || arr[s] == arr[m] && arr[m] > arr[e]) {
                s = m+1;
            } else {
                e = m-1;
            }
        }
        return -1;
    }
}
