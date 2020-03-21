package strings.leetcode;

import java.util.HashMap;

public class LongestRepeatingCharacterReplacement {

  public static int characterReplacement(String s, int k) {
    if(s.length() == 0){
      return 0;
    }

    HashMap<Character, Integer> hm = new HashMap<>();
    int st = 0, max = 0, count = 0, maxRepeatition = 0;
    char ch, stch;

    for(int e = 0; e < s.length(); e++){
      ch = s.charAt(e);
      if(!hm.containsKey(ch) || hm.get(ch) ==0){
        hm.put(ch,1);
        maxRepeatition = Math.max(maxRepeatition,1);
      } else {
        hm.put(ch, hm.get(ch)+1);
        maxRepeatition = Math.max(maxRepeatition,hm.get(ch)+1);
      }

      count = e-st+1-maxRepeatition;
      if(count > k){
        stch = s.charAt(st);
        if(hm.get(stch) == maxRepeatition)
          maxRepeatition--;
        hm.put(stch, hm.get(stch)-1);
        count--;
        st++;
      }

      if(count <= k){
        max = Math.max(e-st+1, max);
      }

    }


    return max;

  }

  public static void main(String[] args) {
    characterReplacement("AABABBA",1);
  }

}
