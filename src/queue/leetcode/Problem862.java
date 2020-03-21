package queue.leetcode;

public class Problem862 {
  public int shortestSubarray(int[] A, int K) {


    int start = 0;
    int sumArr[] = new int[A.length];
    int sum = 0;
    boolean found = false;
    int ans = Integer.MAX_VALUE;
    int temp;

    for(int i=0; i<A.length; i++){
      if (A[i] >= K){
        return 1;
      }

      sum+= A[i];
      if (sum <=0) {
        sum = 0;
      }

      sumArr[i] = sum;
    }

    for(int i=1; i<A.length; i++){
      sum = sumArr[i];
      if(sum < sumArr[i-1]){
        start = i;
      }
      if (sum >=K){
        if(!found){
          found = true;
        }

        temp = start;
        while (temp<i){
          if (sum-sumArr[temp] >=K){
            sum -= sumArr[temp];
            temp++;
          } else {
            break;
          }
        }
        start = temp;
        ans = Math.min(ans,i-start+1);
      }

    }


    if (found) {
      return ans;
    }

    return -1;
  }

  public static void main(String[] args) {
    Problem862 sw = new Problem862();
    int A[] ={1,2,3,-5,6,7};
    // [0,1,3,6,1,7,14]
    // pq = 0,3,4,
    System.out.println(sw.shortestSubarray(A,14));



  }
}
