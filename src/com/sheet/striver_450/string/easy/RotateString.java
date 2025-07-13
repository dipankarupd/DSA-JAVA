package com.sheet.striver_450.string.easy;
// https://leetcode.com/problems/rotate-string/description/
public class RotateString {
    public static void main(String[] args) {
        System.out.println(rotateString2("ababccca", "ccaababc"));
    }

    static boolean rotateString(String s, String goal) {

        if (s.length() != goal.length()) return false;

        int n = s.length();

        for (int i = 0; i < n; i++) {
            // Perform left rotation by i characters
            String rotated = s.substring(i) + s.substring(0, i);
            if (rotated.equals(goal)) return true;
        }

        return false;
    }

    static boolean rotateString2(String a, String b) {
        if (a.length() != b.length()) return false;

//        concating a string with itself provides all the possible options for result
        return (a.concat(a).contains(b)) ;
    }
}
