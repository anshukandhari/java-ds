package dynamicProgramming;

import java.util.Arrays;

public class CutRod {

  public int curRod(int p[], int l){
    int m[][] = new int[p.length+1][l+1];

    for(int i = 0; i <= p.length ; i++){
      for(int j = 0; j<=l;j++){
        if(i == 0 || j == 0){
          m[i][j] = 0;
          continue;
        }
        if(j-i >=0){
          m[i][j] = Math.max(p[i-1]+m[i][j-i], m[i-1][j]);
        } else {
          m[i][j] = m[i-1][j];
        }

      }
    }

    for(int i = 0; i < p.length ; i++){
      System.out.println(Arrays.toString(m[i]));
    }
    return m[p.length][l];
  }


  public int curRodOptimized(int p[], int l){
    int m[] = new int[l+1];

    for(int i = 0; i <= p.length ; i++){
      for(int j = 0; j<=l;j++){
        if(i == 0 || j == 0){
          m[j] = 0;
          continue;
        }
        if(j-i >=0){
          m[j] = Math.max(p[i-1]+m[j-i], m[j]);
        }
      }
    }

    return m[l];
  }

  public int curRodOptimized2(int p[], int l){
    if(l == 0){
      return 0;
    }

    int sol[] = new int[l+1];
    sol[0] = 0;

    for(int i = 1; i <=l; i++){
      int max = Integer.MIN_VALUE;
      for(int j = 0; j<i; j++){
        max = Math.max(max, sol[j]+p[i-j-1]);
      }
      sol[i]= max;
    }

    return sol[l];
  }



  public static void main(String[] args) {
    //int A[] = {1, 101, 2, 3, 100, 4, 5};
    //System.out.println(maxSumIncSubsequence(A));
    int arr[] = {1, 5, 8, 9, 10, 17, 17, 20};
    CutRod cr = new CutRod();
    System.out.println(cr.curRod(arr,arr.length));
    System.out.println(cr.curRodOptimized(arr,arr.length));
    System.out.println(cr.curRodOptimized2(arr,arr.length));

  }

}
