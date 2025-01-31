package com.hashmap;

public class Brute {

    public static void main(String[] args) {

        System.out.println(match("Helloworld", "low"));
    }

    static int match(String s1, String s2) {

        int l1 = s1.length();
        int l2 = s2.length();

        for(int i = 0; i<l1-l2; i++) {
            int j = 0;

            while(j < l2 && s1.charAt(i+j) == s2.charAt(j)) {
                j+=1;
            }

            if(j == l2) {
                return i;
            }
        }
        return -1;
    }
}
