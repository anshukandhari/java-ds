package strings.slidingWindow;

import java.util.HashMap;

public class lc159 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s.length() <3)
            return s.length();

        HashMap<Character, Integer> hm = new HashMap();
        int count = 0, begin = 0, end = 0, ans = 0;
        char beginChar, endChar;

        while(end<s.length()){
            endChar = s.charAt(end);
            hm.put(endChar, hm.getOrDefault(endChar, 0) +1);
            if(hm.get(endChar) == 1)
                count++;

            while(count > 2){
                beginChar = s.charAt(begin);
                hm.put(beginChar, hm.get(beginChar)-1);
                if(hm.get(beginChar) == 0)
                    count--;
                begin++;
            }

            ans = Math.max(ans, end-begin+1);
            end++;
        }

        return ans;
    }
}
