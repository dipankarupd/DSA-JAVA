package com.sheet.practices;

import java.util.HashSet;

// https://www.geeksforgeeks.org/problems/union-of-two-arrays3538/1
public class UnionINtersection {
    public static void main(String[] args) {
        int[] a1 = {1,2,3};
        int[] a2 = {2,4,5};

        System.out.println(findUnion(a1,a2));
        
    }
    public static int findUnion(int a[], int b[]) {
        // code here
        int count = 0;

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < a.length; i++) {
            set.add(a[i]);
        }

        for (int i = 0; i < b.length; i++) {
            set.add(b[i]);
        }
        count = set.size();
        return count;
    }
}
