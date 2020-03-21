package backtracking.typeB;

public class KnightTour {
  int boardSize;
  int sol[][];

  public KnightTour(int n){
    boardSize = n;
    sol = new int[boardSize][boardSize];
    for (int x = 0; x < boardSize; x++) {
      for (int y = 0; y < boardSize; y++) {
        sol[x][y] = -1;
      }
    }
  }

  public void kt(int x, int y){
    int xmove[] = {  2, 1, -1, -2, -2, -1,  1,  2 };
    int ymove[] = {  1, 2,  2,  1, -1, -2, -2, -1 };
    sol[0][0] =0;
    if(ktUtil(0,0,xmove,ymove,1));
  }

  private boolean ktUtil(int x,int y, int xmove[], int ymove[], int move){
    if(move == boardSize * boardSize){
      return true;
    }
    int newx, newy;
    for(int i = 0;i<xmove.length; i++){
      newx = x+xmove[i];
      newy = y+ymove[i];
      if(isCorrectPosition(newx , newy)){
        sol[newx][newy] = move;
        if(ktUtil(newx,newy, xmove,ymove,move+1)){
          return true;
        } else {
          sol[newx][newy] = -1;
        }
      }
    }
    return false;
  }

  private boolean isCorrectPosition(int x, int y){
    if(x < boardSize && y < boardSize && x >= 0 && y >= 0 && sol[x][y] == -1){
      return true;
    }
    return false;
  }

  public static void main(String[] args) {
    KnightTour kt = new KnightTour(5);

    kt.kt(0, 0);

    for (int x = 0; x < kt.boardSize; x++) {
      for (int y = 0; y < kt.boardSize; y++) {
        System.out.print(kt.sol[x][y] + "  ");
      }
      System.out.println();
    }
  }

}
