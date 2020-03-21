package stack.other;

import java.util.*;
import java.lang.*;
import java.util.Stack;

// https://practice.geeksforgeeks.org/problems/stock-span-problem/0

class StockSpan {
  public static void main (String[] args) {
    //code
    Scanner scan = new Scanner(System.in);
    int t = scan.nextInt();

    for (int i=0; i<t; i++){
      int n = scan.nextInt();
      int a[] = new int[n];
      for (int j =0;j<n;j++){
        a[j] = scan.nextInt();
      }
      stockSpan(a,n);
    }
  }

  private static void stockSpan(int A[], int n){
    int sol[] = new int[n];
    Stack<Integer> s = new Stack<>();
    int j;

    for(int i=0; i<n;i++){
      while(!(s.empty()) && A[i] >= A[s.peek()]){
        s.pop();
      }

      if(s.empty()){
        j = -1;
      } else {
        j = s.peek();
      }

      sol[i]=i-j;
      s.push(i);
    }

    for(int i=0; i<n;i++){
      System.out.print(sol[i]+ " ");
    }
    System.out.println();
  }
}