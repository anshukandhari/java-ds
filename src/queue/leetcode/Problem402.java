package queue.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;

public class Problem402 {

  public int[] SlidingWindow(int A[], int ws) {
    ArrayDeque<Integer> dq = new ArrayDeque<>();
    int sol[] = new int[A.length-ws+1];


    for(int i =0; i<ws; i++){
      while(dq.size() >0 && A[i]<=A[dq.getLast()]){
        dq.removeLast();
      }
      dq.addLast(i);
    }

    for(int j =0; j< sol.length-1;j++){
      sol[j] = A[dq.pollFirst()];

      if(dq.size() >0 && j>=dq.getFirst()){
        dq.removeFirst();
      }

      while(dq.size() >0 && A[j+ws]<=A[dq.getLast()]){
        dq.removeLast();
      }

      dq.addLast(j+ws);
    }
    sol[sol.length-1] = A[dq.pollFirst()];

    return sol;
  }

  public static void main(String[] args) {
    Problem402 sw = new Problem402();
    int A[] ={1,0,2,0,0};
    Arrays.stream(sw.SlidingWindow(A,2)).forEach(value -> System.out.print(value));


  }

}
