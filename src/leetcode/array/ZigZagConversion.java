package leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion {


    /**
     * They used a flag to go down and up, like a switch. Amazing solution, should start thinking simple
     * Time -> O(n)
     * Space -> O(n) [ This is a downside to this solution while mine doesn't require it , haha pat on my back]
     *
     * @param s
     * @param numRows
     * @return
     */
    public String leetCodeConvert(String s, int numRows) {

        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;

        /**
         * Similar If condition, when it reaches top, Switch is made to go down
         * When it reaches down, Switch is made to go up
         */
        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }

    /**
     * This is exact same approach i thought, They used the concept much properly
     * This approach just takes the one uncommon between the range 0, cycleLen
     * with the simple index at  [ j + cycleLen - 1 ]
     *
     * Really appreciate this
     *
     * @param s
     * @param numRows
     * @return
     */
    public String leetCodeBestConvert(String s, int numRows) {

        if (numRows == 1) return s;

        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
                    ret.append(s.charAt(j + cycleLen - i));
            }
        }
        return ret.toString();
    }

    /**
     * My Solution
     * @param s
     * @param numRows
     * @return
     */
    public static String convert(String s, int numRows) {
        if ( numRows == 1 || s.length() < numRows)
            return s;

        int lengthOfString = s.length();
        StringBuilder stringBuilder = new StringBuilder(lengthOfString);
        /**
         * Get the difference between the first and the next position in the same row.
         * I drew the pattern & formulated this & it worked
         * For num of rows 3-> 4 likewise 4-> 6 and 5 -> 8
         * 0     4     8       12
         * 1  3  5  7  9   11  13
         * 2     6     10
         */
        int arrDiff = 2 * numRows - 2;

        /**
         * starterPos to have current index position
         *
         * x&y will be the calculated arrDiff for i==0 && i==numRows-1
         * 0   4   8    12
         *
         * 2   6   10
         */
        int starterPos;
        int x=arrDiff,y=0;
        int tempDiff;
        int counter;
        for ( int i = 0; i < numRows; i++ ) {
            stringBuilder.append(s.charAt(i));
            starterPos = i;
            if ( i == 0 || i == numRows-1 ) {
                tempDiff = arrDiff;
            } else {
                tempDiff = x;
            }
            counter=0;

            while ( starterPos+tempDiff < lengthOfString ) {
                counter++;
                starterPos+=tempDiff;
                stringBuilder.append(s.charAt(starterPos));

                if ( i != 0 && i != numRows-1 ) {
                    /**
                     * Using counter to add x & y based on it. Let's say numRows is 5, our structure is ->
                     *
                     *  0               8
                     *  1           7   9
                     *  2       6       10
                     *  3   5           11  13
                     *  4               12
                     *
                     *  You can notice 1st row has a sequential diff of 6,2 from 8
                     *  2nd row has a sequential diff of 4,4 from 8
                     *  3rd row has a sequential diff of 2,6 from 8
                     *
                     *  So In a row, Even position takes x space & Odd position take next y space
                     */
                    if ( counter%2==0 ) {
                        tempDiff = x;
                    } else {
                        tempDiff = y;
                    }
                }
            }

            /**
             * Explained above pattern:  6,2    4,4    2,6
             */
            y+=2;
            x=arrDiff-y;
        }

        return stringBuilder.toString();

    }

    public static void main(String[] args) {
        System.out.println("Convert PAYPALISHIRING with 3 " + convert("PAYPALISHIRING",3));
        System.out.println("Convert PAYPALISHIRING with 4 " + convert("PAYPALISHIRING",4));
        System.out.println("Convert PAYPALISHIRING with 5 " + convert("PAYPALISHIRING",5));
    }
}
