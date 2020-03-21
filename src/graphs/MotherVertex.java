package graphs;

import graphs.core.Graph;
import graphs.traversal.GraphTraversal;
import java.util.Arrays;

public class MotherVertex {
  public static int motherVertex(Graph g){
    boolean visited[] = new boolean[g.adjListArray.length];
    int v = -1;

    for(int i=0; i<g.adjListArray.length; i++){
      if(!visited[i]){
        g.dfsUtil(g,i,visited);
        v =i;
      }
    }

    Arrays.fill(visited,false);

    g.dfsUtil(g,v,visited);

    for(int i=0; i<g.adjListArray.length; i++){
      if(!visited[i])
        return -1;
    }

    return v;

  }

  public static void main(String[] args) {
    GraphTraversal gt = new GraphTraversal();
    Graph g = new Graph(7);
    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(1, 3);
    g.addEdge(4, 1);
    g.addEdge(6, 4);
    g.addEdge(5, 6);
    g.addEdge(5, 2);
    g.addEdge(6, 0);
    System.out.println(motherVertex(g));
  }
}
