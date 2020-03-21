package dynamicProgramming.chainingPattern;


public class LongestPalindromicSubsequence {
  int lps(String s){
    int l = s.length();
    int m[][]= new int[l][l];

    for(int i = 0; i < l ; i++){
      for(int j = 0; j < l ; j++){
        if(i == j){
          m[i][j] = 1;
        }
      }
    }

    int j;
    for(int chain = 2; chain <= l; chain++){
      for(int i = 0; i<= l-chain; i++){
        j = i+chain-1;

        if(s.charAt(i) == s.charAt(j)){
          if(j == i+1){
            m[i][j] = 2;
          } else{
            m[i][j] = m[i+1][j-1] + 2;
          }
        } else {
          m[i][j] = Math.max(m[i][j-1], m[i+1][j]);
        }
      }
    }
    return m[0][l-1];
  }

  public static void main(String[] args) {
    LongestPalindromicSubsequence lpsq = new LongestPalindromicSubsequence();
    String seq = "GEEKSFORGEEKS";
    System.out.println("The length of the lps is "+ lpsq.lps(seq));
    System.out.println("The length of the lps is "+ lpsq.lps2(seq, 0, seq.length()-1));
  }


  int dp[][];

  int lps2(String s, int i , int j) {
    if(s.length() == 0)
      return  0;

    if(dp == null){
      dp = new int[s.length()][s.length()];
    }

    if(i == j){
      dp[i][j] = 1;
      return dp[i][j];
    }

    if(i>j){
      dp[i][j] = 0;
      return dp[i][j];
    }

    if(s.charAt(i) == s.charAt(j)){
      dp[i][j] = 2 + lps2(s,i+1,j-1);
      return dp[i][j];
    }


    dp[i][j] = Math.max(lps2(s,i+1,j), lps2(s,i,j-1));
    return dp[i][j];
  }
}
