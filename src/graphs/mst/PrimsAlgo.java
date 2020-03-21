package graphs.mst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * This approach gives us a good pointer that always mark visited when the vertex is dequed and not enqueued
 */
public class PrimsAlgo {
  public List<int []> getMST(int g[][]) {
    List<int []> sol = new ArrayList<>();
    PriorityQueue<int []> pq = new PriorityQueue<>((o1,o2)-> o1[2]- o2[2]);
    boolean visited[] = new boolean[g.length];
    int t[];

    // start with any random vertex and initialize q
    for(int i = 0; i< g.length; i++) {
      if(g[0][i]>0)
        pq.add(new int[]{0,i, g[0][i]});
    }
    visited[0] = true;

    while(pq.size()>0){
        t= pq.poll();
        if(!visited[t[1]]){
          sol.add(t);
        } else {
          continue;
        }

        visited[t[1]] = true;
        for(int i = 0; i< g.length; i++){
          if(!visited[i] && g[t[1]][i]>0){
            pq.add(new int[]{t[1],i,g[t[1]][i]});
          }
        }
    }

    return sol;

  }

  public static void main(String[] args) {
    /* Let us create following weighted graph
                10
            0-------1
            | \     |
           6|  5\   |15
            |     \ |
            2-------3
                4
      */
    PrimsAlgo t = new PrimsAlgo();
    int graph[][] = new int[][] {
        { 0, 10, 6, 5},
        { 10, 0, 0, 15},
        { 6, 0, 0, 4},
        { 5, 15, 4, 0}};

    // Print the solution
    List<int []> sol = t.getMST(graph);
    sol.forEach(o -> System.out.println(Arrays.toString(o)));
  }

}
