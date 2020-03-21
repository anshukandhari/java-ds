package matrix;

import java.util.ArrayList;

// LeetCode 289
public class GameOfLife {
  public void gameOfLife(int[][] b) {
    ArrayList<int[]> live = new ArrayList<>();
    ArrayList<int[]> die = new ArrayList<>();

    int t;
    for(int i =0; i< b.length;i++){
      for(int j =0; j <b[0].length; j++){

        t =  getNeighbourSum(i,j, b);
        if(b[i][j] == 1 && (t <2 || t>3)){
          die.add(new int[]{i,j});
        } else if(b[i][j] == 0 && t ==3){
          live.add(new int[]{i,j});
        }
      }
    }

    int c[];
    for(int i =0; i<live.size();i++){
      c = live.get(i);
      b[c[0]][c[1]] =1;
    }

    for(int i =0; i<die.size();i++){
      c = live.get(i);
      b[c[0]][c[1]] =0;
    }
  }

  private int getNeighbourSum(int x, int y, int [][]b){
    int sum = 0;
    if(x != 0){
      sum += b[x-1][y];
      if(y !=0)
        sum += b[x-1][y-1];
      if(y <b[0].length-1)
        sum += b[x-1][y+1];
    }

    if(x<b.length-1){
      sum += b[x+1][y];
      if(y !=0)
        sum += b[x+1][y-1];
      if(y <b[0].length-1)
        sum += b[x+1][y+1];
    }

    if(y!=0){
      sum += b[x][y-1];
    }

    if(y <b[0].length-1){
      sum += b[x][y+1];
    }

    return sum;
  }

  public static void main(String[] args) {
    GameOfLife gol = new GameOfLife();
    int b[][] = {{0,1,0},{0,0,1}, {1,1,1}, {0,0,0}};
    gol.gameOfLife(b);
  }
}
