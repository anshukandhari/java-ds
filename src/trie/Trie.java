package trie;

public class Trie {
  TrieNode root;

  static class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEndOfWord;
  }



  void insert(String str){
    if(root == null){
      root = new TrieNode();
    }

    TrieNode pCrawl = root;

    for(char ch : str.toCharArray()){
      if(pCrawl.children[ch-'a'] == null){
        pCrawl.children[ch-'a'] = new TrieNode();
      }
      pCrawl = pCrawl.children[ch-'a'];
    }
    pCrawl.isEndOfWord = true;

  }


  boolean search(String str){
    TrieNode pCrawl = root;

    for(char ch : str.toCharArray()){
      if(pCrawl != null && pCrawl.children[ch-'a'] != null){
        pCrawl = pCrawl.children[ch-'a'];
      } else {
        return false;
      }
    }

    return (pCrawl != null && pCrawl.isEndOfWord);
  }

  public static void main(String[] args) {
    Trie t = new Trie();
    t.insert("anshu");
    t.insert("kandhari");

    System.out.println("Is present"+t.search("ansh"));
    System.out.println("Is present"+t.search("anshu"));
    System.out.println("Is present"+t.search("anshul"));
    System.out.println("Is present"+t.search("kandhari"));
  }
}


