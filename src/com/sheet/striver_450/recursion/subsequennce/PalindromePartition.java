package com.sheet.striver_450.recursion.subsequennce;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/palindrome-partitioning/
public class PalindromePartition {

    public static void main(String[] args) {
        List<List<String>> ans = partition("aba");

        for(List<String> x: ans) {
            System.out.println(x);
        }
    }

    static List<List<String>> partition(String s) {

        List<List<String>> ans = new ArrayList<>();
        helper(s, ans, new ArrayList<>());
        return ans;
    }


    static void helper(String s, List<List<String>> ans, List<String> help) {

        if (s.isEmpty()) {
            ans.add(new ArrayList<>(help));
            return;
        }

        for (int i = 1; i <= s.length(); i++) {
            String check = s.substring(0,i);
            if (!checkPalindrome(check)) {
                continue;
            }

//            check for more:
            help.add(check);
            helper(s.substring(i), ans, help);
            help.removeLast();
        }
    }


    static  boolean checkPalindrome(String str) {
        int s = 0;
        int e = str.length()-1;
//        abba
        while (s < e) {

            if (!(str.charAt(s) == str.charAt(e))) {
                return false;
            }
            s++;
            e--;
        }

        return true;
    }
}
