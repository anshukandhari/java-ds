package myArrays;

import java.util.Arrays;

public class Set1 {
  public static int threeSumClosest(int[] a, int target) {
    Arrays.sort(a);
    int sol = Integer.MAX_VALUE;

    int j,k,sum;
    for(int i =0; i<a.length-2;i++){
      j = i+1;
      k = a.length-1;

      while(j<k){
        sum = a[i]+a[j]+a[k];
        if(Math.abs(target-sum)<sol){
          sol = Math.abs(target-sum);
        }

        if(sum < target){
          j++;
        }

        if(sum>target){
          k--;
        }

        if (sum == target){
          return 0;
        }
      }
    }


    return sol;

  }

  public static void main(String[] args) {
    int a[] = {-1, 2, 1, -4};
    threeSumClosest(a,1);
  }

}
