package dynamicProgramming.leetcode;

import java.util.Arrays;
//TODO: Super amazing explanation https://leetcode.com/problems/partition-array-for-maximum-sum/discuss/291057/Java-visualize-the-pattern
public class PartitionArrayMaxSum {

  public static int maxSumAfterPartitioning(int[] A, int K) {
    int N = A.length, dp[] = new int[N];
    for (int i = 0; i < N; ++i) {
      int curMax = 0;
      for (int k = 1; k <= K && i - k + 1 >= 0; ++k) {
        curMax = Math.max(curMax, A[i - k + 1]);
        dp[i] = Math.max(dp[i], (i >= k ? dp[i - k] : 0) + curMax * k);
      }
    }
    System.out.println(Arrays.toString(dp));
    return dp[N - 1];
  }

  // [1, 30, 45, 54, 63, 72, 84]
  public static void main(String[] args) {
    System.out.println(maxSumAfterPartitioning(new int[]{1,15,7,9,2,5,10}, 3));
  }

}
