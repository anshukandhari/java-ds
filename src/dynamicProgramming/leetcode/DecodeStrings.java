package dynamicProgramming.leetcode;

import java.util.ArrayList;
import java.util.List;

public class DecodeStrings {
  /**
   * Leetcode Problem 91
   * Give sequence of numbers like "223" we need to find all the possible sequence of characters following these number sequence
   * Example for 223 the output would be ["BBC", "BW","VC"] since it could be broken to ["2,2,3", "2,23", "22,3"]
   *
   */

  public int createLetterCombinationFromNumSeqBackTracking(String s){
    if(s.length() == 0){
      return 0;
    }

    if(s.length() == 1){
      if(s.charAt(0) == 0){
        return 0;
      }
      char c = (char)('a'+s.charAt(0)-1);
      System.out.println(c);
      return 1;
    }

    int a[] = new int[s.length()];

    for(int i=0; i<s.length();i++){
      a[i] = s.charAt(i)-'0';
      if(s.charAt(i) == '0' && (s.charAt(i-1)<'1' || s.charAt(i-1)>'2')){
        return 0;
      }
    }

    List<String> sol = new ArrayList<>();
    createLetterCombinationFromNumSeqUtil(a,0,"", sol);
    sol.forEach(str-> System.out.println(str));
    return sol.size();
  }

  private void createLetterCombinationFromNumSeqUtil(int a[], int idx, String curr, List<String> sol){
    if(idx == a.length){
      sol.add(new String(curr));
      return;
    }

    if(a[idx] > 0) {
      char c = (char) ('a'-1+a[idx]);
      createLetterCombinationFromNumSeqUtil(a, idx + 1, curr + c, sol);
    }

    if(idx+1 < a.length && a[idx] !=0 && a[idx]*10+a[idx+1]<27 && a[idx]*10+a[idx+1] >0){
      char c = (char)('a'-1+ (a[idx]*10+a[idx+1]));
      createLetterCombinationFromNumSeqUtil(a,idx+2, curr+ c,sol);
    }
  }

  public int numDecodings(String s) {
    if(s.length() == 0){
      return 0;
    }

    int dp[] = new int[s.length()+1];

    dp[0] = 1;
    dp[1] = s.charAt(0) == 0?0:1;
    if(dp[1] == 0){
      return 0;
    }

    int lastTwoChars, lastChar;
    for(int i = 2; i<=s.length(); i++){
      if(s.charAt(i-1) == '0'){
        if(s.charAt(i-2)>'0' && s.charAt(i-2)<'3'){
          dp[i] = dp[i-1]-1;
        } else {
          return 0;
        }
      } else {
        dp[i] += dp[i-1];
        lastTwoChars = Integer.valueOf(s.substring(i-2,i));
        if(lastTwoChars > 9 && lastTwoChars<27){
          dp[i] += dp[i-2];
        }
      }
    }
    return dp[s.length()];
  }



  public static void main(String[] args) {
    DecodeStrings ds = new DecodeStrings();
    int ans;
    ans = ds.createLetterCombinationFromNumSeqBackTracking("1226");
    System.out.println(ans);
    ds.numDecodings("1226");
//    ans = ds.createLetterCombinationFromNumSeq("12264");
//    System.out.println(ans);

  }

}
//127229
