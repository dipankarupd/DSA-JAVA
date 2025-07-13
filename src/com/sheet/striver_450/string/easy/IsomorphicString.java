package com.sheet.striver_450.string.easy;

import java.util.HashMap;
import java.util.HashSet;

// https://leetcode.com/problems/isomorphic-strings/description/
public class IsomorphicString {

    public static void main(String[] args) {
        System.out.println(isIsomorphic("foo","bar"));
    }

    static boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;

        HashMap<Character, Character> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            char charOfS = s.charAt(i);
            char charOfT = t.charAt(i);

            if (!map.containsKey(charOfS)) {
                if(!map.containsValue(charOfT)) {
                    map.put(charOfS, charOfT);
                } else {
                    return false;
                }
            } else {
                if(map.get(charOfS) != charOfT) {
                    return false;
                }
            }
        }
        return true;
    }
}
