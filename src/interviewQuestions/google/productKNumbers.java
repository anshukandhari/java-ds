package interviewQuestions.google;

import java.util.Arrays;

public class productKNumbers {
  //https://leetcode.com/discuss/interview-question/336746/google-onsite-product-of-k-consecutive-numbers


  public static int[] productKConsecutiveNumber(int a[], int k){

    if(a.length < 2){
      return a;
    }

    int ans[] = new int[a.length];
    int prod = 1;
    int prodArr[] = new int[a.length];
    for(int j =0; j< a.length; j++){
      if(a[j] != 0){
        prod *= a[j];

      }
      prodArr[j] = prod;
    }

    int start = 0;
    for(int i =0; i< a.length; i++){
      if(a[i] == 0){
        start = i;
        while(i <k+start-1 && i < a.length){
          ans[i] = 0;
          i++;
        }
      } else {
        if(i < k){
          ans[i] = prodArr[i];
        } else {
          ans[i] = prodArr[i]/ prodArr[i-k];
        }
      }
    }


    return ans;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(productKConsecutiveNumber(new int[]{1, 3, 3, 6, 5, 7, 0, -3, 2, 5, 4, 6},1)));
  }

}
