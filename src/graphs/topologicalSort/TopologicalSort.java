package graphs.topologicalSort;

import graphs.core.Graph;
import java.util.Iterator;
import java.util.Stack;

public class TopologicalSort {

  /**
   * Time Complexity: O(V+E)
   */
  public void tsViaDFS(Graph g){
    boolean visited[] = new boolean[g.V];
    Stack<Integer> st = new Stack<>();

    for(int i=0; i<g.V; i++){
      if(!visited[i]){
        visited[i] = true;
        dfsUtil(g,visited,st, i);
      }

    }

    while(st.size()>0){
      System.out.println(st.pop());
    }
  }

  private void dfsUtil(Graph g, boolean visited[], Stack<Integer> st, int s){
    Iterator<Integer> itr = g.adjListArray[s].listIterator();
    int t;

    while(itr.hasNext()){
      t = itr.next();
      if(visited[t]){
        continue;
      }

      visited[t] = true;
      dfsUtil(g, visited, st, t);
    }

    st.push(s);

  }


  public void tsViaBFS(Graph g){

  }

  public static void main(String[] args) {
    Graph g = new Graph(6);
    g.addEdge(5, 2);
    g.addEdge(5, 0);
    g.addEdge(4, 0);
    g.addEdge(4, 1);
    g.addEdge(2, 3);
    g.addEdge(3, 1);

    TopologicalSort tsort = new TopologicalSort();
    tsort.tsViaDFS(g);
  }
}
