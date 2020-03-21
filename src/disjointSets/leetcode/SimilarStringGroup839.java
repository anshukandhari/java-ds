package disjointSets.leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class SimilarStringGroup839 {
  HashMap<String, Node> hm = new HashMap<>();

  public int numSimilarGroups(String[] A) {
    if(A.length <2){
      return A.length;
    }

    int dist;

    for(int i = 0; i< A.length; i++){
      makeSet(A[i]);
    }

    for(int i = 0; i< A.length-1; i++){
      for(int j = i+1; j< A.length; j++){
        dist = findDistance(A[i], A[j]);
        if(dist == 2){
          union(A[i], A[j]);
        }
      }
    }

    HashSet<String> hs = new HashSet<>();
    for(int i = 0; i< A.length; i++){
      hs.add(findSet(A[i]));
    }

    return hs.size();
  }

  int findDistance(String a, String b){
    int res = 0;
    for(int i =0; i< a.length(); i++){
      if(a.charAt(i) != b.charAt(i))
        res++;
    }

    return res;
  }

  void makeSet(String a){
    hm.put(a, new Node(a));
  }

  boolean union(String a, String b){
    Node na = findSet(hm.get(a));
    Node nb = findSet(hm.get(b));

    if(na == nb){
      return false;
    }

    if(na.rank >= nb.rank){
      if(na.rank == nb.rank){
        na.rank+=1;

      }
      nb.parent = na;
    } else {
      na.parent = nb;
    }

    return true;
  }

  String findSet(String str){
    Node n = findSet(hm.get(str));
    return n.data;
  }

  Node findSet(Node n){
    if(n.parent == null){
      return n;
    }
    n.parent = findSet(n.parent);
    return n.parent;
  }

  class Node{
    String data;
    Node parent;
    int rank;
    public Node(String str){
      parent = null;
      rank = 0;
      data = str;
    }
  }

  public static void main(String[] args) {
    SimilarStringGroup839 lc = new SimilarStringGroup839();
    lc.numSimilarGroups(new String[]{"omv","ovm"});
  }

}
