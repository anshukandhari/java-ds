package strings.patternMatching;

import java.util.ArrayList;
import java.util.Arrays;

public class KMP {

  public ArrayList<Integer> KMPMatch(String s, String p){
    int pre[] = preprocessor(p);
    ArrayList<Integer> sol = new ArrayList<>();

    int j =0;
    for(int i=0; i<s.length();){

      if(s.charAt(i) == p.charAt(j)){
        i++;
        j++;
        if(j == p.length()){
          sol.add(i-p.length());
          j = 0;
        }
      } else {
        if(j>0){
          j = pre[j-1];
        } else {
          i++;
        }
      }

    }

    return sol;
  }

  private int[] preprocessor(String p){
    int sol[] = new int[p.length()];
    sol[0] = 0;

    int j =0, i = 1;
    while(i<p.length()){
      if(p.charAt(i) == p.charAt(j)){
        j++;
        sol[i] = j;
        i++;
      } else {
        if( j == 0){
          sol[i] = j;
          i++;
        } else {
          j = sol[j-1];
        }
      }
    }
    return sol;

  }

  public static void main(String[] args) {
    KMP kmp = new KMP();
    System.out.println(kmp.KMPMatch("abxababxab", "abxab"));
    System.out.println(kmp.KMPMatch("ABABDABACDABABCABAB", "ABABCABAB"));
//    System.out.println(Arrays.toString(kmp.preprocessor("AAACAAAA")));
  }


}
