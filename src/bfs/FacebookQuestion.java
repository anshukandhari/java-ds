package bfs;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * I used the concept of Djiktras Algo, in a way.
 * For all the eligible neighbors, I enqueue in front those who are of same sign, other are enqueued at the back
 */
public class FacebookQuestion {

  public int minCostDestination(char m[][]){
    int cost[][] = new int[m.length][m[0].length];

    for(int i = 0; i<m.length;i++){
      for(int j = 0; j<m[0].length; j++){
        cost[i][j] = Integer.MAX_VALUE;
      }
    }

    int t[], n[];
    ArrayList<int[]> al;

    LinkedList<int []> q = new LinkedList<>();
    cost[0][0] = 0;


    q.offer(new int[]{0,0});
    cost[0][0] = 0;

    while(q.size()>0){
      t = q.poll();
      al = getNeighbours(t[0], t[1], m, cost);
      for(int i = 0; i<al.size();i++){
        n = al.get(i);

        if(m[n[0]][n[1]] == m[t[0]][t[1]]){
          cost[n[0]][n[1]] = cost[t[0]][t[1]];
          q.addFirst(n);
        } else {
          cost[n[0]][n[1]] = cost[t[0]][t[1]]+1;
          q.addLast(n);
        }
      }

    }
    return cost[m.length-1][m[0].length-1];
  }

  private ArrayList<int[]> getNeighbours(int x, int y, char m[][], int cost[][]){
    ArrayList<int[]> sol = new ArrayList<>();

    if(x>0 && m[x-1][y] != '-' && cost[x-1][y] == Integer.MAX_VALUE){
      sol.add(new int[]{x-1,y});
    }

    if(y>0 && m[x][y-1] != '-' && cost[x][y-1] == Integer.MAX_VALUE){
      sol.add(new int[]{x,y-1});
    }

    if(x<m.length-1 && m[x+1][y] != '-' && cost[x+1][y] == Integer.MAX_VALUE){
      sol.add(new int[]{x+1,y});
    }

    if(y<m[0].length-1 && m[x][y+1] != '-' && cost[x][y+1] == Integer.MAX_VALUE){
      sol.add(new int[]{x,y+1});
    }

    return  sol;
  }

  public static void main(String[] args) {
    FacebookQuestion fbq = new FacebookQuestion();
    char m[][] = {
        {'1','0', '1', '0', '1'},
        {'0','1', '0', '-', '1'},
        {'0','-', '1', '0', '0'},
        {'0','0', '0', '-', '1'}};

    System.out.println(fbq.minCostDestination(m));

  }


}
