package com.sheet.striver_450.string.easy;

import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/reverse-words-in-a-string/description/
public class Palindrome {
    public static void main(String[] args) {
        String str = " Hello    World   ";

        System.out.println(reverseWords(str));
    }

    static String reverseWords(String str) {
        String[] res = str.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();

        for (int i = res.length - 1; i >= 0; i--) {
            sb.append(res[i]);
            if (i != 0) sb.append(" ");
        }

        return sb.toString();
    }
}
