package graphs.core;

public class GraphViaEdges {
  public int V;
  public int E;
  public Edge edges[];
  int edgeItr;

  public GraphViaEdges(int v, int e){
    this.V = v;
    this.E = e;
    edges = new Edge[e];
    edgeItr = 0;
  }

  public void addEdge(int from, int to, int weight){
    this.edges[edgeItr++] = new Edge(from,to,weight);
  }
}

