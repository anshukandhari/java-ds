package graphs.mst;

import disjointSets.DisjointSet;
import graphs.core.Edge;
import graphs.core.GraphViaEdges;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KruskalAlgo {
  public List<Edge> getMST(GraphViaEdges graph){
    DisjointSet disjointSet = new DisjointSet();
    List<Edge> sol = new ArrayList<>();

    Arrays.sort(graph.edges);

    for(int i = 0; i< graph.V; i++){
      disjointSet.makeSet(i);
    }

    Edge t;
    for(int i = 0; i< graph.edges.length; i++){
      t = graph.edges[i];
      if(disjointSet.union(t.getFrom(), t.getTo())){
        sol.add(t);
      }
    }
    return  sol;
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
    GraphViaEdges g = new GraphViaEdges(4, 5);
    g.addEdge(0,1, 10);
    g.addEdge(0,2, 6);
    g.addEdge(0,3, 5);
    g.addEdge(2,3, 4);
    g.addEdge(3,1, 15);

    KruskalAlgo ka = new KruskalAlgo();
    List<Edge> sol = ka.getMST(g);
    sol.forEach(v -> System.out.println("From:"+v.getFrom()+" To:"+v.getTo()+" Weight:"+v.getWeight()));

  }

}



