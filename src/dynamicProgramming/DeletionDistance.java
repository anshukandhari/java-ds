package dynamicProgramming;

import java.util.Arrays;

public class DeletionDistance {
  static int deletionDistance(String s1, String s2) {
    // your code goes here
    //return deletionDistanceRecur(s1,s2,0,0);
    return deletionDistanceDP2(s1,s2);

  }


  static int deletionDistanceDP2(String s1, String s2) {
    if(s1.length() == 0){
      return s2.length();
    }

    if(s2.length() == 0){
      return s1.length();
    }

    int lastVal = 0, temp = 0;
    int a[] = new int[s2.length()+1];

    for(int i =0; i <= s1.length(); i++){
      for(int j =0; j <= s2.length(); j++){
        if(i == 0){
          lastVal = a[j];
          a[j] = j;
          continue;
        }
        if(j == 0){
          lastVal = a[j];
          a[j] = i;
          continue;
        }

        if(s1.charAt(i-1) == s2.charAt(j-1)){
          temp = a[j];
          a[j] = lastVal;
          lastVal = temp;
        } else {
          lastVal = a[j];
          a[j] = Math.min(a[j], a[j-1]) + 1;
        }
      }
      System.out.println(Arrays.toString(a));
    }


    return a[s2.length()];

  }

  static int deletionDistanceDP(String s1, String s2) {
    if(s1.length() == 0){
      return s2.length();
    }

    if(s2.length() == 0){
      return s1.length();
    }

    int m[][] = new int[s1.length()+1][s2.length()+1];

    for(int i =0; i <= s1.length(); i++){
      for(int j =0; j <= s2.length(); j++){
        if(i == 0){
          m[i][j] = j;
          continue;
        }
        if(j == 0){
          m[i][j] = i;
          continue;
        }

        if(s1.charAt(i-1) == s2.charAt(j-1)){
          m[i][j] = m[i-1][j-1];
        } else {
          m[i][j] = Math.min(m[i-1][j], m[i][j-1]) + 1;
        }
      }
    }

    for(int i =0; i <= s1.length(); i++){
      System.out.println(Arrays.toString(m[i]));
    }


    return m[s1.length()][s2.length()];
  }


  static int deletionDistanceRecur(String s1, String s2, int idx1, int idx2) {
    if(idx1 == s1.length()){
      return s2.length()-idx2;
    }
    if(idx2 == s2.length()){
      return s1.length()-idx1;
    }

    if(s1.charAt(idx1) == s2.charAt(idx2)){
      return deletionDistanceRecur(s1, s2, idx1+1, idx2+1);
    }

    return 1+ Math.min(
        deletionDistanceRecur(s1, s2, idx1+1, idx2), deletionDistanceRecur(s1, s2, idx1, idx2+1));

  }



  public static void main(String[] args) {
    System.out.println(deletionDistance("dog", "frog"));
  }

}
