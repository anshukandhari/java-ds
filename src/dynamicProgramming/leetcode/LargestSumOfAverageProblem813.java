package dynamicProgramming.leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

public class LargestSumOfAverageProblem813 {
  public double largestSumOfAverages(int[] A, int K) {
    double m[][] = new double[A.length+1][K];
    double sum[] = new double[A.length];
    int temp = 0;
    for(int i = 0; i< A.length; i++){
      temp += A[i];
      sum[i] = temp;
    }

    for(int j = 0; j < K ; j++){
      for(int i = 0; i<= A.length; i++){
        if(i<j){
          continue;
        }
        if(i == 0){
          m[i][j] = 0;
          continue;
        }
        if(j == 0){
          m[i][j] = sum[i-1]/i;
          continue;
        }

        for(int x = 1; x<i; x++){
          m[i][j] = Math.max(m[i][j], m[x][j-1] + (sum[i-1]-sum[x-1])/(i-x));
        }

      }
    }

    return m[A.length][K-1];

  }



  public static void main(String[] args) {
    LargestSumOfAverageProblem813 lc = new LargestSumOfAverageProblem813();
    System.out.println(lc.largestSumOfAverages(new int[]{9,1,2,3,9}, 3));
  }


}
