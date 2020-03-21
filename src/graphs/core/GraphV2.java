package graphs.core;

import java.util.LinkedList;

public class GraphV2 {
  public int V;
  public LinkedList<AdjacencyNode> adjListArray[];
  public boolean isDirected = false;

  public GraphV2(int v, boolean isDirected){
    this.V = v;
    this.isDirected = isDirected;

    adjListArray = new LinkedList[v];

    for (int i=0; i<v; i++){
      adjListArray[i] = new LinkedList<>();
    }

  }

  public void addEdge(int src, int dest, int weight){
    if(src >= adjListArray.length || dest >= adjListArray.length || src < 0 || dest <0){
      System.out.println("Source or destination does not exists");
      return;
    }


    AdjacencyNode destNode = new AdjacencyNode(dest,weight);

    adjListArray[src].add(destNode);

    if(!isDirected){
      AdjacencyNode srcNode = new AdjacencyNode(src,weight);
      adjListArray[dest].add(srcNode);
    }
  }
}
