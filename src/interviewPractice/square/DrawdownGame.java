package interviewPractice.square;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DrawdownGame {
  public void predictWinner(int b[], int m[][]){
    Queue<int []> q = new LinkedList<>();

    for(int i=0;i<m.length;i++)
      q.add(m[i]);

    int t[], s;
    boolean isExecuted = false;
    while(q.size()>0){
      s = q.size();
      for(int i=0; i<s;i++){
        isExecuted = false;
        t = q.poll();
        if(executeMove(b,t)){
          System.out.println("Move applied : "+ Arrays.toString(t) + " board is : " + Arrays.toString(b));
          isExecuted = true;
          break;
        } else {
          q.offer(t);
        }

      }

      if(!isExecuted){
        break;
      }
    }

    System.out.println(Arrays.toString(b));

  }


  private boolean executeMove(int b[], int m[]){
    boolean isSuccessfull = true;
    int j = m.length-1;

    for(int i=0;i<m.length;i++){
      b[i]+=m[i];
      if(b[i] < 0){
        isSuccessfull = false;
        j = i;
        break;
      }
    }

    if(!isSuccessfull){
      while(j>=0){
        b[j]-=m[j];
        j--;
      }
    }



    return isSuccessfull;
  }


  public static void main(String[] args) {
    DrawdownGame g = new DrawdownGame();
    int b[] = {6, 4, 2, 4};
    int m[][] = {{-2, -2, 1, 0},{-4, -4, 0 ,0},{0, 0, -2, -2}};
    g.predictWinner(b,m);
  }

}
