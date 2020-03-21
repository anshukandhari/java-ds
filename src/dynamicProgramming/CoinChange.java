package dynamicProgramming;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class CoinChange {

  /**
   * The problem could have 2 options
   * a) To find the number of ways to make a sum with coins can be repeated any number of times. Here we can use DP tabulation
   * b) Find all the possible combination to make a sum from given coins, here we can use DFS version of backtracking.
   *
   * You can also try the variant of this https://leetcode.com/problems/coin-change/
   */


  public static int countWays(int a[], int n){
    int m[][] = new int[a.length+1][n+1];

    for(int i = 0; i <= a.length; i++){
      for(int j = 0; j <= n; j++){
        if(j == 0){
          m[i][j] = 1;
          continue;
        }
        if(i == 0){
          m[i][j] = 0;
          continue;
        }

        if(a[i-1]<=j){
          m[i][j] = m[i][j-a[i-1]]+ m[i-1][j];
        } else {
          m[i][j] = m[i-1][j];
        }
      }
    }

    return m[a.length][n];

  }


  public static int countWaysOptimized(int a[], int n){
    int m[] = new int[n+1];

    for(int i = 0; i <= a.length; i++){
      for(int j = 0; j <= n; j++){
        if(j == 0){
          m[j] = 1;
          continue;
        }
        if(i == 0){
          m[j] = 0;
          continue;
        }

        if(a[i-1]<=j){
          m[j] = m[j-a[i-1]]+ m[j];
        }
      }
    }

    return m[n];

  }

  public static int countWaysOptimized2(int a[], int n){
    int t[] = new int[n+1];
    t[0] = 1;

    for(int i = 0; i<a.length;i++){
      for (int j = a[i]; j<=n;j++){
        t[j] += t[j-a[i]];
      }
    }
    System.out.println(Arrays.toString(t));
    return t[n];
  }



  public static int findCombinations(int a[], int n){
    ArrayList<ArrayList<Integer>> sol = new ArrayList<>();
    Arrays.sort(a);
    ArrayList<Integer> curr = new ArrayList<>();
    findCombinationsUtil(sol,a,n,0, curr);
    System.out.println(sol);
    return sol.size();
  }


  public static void findCombinationsUtil(ArrayList<ArrayList<Integer>> sol,int a[], int n, int idx, ArrayList<Integer> curr) {
    if(n<0){
      return;
    }

    if(n == 0){
      sol.add(new ArrayList<>(curr));
      return;
    }

    if(a[idx] > n){
      return;
    }


    for(int i=idx; i < a.length; i++){
      curr.add(a[i]);
      findCombinationsUtil(sol,a,n-a[i],i,curr);
      curr.remove(curr.size()-1);
    }
  }

  public static void main(String[] args) {
    int arr[] = {1,2,5};
    int sum = 11;
    System.out.println("There are "+ countWays(arr,sum)+ "  ways. And the combinations are :");
    System.out.println( findCombinations(arr, sum));
  }




}
