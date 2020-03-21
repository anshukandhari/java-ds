package dynamicProgramming;

import java.util.Arrays;

public class MaxSumSubRectangle {

  private static int findMaxSubMatrix(int m[][]){
    int maxSoFar = Integer.MIN_VALUE;
    int maxTop=-1, maxBottom=-1, maxLeft=-1, maxRight=-1;
    int kadResult[];

    int a[] = new int[m.length];

    for(int l =0; l<m[0].length;l++){
      Arrays.fill(a,0);
      for(int r = l; r<m[0].length;r++){
          for(int i=0;i<a.length;i++){
            a[i] += m[i][r];
          }
          kadResult = kadane(a);

          if(kadResult[0] > maxSoFar) {
            maxSoFar = kadResult[0];
            maxLeft = l;
            maxRight = r;
            maxTop = kadResult[1];
            maxBottom = kadResult[2];
          }

      }
    }
    System.out.printf("Sum is %d from %d ,%d to %d , %d", maxSoFar, maxTop, maxLeft, maxBottom, maxRight);

    return maxSoFar;
  }


  public static int[] kadane(int a[]){
    int sol[] = new int[3];
    int l = a.length;

    int s=-1,maxSoFar=Integer.MIN_VALUE,sum=0, fs =-1, fe =-1;
    for(int i =0; i<l;i++){
      sum += a[i];
      if(sum<0){
        sum = 0;
        s = -1;
      } else {
        if(s == -1){
          s = i;
        }

        if(sum>maxSoFar){
          fe = i;
          fs = s;
          maxSoFar = sum;
        }

      }
    }

    sol[0] = maxSoFar;
    sol[1] = fs;
    sol[2] = fe;

    return sol;
  }

  public static void main(String[] args) {
    findMaxSubMatrix(new int[][] {
        {1, 2, -1, -4, -20},
        {-8, -3, 4, 2, 1},
        {3, 8, 10, 1, 3},
        {-4, -1, 1, 7, -6}
    });
  }

}
