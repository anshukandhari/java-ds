package strings.slidingWindow;

import java.util.HashMap;

public class MinWindow {

  public static String minWindow(String s, String t) {

    if(s.length() == 0 || t.length() == 0){
      return "";
    }

    HashMap<Character, Integer> hm = new HashMap<>();
    int count, begin = 0, end = 0, min = Integer.MAX_VALUE;
    String ans ="";

    for(char c : t.toCharArray()){
      if(!hm.containsKey(c)){
        hm.put(c,-1);
      } else {
        hm.put(c,hm.get(c)-1);
      }
    }

    count = hm.size();

    char c;

    while(end < s.length()){
      c = s.charAt(end);
      if(hm.containsKey(c)){
        hm.put(c,hm.get(c)+1);
        if(hm.get(c) == 0){
          count--;
        }
      }



      while(count == 0){

        if(end - begin + 1 < min ){
          ans = s.substring(begin, end+1);
          min = end-begin+1;
        }

        if(hm.containsKey(s.charAt(begin))){
          hm.put(s.charAt(begin), hm.get(s.charAt(begin))-1);
          if(hm.get(s.charAt(begin)) <0){
            count++;
          }
        }

        begin++;
      }

      end++;

    }

    return ans;

  }

}
