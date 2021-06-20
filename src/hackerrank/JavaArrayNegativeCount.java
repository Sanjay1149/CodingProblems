package hackerrank;

import java.util.Scanner;

public class JavaArrayNegativeCount {

    /**
     * Efficient Solution from Discussion -> O(n^2)
     * @param arr
     * @param n
     * @return
     */
    public static int kadaneAlgorithmSolution(String[] arr, int n) {
        int count=0;
        for(int j=0;j<n;j++){
            int sum=0;
            for(int k=j;k<n;k++){
                sum=Integer.parseInt(arr[k])+sum;
                if(sum<0){
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * This is my solution, didn't think this through properly -> O(n^3)
     * @param arr
     * @param n
     * @return
     */
    public static int totalNegativeCount(String[] arr, int n ) {
        int negativeCount = 0;
        int portion = 1;
        int i,j,k;
        for ( k = 0; k < n; k++ ) {
            for (  i = 0; i < n - portion + 1; i++ ) {
                int sum = 0;
                for ( j = i; j < i + portion && j < n; j++ ) {
                    sum+= Integer.parseInt(arr[j]);
                }
                if ( sum < 0 ) {
                    negativeCount++;
                }
            }
            portion++;
        }
        return negativeCount;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        String arr[] = in.nextLine().split(" ");
        System.out.println(kadaneAlgorithmSolution(arr,n));
        System.out.println(totalNegativeCount(arr,n));
    }
}
