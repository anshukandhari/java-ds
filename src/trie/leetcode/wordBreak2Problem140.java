package trie.leetcode;

import java.util.LinkedList;
import java.util.List;

public class wordBreak2Problem140 {
  TrieNode root = new TrieNode();

  public List<String> wordBreak(String s, String wordDict[]) {
    List<String> sol = new LinkedList<>();

    for(String word : wordDict)
      insertWord(word);

    wordBreakUtil(s,sol,"",0);
    return sol;
  }

  public void wordBreakUtil(String s, List<String> sol, String curr, int idx) {
    if(idx >= s.length()){
      sol.add(curr.substring(0,curr.length()-1));
      return;
    }

    TrieNode p = root;
    while(idx < s.length() && p.children[s.charAt(idx) - 'a'] != null){
      p = p.children[s.charAt(idx) - 'a'];
      curr += s.charAt(idx);
      idx++;

      if(p.isEnd){
        wordBreakUtil(s,sol,curr + " ",idx);
      }
    }
  }

  private void insertWord(String word){
    TrieNode p = root;
    char ca[] = word.toCharArray();

    for(char c : ca){
      if(p.children[c-'a'] == null){
        p.children[c-'a']= new TrieNode();
      }
      p = p.children[c-'a'];
    }
    p.isEnd = true;
  }

  public static void main(String[] args) {
    wordBreak2Problem140 lc = new wordBreak2Problem140();
    List<String> sol = lc.wordBreak("catsanddog", new String[]{"cat", "cats", "and", "sand", "dog"});
    sol.forEach(s -> System.out.println(s));
  }

}



class TrieNode{
  boolean isEnd;
  TrieNode children[];

  public TrieNode(){
    isEnd = false;
    children = new TrieNode[26];
  }
}