package com.company;

import java.util.Arrays;

public class LongestCommonSubString {

    public static boolean isPalindrome(String s) {
        int n = s.length();
        int last = n-1;
        for( int i = 0; i < n/2; i++, last --) {
            if ( s.charAt(i) != s.charAt(last) )
                return false;
        }
        return true;
    }

    public static int lcs(String s1, String s2, int m, int n) {
        int dp[][] = new int[m + 1][n + 1];

        // To store length of the longest
        // common substring
        int result = 0, newResult = 0,x = 0;
        StringBuilder stringBuilder = new StringBuilder();
        String commonMostString = "";
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j]
                            = dp[i - 1][j - 1] + 1;
                    newResult = Integer.max(result,
                            dp[i][j]);
                    if (newResult > result) {
//                        stringBuilder.append(s1.charAt(i - 1));
                        result = newResult;
                        x = j;
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }
/*        if ( commonMostString == "") {
            commonMostString = stringBuilder.toString();
        } else if ( stringBuilder.length() > commonMostString.length() ) {
            commonMostString = stringBuilder.toString();
        }*/
        Arrays.stream(dp).forEach((a) -> {
            Arrays.stream(a).forEach(System.out::print);
            System.out.println();
        });
/*        if ( x + result  <= n) {
            if ( isPalindrome(s2.substring( x , x+result)) ) {
                commonMostString = s2.substring( x , x+result);
            }
        }*/
        if (  isPalindrome(s2.substring(x-result, x))  ) {
            commonMostString = s2.substring(x-result, x);
        }
        System.out.println("Value is " + commonMostString);
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Longest Common SubString " + lcs("aacabdkacaa", "aacakdbacaa", 11, 11));
    }
}
