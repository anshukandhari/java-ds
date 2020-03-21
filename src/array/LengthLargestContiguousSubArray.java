package array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

// Reference: https://www.geeksforgeeks.org/length-largest-subarray-contiguous-elements-set-1/
//TODO: Not done yet
public class LengthLargestContiguousSubArray {
  public static void main(String[] args) {
    int arr[] = {1, 56, 58, 57, 90, 92, 94, 93, 91, 45};
    System.out.println("Length of the largest subArray is " + lengthLargestContiguousSubArray(arr));
  }

  private static int lengthLargestContiguousSubArray(int[] A) {
    Stack<Integer> stack = new Stack<>();
    int min = Integer.MIN_VALUE, max = Integer.MAX_VALUE, ans = 0, currLength = 0;

    for(int i = 0 ; i < A.length; i++){

      min = A[i]-1;
      max = A[i]+1;


      if(stack.empty()){
        stack.push(A[i]);
        currLength = 1;
      } else {
        while(stack.peek() == min || stack.peek() == max){
          if(stack.peek() == min){
            min--;
          } else {
            max++;
          }
          currLength += 1;
          stack.pop();
        }

      }

      ans = Math.max(ans, currLength);

    }

    return ans;
  }
}
