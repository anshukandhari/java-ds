package strings;

import java.util.HashMap;

public class MinWindow {

  public static String minWindow(String s, String t) {
    if(s == "" || t == ""){
      return "";
    }

    HashMap<Character, Integer> sm = new HashMap<>();
    HashMap<Character, Integer> tm = new HashMap<>();
    int count = t.length();
    int i =-1, j = 0, min = Integer.MAX_VALUE, end;

    for(char tc : t.toCharArray()){
      if(!tm.containsKey(tc)){
        tm.put(tc,1);
        sm.put(tc,0);
      } else {
        tm.put(tc,tm.get(tc)+1);
      }
    }


    char c;
    while(j<s.length() && count >0){
      c = s.charAt(j);

      if(tm.containsKey(c)){
        if(tm.get(c)>0){
          tm.put(c, tm.get(c)-1);
          count--;
          if(i == -1){
            i = j;
          }
        } else {
          sm.put(c,sm.get(c)+1);
        }
      }
      j++;
    }
    j--;

    if(count > 0){
      return "";
    }


    //adjust start
    c = s.charAt(i);
    while(!sm.containsKey(c) || (sm.containsKey(c) && sm.get(c)>0)){
      if(sm.containsKey(s.charAt(i)))
        sm.put(c,sm.get(c)-1);

      i++;
      c = s.charAt(i);
    }

    min = j-i+1;
    end = j;
    j++;

    while(j<s.length()){
      c = s.charAt(j);
      if(sm.containsKey(c)){
        sm.put(c,sm.get(c)+1);

        if(c == s.charAt(i)){
          // Adjust Start
          while(!sm.containsKey(c) || (sm.containsKey(c) && sm.get(c)>0)){
            if(sm.containsKey(s.charAt(i)))
              sm.put(c,sm.get(c)-1);

            i++;
            c = s.charAt(i);
          }

          if(j-i+1 < min){
            min = j-i+1;
            end = j;
          }
        }
      }
      j++;
    }
    return s.substring(i,end);
  }

  public static void main(String[] args) {
    String s = "ABC", t = "ABC";
    System.out.println(minWindow(s,t));
  }

}
