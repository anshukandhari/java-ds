package dynamicProgramming.subsetSums;

import java.util.ArrayList;
import java.util.Arrays;

// I think this can be done with prefix sum approach as well. Do try that too.
public class ArrayPartitioning {

  public boolean canPartition(int[] A) {
    int sum = Arrays.stream(A).sum();
    if(sum%2 != 0){
      return false;
    }

    sum /=2;

    boolean dp[][] = new boolean[A.length+1][sum+1];
    // Arrays.sort(A);

    for(int i = 0; i<dp.length; i++){
      for(int j = 0; j<dp[0].length; j++){
        if(j == 0){
          dp[i][j] = true;
        } else if (i == 0){
          dp[i][j] = false;
        } else {
          dp[i][j] = dp[i-1][j];
          if(j-A[i-1]>=0)
            dp[i][j] = dp[i][j] || dp[i-1][j-A[i-1]];
        }
      }
    }

    return dp[A.length][sum];

  }

  private static boolean arrayPartitioning(int a[]){
    int sum = Arrays.stream(a).sum();
    if(sum%2!=0){
      return false;
    }
    sum /=2;
    System.out.println(sum);
    boolean sol[] = new boolean[sum+1];
    ArrayList<Integer> al = new ArrayList<>();

    for(int i = 0; i<a.length;i++){
      for(int j =0; j<sol.length;j++){
        if(sol[j] && j+a[i] <= sum){
          al.add(j+a[i]);
        }
      }
      if(a[i]<=sum){
        al.add(a[i]);
      }

      al.forEach(x -> sol[x]= true);
      al.clear();
    }

    return sol[sum];
  }

  public static void main(String[] args) {
    int a[] = {1, 5, 12, 3, 14, 19};
    if(arrayPartitioning(a)){
      System.out.println("can be partitioned");
    }
  }



}
