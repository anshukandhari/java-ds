package strings.leetcode;

import java.util.HashMap;

public class LengthOfLongestSubstringKDistinct {

  public static int lengthOfLongestSubstringKDistinct(String s, int k) {
    // write your code here
    if(s.length() == 0 || k == 0){
      return 0;
    }


    HashMap<Character, Integer> hm = new HashMap<>();
    int st = 0, max = 0, count = 0;
    char ch, stch;

    for(int e = 0; e < s.length(); e++){
      ch = s.charAt(e);
      if(!hm.containsKey(ch) || hm.get(ch) ==0){
        hm.put(ch,1);
        count++;
      } else {
        hm.put(ch, hm.get(ch)+1);
      }

      while(count > k){

        stch = s.charAt(st);
        hm.put(stch, hm.get(stch)-1);
        if(hm.get(stch)  == 0){
          count--;
        }
        st++;
      }

      if(count <= k){
        max = Math.max(e-st+1, max);
      }

    }


    return max;


  }

  public static void main(String[] args) {
    System.out.println(lengthOfLongestSubstringKDistinct("kb", 3));
  }

}
