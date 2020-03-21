package array;

public class ShortestSubarrayLC862 {
  public int shortestSubarray(int[] A, int K) {
    int start = 0, end = 0, n = A.length;
    int mw = n+1, sum = 0;

    while(end<n){
      while(end<n && sum < K){
        if(sum <0){
          sum = 0;
          start = end;
        }
        sum += A[end++];
      }


      while(start<n && (sum>=K || A[start] <0)){
        mw = Math.min(mw, end-start);
        sum -= A[start++];
      }
    }

    return mw==n+1?-1:mw;

  }

  public static void main(String[] args) {
    ShortestSubarrayLC862 lc = new ShortestSubarrayLC862();
    int a[] = {-34,37,51,3,-12,-50,51,100,-47};//,99,34,14,-13,89,31,-14,-44,23,-38,6};
    System.out.println(lc.shortestSubarray(a,151));
  }

}
