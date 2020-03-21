package matrix;

import java.util.LinkedList;
import java.util.List;

public class Set1 {
  public static List<Integer> spiralOrder(int[][] m) {
    int rend = m.length;
    List<Integer> sol = new LinkedList<>();
    if(m.length == 0){
      return sol;
    }
    int cend = m[0].length;
    int rstart = 0, cstart=0;



    int i=rstart,j= cstart;

    while(rstart<rend && cstart<cend){

      for(j=cstart; j<cend;j++){
        sol.add(m[i][j]);
      }
      rstart++;
      j--;


      for(i = rstart; i<rend;i++){
        sol.add(m[i][j]);
      }
      cend--;
      i--;


      if(rstart<rend){
        for(j=cend-1; j>=cstart; j--){
          sol.add(m[i][j]);
        }
        rend--;
        j++;
      }

      if(cstart<cend){
        for(i=rend-1; i>=rstart;i--){
          sol.add(m[i][j]);
        }
        cstart++;
        i++;
      }
    }
    return sol;
  }

  public static void main(String[] args) {
    int m[][]= {{1,2,3},{4,5,6},{7,8,9}};
    spiralOrder(m);
  }
}
