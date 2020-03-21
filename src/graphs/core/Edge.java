package graphs.core;

public class Edge implements Comparable<Edge>{
  int from;
  int to;
  int weight;

  public Edge(int f, int t, int w){
    from = f;
    to = t;
    weight = w;
  }

  public int compareTo(Edge compareEdge) {
    return this.weight-compareEdge.weight;
  }

  public int getFrom() {
    return from;
  }

  public int getTo() {
    return to;
  }

  public int getWeight() {
    return weight;
  }
}
