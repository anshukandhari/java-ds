package graphs;

import graphs.core.Graph;
import java.util.HashMap;
import java.util.Iterator;

public class KCores {

  public void printKCores(Graph g, int c){
    HashMap<Integer, Integer> hm = new HashMap<>();
    for(int i=0;i<g.V;i++){
      hm.put(i,g.adjListArray[i].size());
    }

    boolean visited[] = new boolean[g.V];


    hm.forEach((k,v)->{
      if(v<c && !visited[v]){
        dfsCore(g,hm, k,c, visited);
      }
    });

    hm.forEach((k,v)->{
      if(v!=0){
        System.out.println("["+k+"]-"+ g.adjListArray[k].toString());
      }
    });

  }

  private void dfsCore(Graph g, HashMap<Integer,Integer> hm, int s, int c, boolean visited[]){
    visited[s] = true;
    Iterator<Integer> itr = g.adjListArray[s].listIterator();
    int t;

    while(itr.hasNext()){
      t = itr.next();

      if(visited[t])
        continue;

      hm.put(t, hm.get(t)-1);
      if(hm.get(t)<c){
        dfsCore(g,hm, t,c, visited);
      }
    }
    System.out.println("Removing :"+ s);
    hm.put(s,0);
  }

  public static void main(String[] args) {
    int k = 3;
    Graph g1 = new Graph(9);
    g1.isDirected= false;
    g1.addEdge(0, 1);
    g1.addEdge(0, 2);
    g1.addEdge(1, 2);
    g1.addEdge(1, 5);
    g1.addEdge(2, 3);
    g1.addEdge(2, 4);
    g1.addEdge(2, 5);
    g1.addEdge(2, 6);
    g1.addEdge(3, 4);
    g1.addEdge(3, 6);
    g1.addEdge(3, 7);
    g1.addEdge(4, 6);
    g1.addEdge(4, 7);
    g1.addEdge(5, 6);
    g1.addEdge(5, 8);
    g1.addEdge(6, 7);
    g1.addEdge(6, 8);

    KCores kc = new KCores();
    kc.printKCores(g1,k);
  }


}
