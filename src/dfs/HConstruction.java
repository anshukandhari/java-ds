package dfs;

import java.util.LinkedList;
import java.util.Queue;

public class HConstruction {
  int count = 0;

  /**
   * Problem: https://www.pramp.com/challenge/EmYgnOgVd4IElnjAnQqn
   */

  static public void main( String args[] ) {
    System.out.println( "Practice makes Perfect!" );
    HConstruction hc = new HConstruction();

    hc.drawHTree(1, 3, 0, 0);
  }

  public void drawHTree(double l, double d, double x, double y){
    Queue<double[][]> q = new LinkedList();
    q.offer(drawHTreeUtil(l,x,y));
    double res[][];

    while(q.size()>0 && --d>0){
      l = l/Math.pow(l,1/2);

      int size = q.size();
      for (int j = 0; j < size; j++) {
        res = q.poll();
        for(int i=0; i<res.length;i++){
          q.offer(drawHTreeUtil(l,res[i][0],res[i][1]));
        }
      }

    }
  }

  public double[][] drawHTreeUtil(double l, double x, double y){
    drawline(x-l/2,y , x+l/2,y);  // hor
    drawline(x-l/2,y+l/2 , x-l/2,y-l/2);  // ver
    drawline(x+l/2,y+l/2 , x+l/2,y-l/2);  // ver

    System.out.println("H created"+ ++count);

    return new double[][]{{x-l/2,y+l/2} , {x-l/2,y-l/2}, {x+l/2,y+l/2} , {x+l/2,y-l/2}};
  }

  private void drawline(double x1, double y1, double x2, double y2){

  }
}
