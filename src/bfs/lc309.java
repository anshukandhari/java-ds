package bfs;

public class lc309 {
  int ans = 0, sol[][];
  int dir[][] = {{0,1},{1,0}, {0, -1}, {-1, 0}};
  public int longestIncreasingPath(int[][] m) {
    if(m.length == 0)
      return 0;
    int r = m.length, c = m[0].length;
    sol = new int[r][c];

    for(int i = 0 ; i<r ; i++){
      for(int j = 0; j<c; j++){
          dfs(m, i, j);
      }

    }

    for(int i = 0 ; i<r ; i++){
      for(int j = 0; j<c; j++){
        ans = Math.max(ans, sol[i][j]);
      }

    }

    return ans;

  }

  private int dfs(int m[][], int x, int y){

    if(sol[x][y] != 0)
      return sol[x][y];



    int max = 1, nx, ny;
    for(int i = 0; i< 4; i++){
      nx = x+dir[i][0];
      ny = y+dir[i][1];
      if(nx < 0 || ny < 0 || nx >= sol.length || ny >= sol[0].length || m[x][y] >= m[nx][ny])
        continue;
      max = Math.max(max,1+dfs(m, nx, ny));

    }

    sol[x][y] = max;

    return max;
  }

  public static void main(String[] args) {
    lc309 lc = new lc309();
    int m[][] = new int[][]{
        {9,9,4},{6,6,8},{2,1,1}
    };
    System.out.println(lc.longestIncreasingPath(m));
  }
}
