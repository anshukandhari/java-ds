package disjointSets.leetcode;

import java.util.HashSet;

// Not working, create graph and use dfs/bfs
public class PossibleBiPartition {
  public static boolean possibleBipartition(int N, int[][] d) {
    HashSet<Integer> hsa = new HashSet<>();
    HashSet<Integer> hsb = new HashSet<>();

    int x, y;
    for(int i =0; i< d.length; i++){
      x = d[i][0];
      y = d[i][1];

      if(!hsa.contains(x) && !hsb.contains(x)){
        if(hsa.contains(y)){
          hsb.add(x);
        } else {
          hsb.add(y);
          hsa.add(x);
        }
      } else if((hsa.contains(x) && hsa.contains(y)) || (hsb.contains(x) && hsb.contains(y))){
        return false;
      } else if(hsa.contains(x) || hsb.contains(x)){
        if(hsa.contains(x)){
          hsb.add(y);
        } else {
          hsa.add(y);
        }
      }
    }

    return true;

  }


  public static void main(String[] args) {
    int d[][] = {{4,7},{4,8},{2,8},{8,9},{1,6},{5,8},{1,2},{6,7},{3,10},{8,10},{1,5},{7,10},{1,10},{3,5},{3,6},{1,4},{3,9},{2,3},{1,9},{7,9},{2,7},{6,8},{5,7},{3,4}};
    System.out.println(possibleBipartition(10,d));
  }

}
