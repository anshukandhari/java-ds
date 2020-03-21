package dynamicProgramming.codility;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class MinAbsSum {
  Integer ans[];
  public int solution(int[] A) {
    // write your code in Java SE 8
    ans = new Integer[A.length];

    for(int i =0; i< A.length; i++)
      A[i] = A[i]<0?-1*A[i]:A[i];


    Arrays.sort(A);
    return  solutionUtil(A, 0);
  }

  int solutionUtil(int[] A, int idx) {
    if(idx == A.length){
      return 0;
    }

    if(ans[idx] != null)
      return ans[idx];

    ans[idx] =  Math.min(Math.abs(A[idx] + solutionUtil(A, idx+1)), Math.abs(-A[idx] + solutionUtil(A, idx+1)));

    return ans[idx];

  }

  public static void main(String[] args) {
    MinAbsSum mas = new MinAbsSum();
    System.out.println(mas.solution2(new int[]{3,3,3,4,5}));
  }

  public int solution2(int[] A) {
    for(int i =0; i< A.length; i++)
      A[i] = A[i]<0?-1*A[i]:A[i];

    int size = 0, temp, min = 0;

    Queue<Integer> q = new LinkedList<>();
    HashSet<Integer> hs = new HashSet<>();

    q.offer(0);
    hs.add(0);

    for(int i =0 ; i< A.length; i++){
      size = q.size();
      min = Integer.MAX_VALUE;
      for(int j =0 ; j< size; j++) {
        temp = q.poll();
        hs.remove(temp);


        if(!hs.contains(temp + A[i])){
          hs.add(temp + A[i]);
          q.offer(temp + A[i]);
        }


        min = Math.min(min, temp+A[i]);
        if(temp-A[i]>=0){
          if(!hs.contains(temp - A[i])){
            hs.add(temp - A[i]);
            q.offer(temp - A[i]);
          }
          min = Math.min(min, temp-A[i]);

        } else {
          if(!hs.contains(A[i]-temp)){
            hs.add(A[i]-temp);
            q.offer(A[i]-temp);
          }
          min = Math.min(min, A[i]-temp);
        }
      }
    }

    return min;

  }

}
