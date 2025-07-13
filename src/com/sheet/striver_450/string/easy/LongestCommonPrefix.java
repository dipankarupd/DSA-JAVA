package com.sheet.striver_450.string.easy;

import java.util.Arrays;

// https://leetcode.com/problems/longest-common-prefix/description/
public class LongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[] {"ca","fake","fanta"}));
    }


    static String longestCommonPrefix(String[] arr) {


        Arrays.sort(arr);


        String s1 = arr[0];
        String s2 = arr[arr.length-1];

        int idx = 0;
        while (idx < s1.length() && idx < s2.length()) {
            if (s1.charAt(idx) == s2.charAt(idx)) {
                idx+=1;
            } else break;
        }

        return s1.substring(0,idx);
    }
}
