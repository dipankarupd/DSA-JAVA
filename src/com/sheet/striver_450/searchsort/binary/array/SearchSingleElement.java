package com.sheet.striver_450.searchsort.binary.array;
//https://leetcode.com/problems/single-element-in-a-sorted-array/
public class SearchSingleElement {
    public static void main(String[] args) {
        int[] arr = {1,1,2,2,3,4,4};
        System.out.println(singleNonDuplicate(arr));
    }

    public static int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Edge cases: if mid is at the boundary
            if (mid == 0 || mid == nums.length - 1) {
                return nums[mid];
            }

            // Unique element found
            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            }

            // Determine the left side length
            boolean pairOnLeft = nums[mid] == nums[mid - 1];
            int leftLength = pairOnLeft ? mid - 1 : mid;

            if (leftLength % 2 == 1) {
                // Odd length → single element is on the left
                right = pairOnLeft ? mid - 2 : mid - 1;
            } else {
                // Even length → single element is on the right
                left = pairOnLeft ? mid + 1 : mid + 2;
            }
        }

        // Control shouldn't reach here
        return -1;
    }
}
