package graphs.traversal;

import graphs.core.Graph;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class GraphTraversal {

  /**
   * Complexity of BFS is O(E+V)
   */
  public void bfs(Graph g, int start) {

    boolean visited[] = new boolean[g.adjListArray.length];
    Queue<Integer> q = new LinkedList();
    q.offer(start);
    visited[start] = true;

    while (q.size() > 0) {
      int x = q.poll();

      System.out.println(x);


      int t;
      Iterator<Integer> itr = g.adjListArray[x].listIterator();
      while (itr.hasNext()) {
        t = itr.next();
        if(!visited[t]){
          visited[t] = true;
          q.offer(t);
        }

      }

    }
  }

  /**
   * Complexity of DFS is O(E+V)
   */
  public void dfs(Graph g, int start) {
    boolean visited[] = new boolean[g.adjListArray.length];

    dfsUtil(g, start, visited);

    for (int i = 0; i < g.adjListArray.length; i++) {
      if (!visited[i]) {
        System.out.println();
        dfsUtil(g, i, visited);
      }
    }
  }

  public void dfsUtil(Graph g, int start, boolean visited[]) {
    visited[start] = true;
    System.out.print(start + "--");
    Iterator<Integer> itr = g.adjListArray[start].listIterator();

    int t;
    while (itr.hasNext()) {
      t = itr.next();
      if (!visited[t]) {
        dfsUtil(g, t, visited);
      }
    }
  }


  public static void main(String[] args) {
    Graph g = new Graph(4);

    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(1, 2);
    g.addEdge(2, 0);
    g.addEdge(2, 3);
    g.addEdge(3, 3);

    GraphTraversal gt = new GraphTraversal();

    System.out.println("Following is Breadth First Traversal "+
        "(starting from vertex 2)");

    gt.bfs(g,2);

    System.out.println("Following is Depth First Traversal "+
        "(starting from vertex 2)");
    gt.dfs(g,2);
  }
}