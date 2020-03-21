package matrix;

public class DiagnoalPrint {

  public static int[] findDiagonalOrder(int[][] m) {

    int sol[] = new int[m.length*m[0].length];
    int dir[][] = {{-1,1},{1,-1}}, d =0;

    int i = 0, j = 0, r= m.length, c = m[0].length, idx = 0;

    while(i != r-1 && j != c-1){
      sol[idx++] = m[i][j];

      i += dir[d][0];
      j += dir[d][1];

      if(j >= c){
        j = c-1;
        i += 2;
        d = 1-d;
      }

      if(i >= r){
        i = r-1;
        j += 2;
        d = 1-d;
      }

      if(i < 0){
        i = 0;
        d = 1-d;
      }

      if(j < 0){
        j = 0;
        d = 1-d;
      }
    }

    sol[idx++] = m[i][j];

    return sol;
  }

  public static void main(String[] args) {
    findDiagonalOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
  }

}
