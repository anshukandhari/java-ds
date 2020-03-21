package graphs.mst;

import graphs.core.AdjacencyNode;
import graphs.core.Edge;
import graphs.core.GraphV2;
import java.util.HashSet;
import java.util.ListIterator;
import java.util.PriorityQueue;

// This is another way, not sure about complexity. I believe its O(2Elog(2E))

public class PrimsAlgoAdjacency {

  public void getMST(GraphV2 g) {
    HashSet<Integer> visited = new HashSet<>();
    PriorityQueue<Edge> pq = new PriorityQueue<>((o1,o2)->o1.getWeight()-o2.getWeight());

    // initialize
    int u = 0;
    ListIterator<AdjacencyNode> itr = g.adjListArray[u].listIterator();
    while(itr.hasNext()){
      AdjacencyNode curEdge = itr.next();
      if(!visited.contains(curEdge.getDest()))
        pq.add(new Edge(u,curEdge.getDest(), curEdge.getWeight()));
    }
    Edge selectedEdge;

    while(visited.size() < g.adjListArray.length){
      selectedEdge = pq.poll();
      if(visited.contains(selectedEdge.getTo()))
        continue;
      System.out.println(selectedEdge.getFrom() + "->"+ selectedEdge.getTo());
      visited.add(selectedEdge.getFrom());
      visited.add(selectedEdge.getTo());

      itr = g.adjListArray[selectedEdge.getTo()].listIterator();

      while(itr.hasNext()){
        AdjacencyNode curEdge = itr.next();
        if(!visited.contains(curEdge.getDest()))
          pq.add(new Edge(selectedEdge.getTo(),curEdge.getDest(), curEdge.getWeight()));
      }

    }
  }



  public static void main(String[] args){
    int V = 9;

    GraphV2 g = new GraphV2(V, false);
    g.addEdge(0, 1, 4);
    g.addEdge(0, 7, 8);
    g.addEdge(1, 2, 8);
    g.addEdge(1, 7, 11);
    g.addEdge(2, 3, 7);
    g.addEdge(2, 8, 2);
    g.addEdge(2, 5, 4);
    g.addEdge(3, 4, 9);
    g.addEdge(3, 5, 14);
    g.addEdge(4, 5, 10);
    g.addEdge(5, 6, 2);
    g.addEdge(6, 7, 1);
    g.addEdge(6, 8, 6);
    g.addEdge(7, 8, 7);

    // Method invoked
    PrimsAlgoAdjacency prims = new PrimsAlgoAdjacency();
    prims.getMST(g);

  }
}