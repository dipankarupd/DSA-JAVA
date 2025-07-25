package com.sheet.striver_450.recursion.subsequennce;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
public class PhoneNumberCombination {

    public static void main(String[] args) {

        System.out.println(letterCombinations(""));
    }

    static List<String> letterCombinations(String letters) {

        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        return helper("", letters, map);
    }

    private static List<String> helper(String p, String up, Map<Character, String> map) {

        if (up.isEmpty()) {
            List<String> ans = new ArrayList<>();
            ans.add(p);
            return ans;
        }

        List<String> ans = new ArrayList<>();
        char digit = up.charAt(0);
        char[] choices = map.get(digit).toCharArray();

        for (char choice : choices) {

            ans.addAll(helper(p + choice, up.substring(1), map));
        }
        return ans;
    }
}
