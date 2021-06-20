package com.company;

import java.util.*;

public class SubStringPalindrome {
    static Map<String, Boolean> palindromeMap = new HashMap<>();
    static Set<String> trieSet = new HashSet<>();

    public static void checkPalindrome(String word) {
        if ( palindromeMap.containsKey(word) ) {
//            return palindromeMap.get(word);
        } else {
            int n = word.length();
            char[] charArray = word.toCharArray();
            for ( int i = 0; i < n; i++ ) {
                if ( charArray[i] != charArray[n-1] ) {
                    palindromeMap.put(word, false);
                    return;
                }
                n--;
            }
            palindromeMap.put(word, true);
            System.out.println(word);
        }
    }

    public static void subStringGenerate(String word) {
        for ( int k=0; k<word.length()-1; k++ ) {
            char[] charArray = new char[word.length() + 1];
            int tempindex = 0;
            charArray[tempindex++] = word.charAt(k);
            for ( int i=k+1; i<word.length(); i++) {
                charArray[tempindex++] = word.charAt(i);
                charArray[tempindex] = '\0';
                checkPalindrome(String.valueOf(charArray).substring(0,tempindex));
            }
        }
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the input ");
        String word = in.nextLine();
        subStringGenerate(word);
    }
}
