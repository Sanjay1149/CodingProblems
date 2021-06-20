package hackerearth;

import java.util.Arrays;

public class HackerEarth {
    static String areBookingsPossible(int []A, int []B,
                                      int K)
    {
        Arrays.sort(A);
        Arrays.sort(B);
        for(int i = 0; i < A.length; i++)
        {
            if (i + K < A.length && A[i + K] < B[i])
            {
                return "No";
            }
        }
        return "Yes";
    }

    // Driver Code
    public static void main(String []s)
    {
        int []arrival = { 1,3,4,5,7 };
        int []departure = { 2,7,8,9,10 };
        int K = 2;
        System.out.print(areBookingsPossible(
                arrival, departure, K));
    }
}
