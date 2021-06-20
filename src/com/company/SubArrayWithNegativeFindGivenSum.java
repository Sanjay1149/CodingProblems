package com.company;

import java.util.Arrays;
import java.util.HashMap;

/**
 * https://www.geeksforgeeks.org/find-subarray-with-given-sum-in-array-of-integers/
 */
public class SubArrayWithNegativeFindGivenSum {
    public static void subArraySum(int[] arr, int n, int sum) {
        //cur_sum to keep track of cummulative sum till that point
        int cur_sum = 0;
        int start = 0;
        int end = -1;
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            cur_sum = cur_sum + arr[i];
            //check whether cur_sum - sum = 0, if 0 it means
            //the sub array is starting from index 0- so stop
            if (cur_sum - sum == 0) {
                start = 0;
                end = i;
                break;
            }
            System.out.println("Current Sum -> " + cur_sum + " at i " + i);
            //if hashMap already has the value, means we already
            // have subarray with the sum - so stop
            if (hashMap.containsKey(cur_sum - sum)) {
                start = hashMap.get(cur_sum - sum) + 1;
                end = i;
                break;
            }
            //if value is not present then add to hashmap
            hashMap.put(cur_sum, i);

        }
        // if end is -1 : means we have reached end without the sum
        if (end == -1) {
            System.out.println("No subarray with given sum exists");
        } else {
            System.out.println("Sum found between indexes "
                    + start + " to " + end);
        }

    }

    public static int[] twoSum(int[] nums, int target) {
        int[] sumVal = new int[2];
        int currentSum = 0;
        int start = 0;
        for ( int i=0; i<nums.length; i++) {
            currentSum += nums[i];
            while ( currentSum > target && start<=i) {
                currentSum-= nums[start];
                start++;
            }
            if ( currentSum == target ) {
                sumVal[0] = start;
                sumVal[1] = i;
            }
        }
        return sumVal;
    }

    // Driver code
    public static void main(String[] args) {
//        int[] arr = {10, 2, -2, -20, 10};
//        int sum = -10;
        int[] arr = {1, 4, 20, 3, 10, 5};
        int sum = 33;
        int n = arr.length;
        subArraySum(arr, n, sum);
        Arrays.stream(twoSum(arr, sum)).forEach(System.out::print);

    }
}
