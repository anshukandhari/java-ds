package backtracking.typeB;

public class NQueen {
  int N;
  int board[][];

  public NQueen(int n){
    N = n;
    board = new int[n][n];

    for (int x = 0; x < N; x++) {
      for (int y = 0; y < N; y++) {
        board[x][y] = 0;
      }
    }
  }


  private boolean isSafe(int x, int y){
    //Check row
    for(int i = 0; i< N; i++){
      if(board[x][i] != 0){
        return false;
      }
    }

    // Check upper left diagonal
    int i = x, j = y;
    while(--i >= 0 && --j >= 0) {
      if(board[i][j] != 0){
        return false;
      }
    }

    i = x;
    j = y;
    while(++i < N && --j >= 0) {
      if(board[i][j] != 0){
        return false;
      }
    }

    return true;
  }

  public boolean solveNQueen(int col){
    if(col == N) {
      return true;
    }

    for(int i=0;i<N;i++){
      if(isSafe(i,col)) {
        board[i][col] = 1;
        if (solveNQueen(col + 1)) {
          return true;
        } else {
          board[i][col] = 0;
        }
      }
    }

    return false;
  }

  public void  printBoard(){
    for (int x = 0; x < N; x++) {
      for (int y = 0; y < N; y++) {
        System.out.print(board[x][y] + "  ");
      }
      System.out.println();
    }
  }


  public static void main(String[] args) {
    NQueen nq = new NQueen(4);
    nq.solveNQueen(0);
    nq.printBoard();

  }

}
