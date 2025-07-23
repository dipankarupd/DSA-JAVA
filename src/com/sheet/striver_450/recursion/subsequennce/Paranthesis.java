package com.sheet.striver_450.recursion.subsequennce;


import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/generate-parentheses/description/
public class Paranthesis {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
         helper(n,n, "", res);
         return res;
    }

    private static void helper(int o, int c, String s, List<String> res) {

        if (o == 0 && c == 0) {
            res.add(s);
            return;
        }

//        take the open bracket:
        if (o > 0) {
            helper(o-1, c, s.concat("("), res);
        }

        if(c > o) {
            helper(o, c-1, s.concat(")"), res);
        }

    }
}
