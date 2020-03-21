package backtracking.typeB;


import java.util.HashMap;
import java.util.Map;
import trie.Trie;

// https://leetcode.com/discuss/interview-question/338192/Facebook-or-Onsite-or-Word-Break-and-Working-and-MultiTasking-Intervals
public class FBInterviewQuesiton {
  TrieNode root = new TrieNode();

  class TrieNode{
    TrieNode child[];
    boolean isEnd;
    int count;
    public TrieNode(){
      child = new TrieNode[26];
      isEnd = false;
      count = 0;
    }
  }

  void insert(String t, int count) {
    TrieNode p = root;
    for(char c : t.toCharArray()){
      if(p.child[c-'a'] == null){
        p.child[c-'a'] = new TrieNode();
      }
      p = p.child[c-'a'];
    }

    p.count = count;
    p.isEnd = true;

  }

  boolean wordBreak(String t, HashMap<String, Integer> hm) {
    hm.forEach((k, v) -> {
      insert(k, v);
    });

    return wordBreakUtil(t);
  }





  boolean wordBreakUtil(String t){
    if(t.length() == 0){
      return true;
    }

    TrieNode p = root;
    for(int i = 0; i<t.length(); i++){
      char c = t.charAt(i);
      if(p.child[c-'a'] == null){
        return false;
      }

      p = p.child[c-'a'];
      if(p.isEnd && p.count>0){
        p.count--;
        if(!wordBreakUtil(t.substring(i+1))){
          p.count++;
        } else {
          return true;
        }
      }
    }
    return false;

  }



  public static void main(String[] args) {
    FBInterviewQuesiton fb = new FBInterviewQuesiton();
    HashMap<String,Integer> hm = new HashMap<>();
    hm.put("abc", 3);
    hm.put("ab", 2);
    hm.put("abca", 1);
    System.out.println(fb.wordBreak("ababcab", hm));
    System.out.println(fb.wordBreak2("ababcab", hm));
  }


  public static boolean wordBreak2(String s, Map<String, Integer> dict) {
    return canBreak(s, dict, 0);
  }

  public static boolean canBreak(String s, Map<String, Integer> dict, int start) {

    if (start == s.length()) return true;

    for (int i = start; i < s.length(); i++) {

      String word = s.substring(start, i + 1);
      if (dict.containsKey(word) && dict.get(word) > 0) { // Can be broken down into a word and we have remaining words left for it --> recurse with next starting point
        dict.put(word, dict.get(word) - 1); // Remove a count of this word; choose to break this word here

        if (canBreak(s, dict, i + 1))
          return true; // Test rest of the string after this word i.e. backtracking/recurse

        dict.put(word, dict.get(word) + 1); // Unchoose to break this word here; put the count back for this word
      }
    }

    return false;
  }

}
