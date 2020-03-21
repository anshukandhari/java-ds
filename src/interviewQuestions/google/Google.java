package interviewQuestions.google;

import java.util.ArrayList;
import java.util.HashMap;

public class Google {
  int[] hasAllAlphabets(String s){
    if(s.length()<25){
      return new int[]{-1,-1};
    }

    int st = 0, e = 0, cs = 0, t, min = s.length()+1;
    HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();

    ArrayList<Integer> temp;

    for(int ce = 0; ce< s.length(); ce++){
      t = s.charAt(ce)-'a';
      if(t == 0 || hm.containsKey(t - 1)){
        if(hm.containsKey(t)){
          temp = hm.get(t);
          temp.add(ce);
          hm.put(t, temp);
        } else {
          temp = new ArrayList();
          temp.add(ce);
          hm.put(t, temp);
        }
      }

      // Check if we have all the characters
      if(hm.containsKey(25) && hm.size() == 26){
        temp = hm.get(0);
        cs = temp.get(0);


        if(min > cs-ce+1){
          min = ce-cs+1;
          st = cs;
          e = ce;
        }
      }

      // moving start of the window
      while(cs < ce && (s.charAt(cs) != 'a' || hm.size()== 26)){
        temp = hm.get(cs);
        if(temp.size() == 1){
          hm.remove(0);
        } else {
          temp.remove(0);
          hm.put(s.charAt(cs)-'a', temp);
        }
        cs++;
      }
    }

    if(min< s.length()+1){
      return new int[]{st,e};
    }

    return new int[]{-1,-1};
  }

  public static void main(String[] args) {
    Google g = new Google();
    g.hasAllAlphabets("aabcbcdbcaefghijklmnopqrstuvwxyasefevruitlkzabcdefghijklmnopqrstuvwxyz");
  }

}
