package dynamicProgramming;

import java.util.Arrays;

public class minJumps {

  private static int minJumps(int a[]){
    int l = a.length;
    int sol[] = new int[l];

    Arrays.fill(sol, Integer.MAX_VALUE);

    sol[0] =0;
    int j;
    for(int i=0;i<l;i++){
      j = 1;
      while(j<=a[i] && i+j <l){
        sol[i+j] = Math.min(sol[i+j],sol[i]+1);
        j++;
      }
    }


    return sol[l-1];
  }

  public static void main(String[] args) {
    int arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
    System.out.println(minJumps(arr));
  }

}
