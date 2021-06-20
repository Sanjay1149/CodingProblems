package com.company;

import java.util.HashMap;
import java.util.Map;

public class CountPairsWithGivenSum {
    /**
     * https://www.geeksforgeeks.org/count-pairs-with-given-sum/
     */

    public static void main(String[] args) {
/*        int[] arr = {10, 12, 10, 15, -1, 7, 6,
                5, 4, 2, 1, 1, 1};
        int sum = 11;*/
        int[] arr = {1,2,3,1,1,3};
        int sum = 2;
        int count = getCountPairs(arr, sum);
        System.out.println(count);
    }

    private static int getCountPairs(int[] arr, int sum) {
        int count = 0, dupCount;
        Map<Integer, Integer> countMap = new HashMap<>();
        for ( int pairVal : arr ) {
            if ( countMap.containsKey(sum - pairVal) ) {
                dupCount = countMap.get(sum - pairVal);
                count+=dupCount;
                for ( int i = 0; i < dupCount; i++ ) {
                    System.out.println("Pair -> [ " + (sum - pairVal) + " , " + pairVal + " ]");
                }
                countMap.put(pairVal, dupCount + 1);
            } else {
                dupCount = countMap.getOrDefault(pairVal, 0);
                countMap.put(pairVal, dupCount + 1);
            }
        }

        return count;
    }
}
