package dynamicProgramming.chainingPattern;

public class MatrixChainMultiplication {

  static int dp[][];

  //recursive approach
  static int matrixChainMultiplicationRecur(int p[], int i, int j) {
    if (i == j)
      return 0;

    int min = Integer.MAX_VALUE;

    // place parenthesis at different places between first
    // and last matrix, recursively calculate count of
    // multiplications for each parenthesis placement and
    // return the minimum count
    for (int k=i; k<j; k++) {
      int count = matrixChainMultiplicationRecur(p, i, k) +
          matrixChainMultiplicationRecur(p, k+1, j) +
          p[i-1]*p[k]*p[j];

      if (count < min)
        min = count;
    }

    // Return minimum count
    return min;
  }

  //memoizationTopDown
  static int matrixChainMultiplicationMemo(int p[], int i, int j) {
    if(dp == null){
      dp = new int[p.length][p.length];
    }

    if(dp[i][j] > 0){
      return dp[i][j];
    }


    if (i == j){
      dp[i][j] = 0;
      return dp[i][j];
    }


    int min = Integer.MAX_VALUE;

    for (int k=i; k<j; k++) {
      int count = matrixChainMultiplicationMemo(p, i, k) +
          matrixChainMultiplicationMemo(p, k+1, j) +
          p[i-1]*p[k]*p[j];

      if (count < min)
        min = count;
    }

    dp[i][j] = min;
    return dp[i][j];
  }

  //Tabular: bottom up
  static int matrixChainMultiplication(int p[]){
    int n = p.length;
    int m[][] = new int[n][n];

    for(int i =1; i < n; i++){
      m[i][i] = 0;
    }

    int j, sum;

    for(int L = 2; L < n;L++) {
      for(int i =1;i<n-L+1; i++){
        j = i+L-1;
        sum =Integer.MAX_VALUE;
        for(int k = i; k<j;k++){
          sum = Math.min(sum, m[i][k]+m[k+1][j] + p[i-1]*p[k]*p[j]);
        }
        m[i][j] = sum;
      }

    }

    return m[1][n-1];
  }

  public static void main(String[] args) {
    int arr[] = new int[] {1, 2, 3, 4};
    System.out.println("Recur: Minimum number of multiplications is "+
      matrixChainMultiplicationRecur(arr,1,arr.length-1));

    System.out.println("Top-down: (memoize) Minimum number of multiplications is "+
        matrixChainMultiplicationMemo(arr,1,arr.length-1));

    System.out.println("Bottom-up: Minimum number of multiplications is "+
        matrixChainMultiplication(arr));
  }
}
