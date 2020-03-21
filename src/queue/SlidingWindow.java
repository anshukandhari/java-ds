package queue;

import java.util.ArrayDeque;
import java.util.Arrays;

public class SlidingWindow {

  public int[] SlidingWindow(int A[], int ws) {
    ArrayDeque<Integer> dq = new ArrayDeque<>();
    int sol[] = new int[A.length-ws+1];


    for(int i =0; i<ws; i++){
      while(dq.size() >0 && A[i] >= A[dq.getLast()]){
        dq.removeLast();
      }
      dq.addLast(i);
    }

    for(int j =0; j< sol.length-1;j++){
      sol[j] = A[dq.getFirst()];

      if( j>=dq.getFirst()){
        dq.removeFirst();
      }

      while(dq.size() >0 && A[j+ws]>=A[dq.getLast()]){
        dq.removeLast();
      }

      dq.addLast(j+ws);
    }
    sol[sol.length-1] = A[dq.pollFirst()];

    return sol;
  }

  public static void main(String[] args) {
    SlidingWindow sw = new SlidingWindow();
    int A[] ={1,3,-1,-3,5,3,6,7};
    Arrays.stream(sw.SlidingWindow(A,3)).forEach(value -> System.out.println(value));

  }

}
