package dynamicProgramming.leetcode;

import java.util.Arrays;

public class EvenOddJump {
  public int oddEvenJumps(int[] A) {
    int count = 0, j;
    boolean isOdd = true;
    int oddJumpReachablity[] = new int[A.length];
    int evenJumpReachablity[] = new int[A.length];

    if(A.length == 0){
      return count;
    }
    count++;

    for(int i = A.length-2; i>= 0; i--){
      oddJumpReachablity[i] = getSmallestGreaterThanK(A, A[i], i+1,A.length-1);
      evenJumpReachablity[i] = getLargestSmallerThanK(A, A[i], i+1,A.length-1);
    }

    System.out.println(Arrays.toString(oddJumpReachablity));
    System.out.println(Arrays.toString(evenJumpReachablity));


    for(int i = 0; i<A.length-1; i++){
      isOdd = true;
      j = i;
      while(j < A.length-1 && j >=0){
        if(isOdd){
          j = oddJumpReachablity[j];
        } else {
          j = evenJumpReachablity[j];
        }
        isOdd = !isOdd;
      }
      if(j == A.length){
        count++;
      }

    }

    return count;

  }

  // get minimum smallest index from i to j with minimum value k
  private int getSmallestGreaterThanK(int A[], int k, int from, int to){
    int idx = -1, min = k;
    for(int i = from; i <=to; i++){
      if(idx == -1 && A[i] == min){
        return i;
      }
      if(A[i] >= k && (idx == -1 || A[i] < min)){
        idx = i;
        min = A[i];
      }
    }
    return idx;
  }

  // get minimum largest from i to j with maximum value k
  private int getLargestSmallerThanK(int A[], int k, int from, int to){
    int idx = -1, max = k;
    for(int i = from; i <= to; i++){
      if(idx == -1 && A[i] == max){
        return i;
      }
      if(A[i] <= k && (idx == -1 || A[i] > max)){
        idx = i;
        max = A[i];
      }
    }
    return idx;
  }

  public static void main(String[] args) {
    EvenOddJump eo = new EvenOddJump();
    System.out.println(eo.oddEvenJumps(new int[]{10,13,12,14,15}));
  }
}
