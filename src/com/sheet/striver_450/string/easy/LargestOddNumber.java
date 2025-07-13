package com.sheet.striver_450.string.easy;

import javax.xml.stream.events.Characters;

// https://leetcode.com/problems/largest-odd-number-in-string/description/
public class LargestOddNumber {

    public static void main(String[] args) {
        String str = "1047210";
        System.out.println(largestOddNumber(str));
    }

    static String largestOddNumber(String num) {

        for(int i = num.length()-1; i>=0; i--) {
            int lastNumber = Character.getNumericValue(num.charAt(i));

            if(isOdd(lastNumber)) {
                return num.substring(0, i+1);
            }
        }

        return "";
    }

    static boolean isOdd(int n) {
        return (n & 1) != 0;
    }
}
