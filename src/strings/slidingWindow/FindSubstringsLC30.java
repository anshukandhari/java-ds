package strings.slidingWindow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class FindSubstringsLC30 {
  public List<Integer> findSubstring(String s, String[] w) {
    List<Integer> sol = new ArrayList<>();

    if(s.length() == 0 || w.length == 0 || s.length() < w[0].length()){
      return sol;
    }

    HashMap<String, Integer> hm = new HashMap<>();
    HashMap<String, Integer> hm2 = new HashMap<>();

    int wl = w[0].length(), tl = w[0].length()*w.length, count, begin, end;

    for(String str : w){
      if(!hm.containsKey(str)){
        hm.put(str,-1);
      } else {
        hm.put(str,hm.get(str)-1);
      }
    }


    String word, nword;
    for(int i=0; i<wl; i++){
      hm.forEach((k,v)->{
        hm2.put(k,v);
      });

      end = i;
      begin = i;
      count = hm2.size();

      while(end+wl <= s.length()){


        word = s.substring(end, end+wl);

        if(hm2.containsKey(word)){
          hm2.put(word, hm2.get(word)+1);

          if(hm2.get(word) == 0){
            count--;
          }
        }



        while(count == 0 && begin + wl <= s.length()){

          if(end-begin+1 == tl){
            sol.add(begin);
          }

          nword = s.substring(begin,begin+wl);

          if(hm2.containsKey(nword)){
            hm2.put(nword, hm2.get(nword)-1);
            if(hm2.get(nword) < 0){
              count++;
            }
          }

          begin+= wl;

        }

        end+= wl;

      }
    }


    Collections.sort(sol);

    return sol;

  }

  public static void main(String[] args) {
    FindSubstringsLC30 lc = new FindSubstringsLC30();
    String s[] = {"foo","bar"};
    lc.findSubstring("barfoothefoobarman",s);
  }


}
