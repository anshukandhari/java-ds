package dynamicProgramming.subsetSums;

import java.util.Arrays;

public class CombinationSumProblem377 {
  public static int combinationSum4(int[] nums, int target) {
    //Check for base case
    // Remove this if negative numbers are allowed
    if(target == 0){
      return 1;
    }

    if(nums.length == 0){
      return 0;
    }

    int dp[][] = new int[nums.length+1][target+1];

    for(int i =0; i<=nums.length; i++){
      for(int j =0; j<=target; j++){
        if(j == 0){
          dp[i][j] = 1;
          continue;
        }
        if(i == 0){
          dp[i][j] = 0;
          continue;
        }

        dp[i][j] += dp[i-1][j];
        if(j-nums[i-1]>=0)
          dp[i][j] += dp[i][j-nums[i-1]];
      }
    }
    for(int i =0; i<=nums.length; i++)
      System.out.println(Arrays.toString(dp[i]));

    return dp[nums.length][target];
  }

  public static void main(String[] args) {
    System.out.println(combinationSum4(new int[]{1,2}, 3));
  }

}
