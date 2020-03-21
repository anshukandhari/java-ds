package disjointSets;

import java.util.HashMap;

public class DisjointSet {

  private HashMap<Long, Node> map = new HashMap<>();

  class Node{
    int rank;
    Node parent;
    long data;
  }

  /**
   * Create a set with only one element.
   * Complexity : O(1)
   */
  public void makeSet(long data) {
    Node node = new Node();
    node.rank = 0;
    node.data = data;
    node.parent = node;
    map.put(data,node);
  }


  /**
   * Combines two sets together to one.
   * Does union by rank
   * Complexity : O(1)
   * @return true if data1 and data2 are in different set before union else false.
   */
  public boolean union(long data1, long data2) {
    Node p1 = map.get(findSet(data1));
    Node p2 = map.get(findSet(data2));

    if(p1.data == p2.data){
      return false;
    }

    if(p1.rank >= p2.rank){
      if(p1.rank == p2.rank){
        p1.rank += 1;
      }
      p2.parent = p1;
    } else {
      p1.parent = p2;
    }


    return true;
  }

  /**
   * Complexity : O(1)
   * */
  public long findSet(long data) {
    return findSet(map.get(data)).data;
  }

  /**
   *
   * This does the path compression if required only
   *
   */
  public Node findSet(Node node) {
    if(node.parent == node){
      return node;
    }
    node.parent = findSet(node.parent);
    return node.parent;
  }



  public static void main(String args[]) {
    DisjointSet ds = new DisjointSet();
    ds.makeSet(1);
    ds.makeSet(2);
    ds.makeSet(3);
    ds.makeSet(4);
    ds.makeSet(5);
    ds.makeSet(6);
    ds.makeSet(7);

    ds.union(1, 2);
    ds.union(2, 3);
    ds.union(4, 5);
    ds.union(6, 7);
    ds.union(5, 6);
    ds.union(3, 7);

    System.out.println(ds.findSet(1));
    System.out.println(ds.findSet(2));
    System.out.println(ds.findSet(3));
    System.out.println(ds.findSet(4));
    System.out.println(ds.findSet(5));
    System.out.println(ds.findSet(6));
    System.out.println(ds.findSet(7));
  }


}
