package com.sheet.practices;

import java.util.HashMap;

public class MaxMinArray {


    public static void main(String[] args) {
        int[] arr = {4,2,6,8,11,1,-2};


        HashMap<String, Integer> res = findMinMax(arr);
        System.out.println("max: " + res.get("max") + " " + "min: " + res.get("min"));

    }

    static HashMap<String, Integer> findMinMax(int[] arr) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        HashMap<String, Integer> res = new HashMap<>();

        int i = 0;
        while(i < arr.length) {
            if(arr[i] < min) {
                min = arr[i];
            }
            if(arr[i] > max) {
                max = arr[i];
            }
            i++;
        }
        res.put("max", max);
        res.put("min", min);

        return res;
    }
}
