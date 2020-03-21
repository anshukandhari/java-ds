package graphs.cycle;

import graphs.core.Graph;
import java.util.HashSet;
import java.util.ListIterator;

public class DetectCycleDG {

  public boolean hasCycle(Graph g){
    boolean visited[] = new boolean[g.V];
    HashSet<Integer> hs = new HashSet<>();
    boolean isCyclic = false;
    for(int i = 0; i< g.adjListArray.length; i++){
      if(!visited[i] && !isCyclic){
        isCyclic = hasCycleUtil(g, visited, hs,i);
      }

    }

    return isCyclic;
  }

  private boolean  hasCycleUtil(Graph g, boolean visited[], HashSet<Integer> hs, int v){
    if(hs.contains(v)){
      return true;
    }

    if(visited[v]){
      return false;
    }

    hs.add(v);
    visited[v] = true;
    ListIterator<Integer> itr = g.adjListArray[v].listIterator();
    while(itr.hasNext()){
      if(hasCycleUtil(g,visited,hs,itr.next())){
        return true;
      }
    }
    hs.remove(v);
    return false;
  }

  public static void main(String[] args) {
    DetectCycleDG dcdg = new DetectCycleDG();
    Graph g = new Graph(4,true);
    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(2, 1);
    g.addEdge(2, 0); // Remove this to test no cycle
    g.addEdge(2, 3);
    if(dcdg.hasCycle(g)){
      System.out.println("Has Cycle");
    } else {
      System.out.println("Graph doesn't contain cycle");
    }
  }

}
