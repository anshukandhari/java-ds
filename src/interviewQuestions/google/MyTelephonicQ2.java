package interviewQuestions.google;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Given a text find the shortest substring containing the alphabet in order as subsequence
 */
public class MyTelephonicQ2 {
    public String shortestSubstringWithAllCharsInOrder(String str){
        HashMap<Character, ArrayList<Integer>> hm = new HashMap<>();

        //Find first complete sequence
        int s = 0, e = 0, val, cur = -1;
        String ans = str;
        ArrayList<Integer> al;
        char schar, echar;

        while(e < str.length()){
            val = str.charAt(e) - 'a';

            if(val <0 || val > 25){
                e++;
                continue;
            }
            echar = str.charAt(e);


            if(val>=0 && val <= cur+1){
                if(val == cur+1) {
                    cur++;
                }

                al = hm.getOrDefault(echar, new ArrayList<Integer>());
                al.add(e);
                hm.put(echar, al);
            }



            if(cur == 25){
                s = hm.get('a').get(0);
                if(e-s+1 < ans.length())
                    ans = str.substring(s,e+1);

                cur = -1;

                if(hm.get('a').size() <2){
                    s = e;
                    hm.clear();
                    e++;
                    continue;
                } else {
                    hm.get('a').remove(0);
                    s = hm.get('a').get(0);
                    cur++;
                }




                cur = -1;
                val = str.charAt(s)-'a';
                if(val >=0 && val  <= cur+1){
                    schar = str.charAt(s);
                    if(val == cur+1){
                       cur++;

                    }
                    al = hm.get(schar);
                    al.remove(s);
                    hm.put(schar, al);
                }

                s++;

            }

            e++;
        }

        return "";
    }

}
