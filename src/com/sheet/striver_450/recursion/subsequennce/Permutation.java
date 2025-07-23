package com.sheet.striver_450.recursion.subsequennce;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public static void main(String[] args) {
        System.out.println(permutation("", "abc"));
    }

    static void permutationVoid(String p, String up) {

        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);

        for (int i = 0; i < p.length()+1; i++) {
            String first = p.substring(0,i);
            String end = p.substring(i);
            permutation(first+ch+end, up.substring(1));
        }
    }

    private static List<String> permutation(String p, String up) {

        if (up.isEmpty()) {
            ArrayList<String> ans = new ArrayList<>();
            ans.add(p);
            return ans;
        }

        ArrayList<String> res = new ArrayList<>();
        char ch = up.charAt(0);
        for (int i = 0; i < p.length()+1; i++) {
            String first = p.substring(0,i);
            String end = p.substring(i);
            res.addAll(permutation(first+ch+end, up.substring(1)));
        }
        return res;
    }
}
