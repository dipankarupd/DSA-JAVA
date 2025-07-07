package com.sheet.practices;

public class QuickSelect {
//    algorithm to find the kth smallest and kth largest element

    public static void main(String[] args) {
        int[] arr = {2,8,1,3,7,6,5};
        System.out.println(kthSmallest(arr, 3));
    }

    static int kthSmallest(int[] arr, int k) {
        // algo based on partitioning

        return quickSelect(arr, 0, arr.length - 1, k-1);
      }


    static int quickSelect(int[] arr, int s, int e, int idx) {
        // select the pivot:
        int pivot = arr[e];

        int pivotIdx = partition(arr, pivot, s, e);

        if(pivotIdx == idx) {
            return arr[idx];
        } else if(pivotIdx < idx) {
            return quickSelect(arr, pivotIdx + 1, e, idx);
        } else {
            return quickSelect(arr, s, pivotIdx - 1, idx);
        }
    }


    static int partition(int[] arr, int pivot, int s, int e) {
//        on partitioning, all the element <= piv -> left and others on right
//        2 var: i, j

//        how to partition: if idx i is small or equal, swap with j and inc i,j else inc i
//        res is j - 1

        int i = s, j=s;
        while (i < e) {
//
            if(arr[i] > pivot) {
                i++;
            }
            else {
                int temp = arr[i];
                arr [i] = arr[j];
                arr[j] = temp;
                i++;
                j++;
            }

        }
        return j - 1;
    }
}
