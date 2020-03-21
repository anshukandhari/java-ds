package dynamicProgramming.lisPattern;

import java.util.Arrays;

// https://www.geeksforgeeks.org/maximum-sum-increasing-subsequence-dp-14/
public class MaxSumIncreasingSubsequence {

  // Follow this one since it is analogous to LIS
  public static int maxSumIncSubsequence(int A[]){
    int sol[] = new int[A.length];
    for(int i = 0; i< A.length; i++){
      sol[i] = A[i];
    }

    for(int i = 1; i < A.length; i++){
      for(int j = 0; j<i; j++){
        if(A[j]< A[i] && sol[i] < sol[j] + A[i])
          sol[i] = sol[j] + A[i];
      }
    }

    return Arrays.stream(sol).max().getAsInt();
  }

  public static int maxSumIncSubsequence2(int A[]){
    int sol[] = new int[A.length];
    int start;

    for(int i = 0; i<A.length; i++){
      sol[i] = A[i];
    }

    for(int i = 0; i<A.length; i++){
      start = sol[i];

      for(int j = i+1; j< A.length; j++){
        if(A[j]> A[i]){
          sol[j] = Math.max(sol[j], A[j]+start);
        }
      }
    }

    return Arrays.stream(sol).max().getAsInt();
  }





  public static void main(String args[]) {
    int arr[] = new int[]{1, 101, 2, 3, 100, 4, 5};
    int n = arr.length;

    System.out.println("Sum of maximum sum "+ "increasing subsequence is "+ maxSumIncSubsequence(arr));
    System.out.println("Sum of maximum sum "+ "increasing subsequence is "+ maxSumIncSubsequence2(arr));
  }

}
