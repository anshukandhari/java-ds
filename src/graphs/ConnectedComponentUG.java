package graphs;

import graphs.core.Graph;

public class  ConnectedComponentUG {

  void connectedComponents(Graph g) {
    g.dfs(g,g.adjListArray[0].get(0));
  }

  public static void main(String[] args) {
    Graph g = new Graph(5);
    g.isDirected = false;
    g.addEdge(0, 1);
    g.addEdge(2, 3);
    g.addEdge(3, 4);
    (new ConnectedComponentUG()).connectedComponents(g);

  }

}
