package com.company;

import java.util.*;

public class LongestIncreasingSum {

    public static void main(String args[]) {
        int arr[] = {10, 22, 9, 33, 21, 50, 41, 60 ,80};
        int lis[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
            lis[i] = arr[i];

        for ( int i = 1; i < arr.length; i++ ) {
            for ( int j = 0; j < i; j++ ) {
                if ( arr[i] > arr[j]  && lis[i] < lis[j] + arr[i] ) {
                    lis[i] = lis[j] + arr[i];
                }
            }
        }

        System.out.println("Longest Increasing Sum is " + lis[lis.length - 1]);
    }
}
