package strings;

import java.util.ArrayList;
import java.util.List;

//  Palindromic Substrings LC 647
public class PalindromStrings {

  public List<String> getPalinfromicStrings(String s) {
    List<String> sol = new ArrayList<>();


    for(int i = 0; i<s.length();i++){
      getPalinfromicStringsUtil(s, i, i, sol);
      getPalinfromicStringsUtil(s, i, i+1, sol);
    }

    return sol;

  }

  void getPalinfromicStringsUtil(String s, int l, int r, List<String> sol ) {
    while(l>=0 && r<s.length()){
      if(s.charAt(l) == s.charAt(r)){
        sol.add(s.substring(l,r+1));
      } else {
        break;
      }
      l--;
      r++;

    }
  }

  public static void main(String[] args) {
    PalindromStrings ps = new PalindromStrings();
    System.out.println(ps.getPalinfromicStrings("0204451881"));
  }
}
