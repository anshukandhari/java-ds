package myArrays.leetcode;

// TODO: NOT DONE
public class Problem862 {
  public int shortestSubarray(int[] A, int K) {
    int sum = 0, start = 0, end = 0;
    int minLength = Integer.MAX_VALUE;

    while (end < A.length) {
      sum += A[end];
      if (sum < 0) {
        sum = 0;
        start = end + 1;
      }
      while (sum >= K) {
        minLength = Math.min(minLength, end - start + 1);

        sum -= A[start];
        start++;
      }
      end++;
    }

    return minLength > A.length ? -1 : minLength;
  }

  public static void main(String[] args) {
    Problem862 lc = new Problem862();
    lc.shortestSubarray(new int[]{84,-37,32,40,95},167);
  }

}
