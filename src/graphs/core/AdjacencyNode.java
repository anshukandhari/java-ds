package graphs.core;

public class AdjacencyNode {

  int dest;
  int weight;

  public AdjacencyNode(int dest, int weight){
    this.dest = dest;
    this.weight = weight;
  }

  public int getDest() {
    return dest;
  }

  public int getWeight() {
    return weight;
  }
}