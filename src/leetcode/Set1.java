package leetcode;

import java.util.HashMap;

public class Set1 {

  // Problem 862
  public int shortestSubarray(int[] A, int K) {
    HashMap<Integer, Integer> hm = new HashMap<>();
    int sum = 0;
    int sumArr[] = new int[A.length];
    boolean found = false;
    int ans = Integer.MAX_VALUE;
    int temp;

    for(int i=0; i<A.length; i++){
      if (A[i] == K){
        return 1;
      }

      sum+= A[i];
      if(sum ==K){
        if(!found){
          found = true;
          ans = i+1;
        } else {
          ans = Math.min(ans,i+1);
        }

      }

      sumArr[i]= sum;
      hm.put(sum,i);
    }

    for(int i=0; i<sumArr.length; i++){
      if(hm.containsKey(sumArr[i]-K)){
        temp = i-hm.get(sumArr[i]-K);
        if (temp < 0) {
          temp *= -1;
        }

        if(!found){
          found = true;
          ans = temp;
        } else {
          ans = Math.min(ans,temp);
        }

      }
    }

    if (found) {
      return ans;
    }

    return -1;
  }


}
