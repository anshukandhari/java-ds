package graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class KnightShortestPath {
  static int minStepToReachTarget(int knightPos[], int targetPos[], int boardSize){
    int kx, ky;
    int tx = targetPos[0], ty = targetPos[1];

    //check validity of inputs i.E. length of arrays & kx,ky,tx,ty

    int xmove[] = {-2, -1, 1, 2, -2, -1, 1, 2};
    int ymove[] = {-1, -2, -2, -1, 1, 2, 2, 1};

    Queue<int[]> q = new LinkedList<>();
    boolean visited[][] = new boolean[boardSize][boardSize];
    q.add(knightPos);

    int ans = 0, size;
    int temp[] = new int[2];
    visited[knightPos[0]][knightPos[1]] = true;

    while(q.size() > 0){
      size = q.size();

      while(size >0){
        kx = q.peek()[0];
        ky = q.peek()[1];
        q.remove();

        if(kx == tx && ky == ty){
          return ans;
        }

        for(int i=0; i< xmove.length;i++){
          temp[0] = kx+xmove[i];
          temp[1] = ky+ymove[i];

          if(temp[0] < 0 || temp[0] >= boardSize || temp[1] < 0 || temp[1] >= boardSize || visited[temp[0]][temp[1]]){
            continue;
          }

          int t[] = Arrays.copyOf(temp,temp.length);
          visited[t[0]][t[1]] = true;
          q.add(t);
        }
        size--;
      }

      ans++;

    }

    return -1;
  }

  public static void main(String[] args) {
    int knightPos[] = {1, 1};
    int targetPos[] = {30, 30};
    System.out.println(minStepToReachTarget(knightPos, targetPos, 31));
  }

}
