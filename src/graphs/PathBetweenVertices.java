package graphs;


import graphs.core.Graph;
import java.util.Iterator;
import java.util.LinkedList;


public class PathBetweenVertices {
  public static void pathBetweenVertices(Graph g, int a, int b){
    LinkedList<Integer> q = new LinkedList<>();
    boolean visited[] = new boolean[g.adjListArray.length];
    dfsUtil(g, a, b, q, visited);
  }

  private static void  dfsUtil(Graph g, int start, int end, LinkedList<Integer> q, boolean visited[]){
    visited[start]= true;
    q.add(start);
    Iterator<Integer> itr = g.adjListArray[start].listIterator();

    while(itr.hasNext()){
      int t = itr.next();

      if(t == end){
        Iterator<Integer> qItr = q.iterator();
        while(qItr.hasNext()){
          System.out.print(qItr.next());
        }
        System.out.println(end);
      } else {
        if(!visited[t])
          dfsUtil(g,t, end, q, visited);
      }

    }
    q.removeLast();
    visited[start] = false;
  }


  public static void main(String[] args) {
    Graph g = new Graph(4);
    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(0, 3);
    g.addEdge(2, 0);
    g.addEdge(2, 1);
    g.addEdge(1, 3);

    int s = 2, d = 3;
    pathBetweenVertices(g,s,d);
  }

}
