package dynamicProgramming;

import java.util.Arrays;

public class BinomialCoefficient {

  /**
   * This is really great question to understand & then apply this to solve many problems
   * Find the binomial coefficient or find value of nCk
   * OR Find the nth row of Pascals triangle
   *
   * If we know how to find nCk, some question are super easy
   *
    */


  public static int getCoefficient(int n, int k){
    int sol[] = new int[n+1];
    sol[0] = 1;
    for(int i = 1; i<=n; i++){
      for(int j = i ; j >0; j--){
        sol[j]+=sol[j-1];
      }
    }

    System.out.println(Arrays.toString(sol));
    return sol[k];
  }


  public static void main(String[] args) {
    // what is 5C2?
    System.out.println("5C2 is : "+getCoefficient(5, 2));
  }


}
