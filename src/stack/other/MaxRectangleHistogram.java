package stack.other;

import java.util.Arrays;
import java.util.Stack;


public class MaxRectangleHistogram {
  // Approach 1:  Using Spans
  public int largestRectangleArea(int[] h) {
    if(h.length == 0 ){
      return 0;
    }

    if(h.length == 1 ){
      return h[0];
    }

    int leftSpan[] = leftSpan(h, h.length);

    int rightSpan[] = rightSpan(h, h.length);
    System.out.println(Arrays.toString(leftSpan));
    System.out.println(Arrays.toString(rightSpan));

    int max = 0, t;
    for(int i = 0; i< h.length; i++){
      t = (leftSpan[i]+ rightSpan[i] + 1) * h[i];
      max = Math.max(max, t);
    }

    return max;

  }



  private int[] leftSpan(int A[], int n){
    int sol[] = new int[n];
    Stack<Integer> s = new Stack<>();
    int j;

    for(int i=0; i<n;i++){
      while(!(s.empty()) && A[i] <= A[s.peek()]){
        s.pop();
      }

      if(s.empty()){
        j = -1;
      } else {
        j = s.peek();
      }

      sol[i]=i-j-1;
      s.push(i);
    }

    return sol;
  }

  private int[] rightSpan(int A[], int n){
    int sol[] = new int[n];
    Stack<Integer> s = new Stack<>();
    int j;

    for(int i=n-1; i>=0;i--){
      while(!(s.empty()) && A[i] <= A[s.peek()]){
        s.pop();
      }

      if(s.empty()){
        j = n;
      } else {
        j = s.peek();
      }

      sol[i]=j-i-1;
      s.push(i);
    }

    return sol;
  }

  // Approach 2:  Using next Smaller & previous smaller
  public int largestRectangleArea2(int[] h) {
    if(h.length == 0 ){
      return 0;
    }

    if(h.length == 1 ){
      return h[0];
    }

    int previousSmaller[] = prevSmaller(h, h.length);

    int nextSmaller[] = nextSmaller(h, h.length);
    System.out.println(Arrays.toString(previousSmaller));
    System.out.println(Arrays.toString(nextSmaller));

    int max = 0, t;
    for(int i = 0; i< h.length; i++){
      t = (nextSmaller[i] - previousSmaller[i] - 1) * h[i];
      max = Math.max(max, t);
    }

    return max;

  }



  private int[] nextSmaller(int A[], int n){
    int sol[] = new int[n];
    Arrays.fill(sol, n);
    Stack<Integer> st = new Stack<>();

    for(int i = 0; i<n; i++){
      if(st.empty()){
        st.push(i);
        continue;
      }

      while(!st.empty() && A[i]<A[st.peek()]){
        sol[st.pop()] = i;
      }
      st.push(i);
    }

    return sol;
  }

  private int[] prevSmaller(int A[], int n){
    int sol[] = new int[n];
    Stack<Integer> st = new Stack<>();
    Arrays.fill(sol, -1);

    for(int i = n-1; i>=0; i--){
      if(st.empty()){
        st.push(i);
        continue;
      }

      while(!st.empty() && A[i]<A[st.peek()]){
        sol[st.pop()] = i;
      }
      st.push(i);
    }

    return sol;
  }

  // Approach 3: Most Efficient Great explanation https://www.youtube.com/watch?v=RVIh0snn4Qc
  public int largestRectangleArea3(int[] h) {
    Stack<Integer> st = new Stack<>();
    int maxArea = 0, currArea, t, i =0;

    while(i< h.length){
      if(st.empty() || h[i] >= h[st.peek()]){
        st.push(i++);
      } else {
        t= st.pop();

        if(st.empty()){
          currArea = h[t]*(i);
        } else {
          currArea = h[t]*(i-1-st.peek());
        }
        maxArea = Math.max(maxArea, currArea);
      }
    }


    while(!st.empty()){
      t= st.pop();
      if(st.empty()){
        currArea = h[t]*(i);
      } else {
        currArea = h[t]*(i-1-st.peek());
      }
      maxArea = Math.max(maxArea, currArea);
    }

    return maxArea;

  }


  public static void main(String[] args) {
    MaxRectangleHistogram mrh = new MaxRectangleHistogram();
    int a[] = {6, 2, 5, 4, 5, 1, 6 };
    System.out.println(mrh.largestRectangleArea(a));
    System.out.println(mrh.largestRectangleArea2(a));
//    mrh.largestRectangleArea3(new int[]{2,1,5,6,2,3});
  }
}
