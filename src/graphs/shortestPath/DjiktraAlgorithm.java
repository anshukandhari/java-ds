package graphs.shortestPath;


import graphs.core.AdjacencyNode;
import graphs.core.GraphV2;
import java.util.Iterator;
import java.util.TreeSet;

public class DjiktraAlgorithm {

  /**
   * Complexity of this Djiktra's via adjeacency list is O(V+ VLogV + ELogV)
   */
  void dijkstra(GraphV2 graph, int src){

    // Set containing values in the format {vertex, weight from source}
    TreeSet<TreeSetNode> q = new TreeSet<>((o1,o2)-> o1.weight -o2.weight);
    TreeSetNode tsNodeArr[] = new TreeSetNode[graph.V];
    boolean visited[] = new boolean[graph.V];
    Iterator<AdjacencyNode> itr;

    for(int i=0; i< graph.V; i++){
      tsNodeArr[i] = new TreeSetNode(i,Integer.MAX_VALUE);
      if(i == src)
        tsNodeArr[src].weight = 0;

      q.add(tsNodeArr[i]);
    }

    TreeSetNode tempSource;
    AdjacencyNode tempDest;

    while(!q.isEmpty()){
      tempSource = q.pollFirst();
      System.out.println("Vertex:"+ tempSource.vertex + " Weight: "+ tempSource.weight);
      visited[tempSource.vertex] = true;

      itr = graph.adjListArray[tempSource.vertex].listIterator();

      while(itr.hasNext()){
        tempDest = itr.next();
        if(visited[tempDest.getDest()] == false &&  tsNodeArr[tempDest.getDest()].weight > tempSource.weight + tempDest.getWeight()){
          q.remove(tsNodeArr[tempDest.getDest()]);
          tsNodeArr[tempDest.getDest()].weight = tempSource.weight + tempDest.getWeight();
          q.add(tsNodeArr[tempDest.getDest()]);
        }
      }
    }

  }

  public static void main(String[] args) {

    GraphV2 g = new GraphV2(9, false);
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

    DjiktraAlgorithm djiktraAlgorithm = new DjiktraAlgorithm();

    djiktraAlgorithm.dijkstra(g,0);
  }

}

class TreeSetNode{
  int vertex;
  int weight;
  public TreeSetNode(int v, int d){
    vertex = v;
    weight = d;
  }
}
