package graphs.shortestPath;

import graphs.core.Graph;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class UnweightedGraph {

  /**
   * Complexity of this BFS is O(E+V)
   */
  public void shortestPathUG(Graph g, int s, int e){
    Queue<Integer> q = new LinkedList<>();
    HashMap<Integer, Integer> distance = new HashMap<>();

    q.add(s);
    distance.put(s,0);

    int curr, t;
    Iterator<Integer> itr;
    while(!q.isEmpty()){
      curr = q.poll();

      itr = g.adjListArray[curr].listIterator();

      while (itr.hasNext()){
        t = itr.next();
        if(distance.containsKey(t)){
          continue;
        }

        distance.put(t,distance.get(curr)+1);
        q.offer(t);
      }
    }


  }

}
