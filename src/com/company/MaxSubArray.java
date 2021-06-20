package com.company;

import java.util.Arrays;
import java.util.List;

public class MaxSubArray {

    public static void printPermutation(List<Integer> array, int maxCapacity) {
        int currentMax = 0, currentSum = 0;
        for ( int i = 0; i < array.size()-1; i++ ) {
            for ( int j = i + 1; j <= array.size(); j++ ) {
                currentSum = array.subList(i, j).stream().reduce(0,(total,val) -> total+val);
                System.out.println(Arrays.toString(array.subList(i, j).toArray()) + " and sum is " + currentSum );
                if ( currentMax < currentSum && currentSum <= maxCapacity )
                    currentMax = currentSum;
            }
        }
        System.out.println("Maximum Sum Sub Array is " + currentMax);
    }

    public static void main(String[] args) {
        List<Integer> array = List.of(7,9,31,23,11,1,5,6,2,5,8,1);
        int maxCapacity = 49;
        printPermutation(array, maxCapacity);
    }
}
