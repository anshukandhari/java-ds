package graphs.cycle;

import graphs.core.Graph;
import java.util.Iterator;
import java.util.ListIterator;

public class DetectCycleUG {

  public boolean hasCycle(Graph g){
    boolean visited[] = new boolean[g.V];
    boolean isCyclic = false;
      for(int i = 0; i< g.adjListArray.length; i++){
      if(!visited[i] && !isCyclic){
        isCyclic = hasCycleUtil(g, visited, -1, i);
      }

  }
    return isCyclic;
}

  private boolean  hasCycleUtil(Graph g, boolean visited[], int parent, int v){
    if(visited[v]){
      return true;
    }

    visited[v] = true;
    ListIterator<Integer> itr = g.adjListArray[v].listIterator();
    int t;
    while(itr.hasNext()){
      t = itr.next();
      if(t != parent && hasCycleUtil(g,visited,v,t)){
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    DetectCycleUG dcug = new DetectCycleUG();
    Graph g1 = new Graph(5, false);
    g1.addEdge(1, 0);
    g1.addEdge(1, 2);
    g1.addEdge(2, 0);
    g1.addEdge(0, 3);
    g1.addEdge(3, 4);
    if(dcug.hasCycle(g1)){
      System.out.println("Has Cycle");
    } else {
      System.out.println("Graph doesn't contain cycle");
    }

  }
}
