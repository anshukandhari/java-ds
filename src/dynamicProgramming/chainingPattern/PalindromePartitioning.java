package dynamicProgramming.chainingPattern;

import java.util.Arrays;

public class PalindromePartitioning {

  int dp[][];

  private  int palindromePartitioningMemo(String s, int i, int j) {
    if(dp == null){
      dp = new int[s.length()][s.length()];
      for (int x = 0; x<s.length(); x++)
        Arrays.fill(dp[x],s.length());
    }

    if(dp[i][j]<s.length()){
      return dp[i][j];
    }


    if(isPalindrome(s.substring(i, j+1))){
      dp[i][j] = 0;
      return dp[i][j];
    }

    int min = s.length();
    for(int k = i; k < j; k++){
      min = Math.min(1+ palindromePartitioningMemo(s,i,k)+ palindromePartitioningMemo(s,k+1,j), min);
    }
    dp[i][j] = min;
    return dp[i][j];
  }


  private  int palindromePartitioningRecur(String s, int i, int j) {
    if(isPalindrome(s.substring(i, j+1))){
      return 0;
    }

    int min = s.length();
    for(int k = i; k < j; k++){
      min = Math.min(1+ palindromePartitioningRecur(s,i,k)+ palindromePartitioningRecur(s,k+1,j), min);
    }
    return min;
  }


  boolean isPalindrome(String s){
    if(s.length() <2){
      return true;
    }
    int i = 0, j = s.length()-1;
    while(i<j){
      if(s.charAt(i) == s.charAt(j)){
        i++;
        j--;
      } else {
        break;
      }
    }

    return !(i<j);
  }

  public static void main(String[] args) {
//    System.out.println(palindromePartitioning("ababcb".toCharArray()));
    String s = "ababbbabbababa";
    PalindromePartitioning pp = new PalindromePartitioning();
    System.out.println(pp.palindromePartitioningRecur(s, 0, s.length()-1));
    System.out.println(pp.palindromePartitioningMemo(s, 0, s.length()-1));
  }





}
