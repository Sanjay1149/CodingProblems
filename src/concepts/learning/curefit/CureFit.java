package concepts.learning.curefit;

public class CureFit {

    int maxSum = Integer.MIN_VALUE;
    int[][] dpForSumEdge;

    void findHighestEdgeSum(int arr[], int i, int j,int sum, int k) {
        if ( k == 0 ) {
            if ( maxSum < sum ) {
                maxSum = sum;
            }
            return;
        }
        findHighestEdgeSum(arr,i+1, j, sum + arr[i], k-1);
        findHighestEdgeSum(arr,i, j-1, sum + arr[j], k-1);
    }

    public static void main(String args[]) {
        int arr[] = { 1, 100, 2, 3, 4, 5, 10 };
        CureFit cureFit = new CureFit();
        cureFit.findHighestEdgeSum(arr,0, arr.length-1, 0, 3);
        System.out.println(cureFit.maxSum);
    }
}
