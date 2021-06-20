package leetcode.string;

import java.util.*;

public class LongestSubStringWithoutRepeat {

    static final int NO_OF_CHARS = 256;

    /**
     *
     * Efficient Solution from GeekForGeeks
     * @param str
     * @return
     */
    static int longestUniqueSubsttr(String str)
    {
        int n = str.length();

        int res = 0; // result

        // last index of all characters is initialized
        // as -1
        int [] lastIndex = new int[NO_OF_CHARS];
        Arrays.fill(lastIndex, -1);

        // Initialize start of current window
        int i = 0;

        // Move end of current window
        for (int j = 0; j < n; j++) {

            // Find the last index of str[j]
            // Update i (starting index of current window)
            // as maximum of current value of i and last
            // index plus 1
            i = Math.max(i, lastIndex[str.charAt(j)] + 1);

            // Update result if we get a larger window
            res = Math.max(res, j - i + 1);

            // Update last index of j.
            lastIndex[str.charAt(j)] = j;
        }
        return res;
    }

    /**
     * My Solution
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int count = 0;
        int prevIndex = 0;
        int currentCount = 1;
        Queue<Character> queue = new LinkedList<>();
        if ( s.length() == 0 || s.length() == 1)
            return s.length();
        queue.add(s.charAt(0));
        for ( int i = 1; i < s.length(); i++ ) {
            if ( queue.contains(s.charAt(i)) ) {
                while ( s.charAt(prevIndex) != s.charAt(i) ) {
                    prevIndex++;
                    currentCount--;
                    queue.poll();
                }
                prevIndex++;
                currentCount--;
                queue.poll();
            }
            queue.add(s.charAt(i));
            currentCount++;
            if ( currentCount > count )
                count = currentCount;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcbbacd"));
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring(""));


        System.out.println(longestUniqueSubsttr("abcbbacd"));
        System.out.println(longestUniqueSubsttr("abcabcbb"));
        System.out.println(longestUniqueSubsttr("bbbbb"));
        System.out.println(longestUniqueSubsttr("pwwkew"));
        System.out.println(longestUniqueSubsttr(""));

    }
}
