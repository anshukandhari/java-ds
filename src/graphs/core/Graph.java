package graphs.core;

import graphs.traversal.GraphTraversal;
import java.util.LinkedList;

public class Graph {

  private final GraphTraversal graphTraversal = new GraphTraversal();
  public int V;
  public LinkedList<Integer> adjListArray[];
  public boolean isDirected = true;

  public Graph(int v){
    this.V = v;
    adjListArray = new LinkedList[v];
    for (int i=0; i<v; i++)
      adjListArray[i] = new LinkedList();
  }

  public Graph(int v, boolean isDirected){
    this.V = v;
    this.isDirected = isDirected;
    adjListArray = new LinkedList[v];
    for (int i=0; i<v; i++)
      adjListArray[i] = new LinkedList();
  }

  public void addEdge(int src, int dest){
    if(src >= adjListArray.length || dest >= adjListArray.length){
      System.out.println("Source or destination does not exists");
      return;
    }

    adjListArray[src].add(dest);

    if(!isDirected){
      adjListArray[dest].add(src);
    }

  }

  public void bfs(Graph g, int start){
    graphTraversal.bfs(g, start);
  }


  public  void dfs(Graph g, int start){
    graphTraversal.dfs(g, start);
  }

  public  void dfsUtil(Graph g, int start, boolean visited[]){
    graphTraversal.dfsUtil(g, start, visited);
  }

}
