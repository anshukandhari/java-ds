package strings.slidingWindow;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharactersLC3 {
  public static int lengthOfLongestSubstring(String s) {
    int ans = 0;
    if(s.length() < 2)
      return s.length();

    HashMap<Character, Integer> hm = new HashMap<>();
    int start = 0, end = 0;

    while(end<s.length()){
      char c = s.charAt(end);
      if(!hm.containsKey(c) || (hm.containsKey(c) && hm.get(c) == 0)){
        hm.put(c, 1);
        end++;
      } else {
        while(start<end && s.charAt(start) != c){
          hm.put(s.charAt(start), hm.get(s.charAt(start))-1);
          start++;
        }
        hm.put(s.charAt(start), hm.get(s.charAt(start))-1);
        start++;
      }
      ans = Math.max(end-start+1, ans);
    }

    return ans;
  }

  public static void main(String[] args) {
    lengthOfLongestSubstring("abba");
  }

}
