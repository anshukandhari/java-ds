package disjointSets.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class isBipartite {
  public static boolean isBipartite(int[][] graph) {
    if(graph.length == 0){
      return true;
    }

    int color[]= new int[graph.length];

    Arrays.fill(color, -1);

    Queue<Integer> q = new LinkedList<>();
    q.offer(0);
    color[0] = 1;

    int u;
    while(!q.isEmpty()){
      u = q.poll();
      for(int v = 0; v<graph.length; v++){
        if(graph[u][v] == 0){
          continue;
        }

        if(color[v] == -1){
          color[v] = 1-color[u];
          q.offer(v);
        } else if(color[v] == color[u]){
          return false;
        }
      }
    }

    return true;

  }

  public static void main(String[] args) {
    int G[][] = {
        {0, 1, 0, 1},
        {1, 0, 1, 0},
        {0, 1, 0, 1},
        {1, 0, 1, 0}
    };
    System.out.println(isBipartite(G));
    System.out.println(isBipartiteDFS(G));
  }


  public static boolean isBipartiteDFS(int[][] graph) {
    int color[]  = new int[graph.length];
    Arrays.fill(color, -1);
    color[0] = 1;
    for(int i = 0; i<graph.length;i++){
      if(!isBipartiteDFSUtil(graph,i,color)) {
        return false;
      }
    }
    return true;
  }

  public static boolean isBipartiteDFSUtil(int[][] graph, int v, int color[]) {

    for(int i =0;i<graph.length;i++){
      if(graph[v][i]>0){
        if(color[i] == -1){
          color[i] = 1-color[v];
          if(!isBipartiteDFSUtil(graph, i, color)){
            return  false;
          }
        } else if(color[i] == color[v]){
            return false;
          }
      }
    }
    return true;

  }
}
