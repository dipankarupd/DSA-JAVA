package com.hashmap;

public class PatternMatching {


    private final int prime = 101;

    private long calculateHash(String str) {
        long hash = 0;
        for (int i = 0; i < str.length(); i++) {
            hash = (long) (hash + str.charAt(i) * Math.pow(prime, i));
        }
        return hash;
    }

    private long updateHash(long prev, char old, char newChar, int patternLength) {
        long newHash = (prev - old) / prime;
        newHash = (long) (newHash + newChar * Math.pow(prime, patternLength- 1));
        return newHash;
    }

    public void search(String text, String pattern) {
        int patternLength = pattern.length();
        int textLength = text.length();

        long patterhash = calculateHash(pattern);
        long textHash = calculateHash(text.substring(0, patternLength));

        for (int i = 0; i < textLength - patternLength ; i++) {
            if (textHash == patterhash) {
                if (text.substring(i, patternLength + i).equals(pattern)) {
                    System.out.println("Found at index " + i);
                }
            }
            if (i < textLength - patternLength) {
                textHash = updateHash(textHash, text.charAt(i), text.charAt(i + patternLength), patternLength);
            }
        }
    }
    public static void main(String[] args) {
        PatternMatching patternMatching = new PatternMatching();
        patternMatching.search("HelloWorld", "lo");
    }
}
