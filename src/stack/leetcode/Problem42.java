package stack.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class Problem42 {
  public int trap(int[] height) {
    int sol =0;
    int sum =0;
    int l = 0;
    int ss[] = stockSpan(height, height.length);
    System.out.println(Arrays.toString(ss));
    for (int i =0; i<ss.length;i++){
      if (ss[i] ==0){
        continue;
      } else {
        sum = height[i]*(ss[i]-1);
        l = ss[i];
        for(int j =1;j<l;j++){
          i++;
          sum = sum - height[i];
        }
        if (sum < 0){
          sum = 0;
        }
      }
      sol = sol + sum;
    }
    return sol;
  }


  private int[] stockSpan(int A[], int n){
    int sol[] = new int[n];
    Stack<Integer> s = new Stack<>();
    int j;

    for(int i=n-1; i>=0;i--){
      while(!(s.empty()) && A[i] > A[s.peek()]){
        s.pop();
      }

      if(s.empty()){
        j = i;
      } else {
        j = s.peek();
      }

      sol[i]=j-i;
      s.push(i);
    }
    return sol;
  }

  public int trap2(int[] h) {
    if(h.length <2)
      return 0;

    int maxL[] = new int[h.length];
    int maxR[] = new int[h.length];
    int sum = 0;

    maxL[0] = h[0];
    for(int i = 1; i< h.length ; i++){
      maxL[i] = Math.max(h[i], maxL[i-1]);
    }
    // {0,1,1,2,2,2,2,3,3,3,3,3}

    maxR[h.length-1] = h[h.length-1];
    for(int i = h.length-2; i>= 0 ; i--){
      maxL[i] = Math.max(h[i], maxL[i+1]);
    }
    // {1,2,2,2,3,3,3,3,3,3,3,3}

    for(int i = 0; i< h.length ; i++){
      sum += Math.min(maxL[i], maxR[i])-h[i];
    }
    // {0,0,1,}

    return sum;
  }

  public static void main(String[] args) {
    Problem42 p = new Problem42();
    int A[] = {0,1,0,2,1,0,1,3,2,1,2,1};
//    int A[] = {5,1,0,2,1,0,1,3,2,1,2,1};
    System.out.println(p.trap2(A));
  }


}



