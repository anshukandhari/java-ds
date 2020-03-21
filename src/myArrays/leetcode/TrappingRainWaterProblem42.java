package myArrays.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class TrappingRainWaterProblem42 {
  public static int trap(int[] h) {
    int lm[] = new int[h.length];
    int rm[] = new int[h.length];
    lm[0] = h[0];
    rm[h.length-1] = h[h.length-1];
    int ans[] =  new int[h.length], sum;


    for(int i = 1; i<h.length; i++){
      lm[i] = Math.max(lm[i-1], h[i]);
    }

    for(int i = h.length-2; i>=0; i--){
      rm[i] = Math.max(rm[i+1], h[i]);
    }


    for(int i = 0; i<h.length; i++){
      ans[i]= Math.min(lm[i],rm[i]) -h[i];
    }

    System.out.println(Arrays.toString(lm));
    System.out.println(Arrays.toString(rm));
    System.out.println(Arrays.toString(ans));

    return Arrays.stream(ans).sum();
  }

  public static void main(String[] args) {
    trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
  }

}
