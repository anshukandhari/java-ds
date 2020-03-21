package dynamicProgramming.chainingPattern;

import java.util.Arrays;

public class LongestPalindromeSubstring {
  public static String longestPalindrome2(String s) {
    if(s.length() <= 1){
      return s;
    }

    int l = s.length();
    int m[][] = new int[l][l];

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
        j = i + chain - 1;
        if(s.charAt(i) == s.charAt(j)){
          if( j == i+1){
            m[i][j] = 2;
          } else {
            if(m[i+1][j-1]>0){
              m[i][j] = m[i+1][j-1]+2;
            }
          }
        }
      }
    }

    for(int i = 0; i < l ; i++){
      System.out.println(Arrays.toString(m[i]));
    }

    int max = 0, idx = 0;

    for(int i = 0; i < l ; i++){
      if(m[0][i] > max){
        max = m[0][i];
        idx = i;
      }
    }

    if(idx == 0){
      return Character.toString(s.charAt(idx));
    }

    return s.substring(idx-max+1, max);

  }

  public static String longestPalindrome(String s) {
    int l = s.length();
    if(l <=1 ){
      return s;
    }

    int m[][] = new int[l][l];

    for(int i =0; i<l; i++){
      for(int j = i;j<l;j++){
        if(i==j){
          m[i][j] =1;
        }
      }
    }


    for(int chain = 1; chain <l; chain++){
      for(int i =0; i<l && i+chain<l; i++){
        int j = i+chain;
        if(s.charAt(i) == s.charAt(j)){
          m[i][j] = m[i+1][j-1] + 2;
        } else {
          m[i][j] =m[i+1][j-1];
        }
      }
    }


    int max = 0, start =-1, end =-1;
    for(int i =0; i<l; i++){
      for(int j = i;j<l;j++){
        if(m[i][j]> max){
          max = m[i][j];
          start = i;
          end = j;
        }
      }
    }

    if(start >=0){
      return s.substring(start,end+1);
    }

    return "";

  }

  public static void main(String[] args) {
    String s = "babad";
    System.out.println(longestPalindrome(s));
    LongestPalindromeSubstring lps = new LongestPalindromeSubstring();
    lps.longestPalindrome3(s);
    System.out.println(lps.ans);
  }


  String ans = "";
  public String longestPalindrome3(String s) {
    if(s.length()< 2)
      return s;

    longestPalindromeUtil(s,0, s.length()-1);
    return ans;
  }

  public void longestPalindromeUtil(String s, int start, int end) {
    if(start > end)
      return;

    int st = start, e = end;
    while(st < e && s.charAt(st) == s.charAt(e)){
      st++;
      e--;
    }

    if(st >= e && ans.length() < end-start+1){
      ans = s.substring(start, end+1);
    }

    longestPalindromeUtil(s, start+1, end);
    longestPalindromeUtil(s, start, end-1);

  }
}
