package dynamicProgramming.lisPattern;

//https://www.interviewbit.com/problems/length-of-longest-subsequence/
public class LongestBitonicSubsequence {

  public static int longestSubsequenceLength(final int[] A) {
    if(A.length <2){
      return A.length;
    }

    int leftInc[] = new int[A.length];
    int rightDec[] = new int[A.length];
    int max = 0, temp;
    leftInc[0] = 0;
    rightDec[A.length-1] = 0;


    for(int i = 1; i< A.length; i++){
      for(int j = 0; j<i; j++){
        if(A[j]< A[i] && leftInc[j] + 1 > leftInc[i])
          leftInc[i] = leftInc[j] + 1;
      }
    }

    for(int i = A.length-2; i>=0; i--){
      for(int j = A.length-1; j>i; j--){
        if(A[j]< A[i] && rightDec[j] + 1 > rightDec[i])
          rightDec[i] = rightDec[j] + 1;
      }
    }


    for(int i = 1; i< A.length; i++){
      temp = 1 + leftInc[i] + rightDec[i];
      max = Math.max(max, temp);
    }

    return max;

  }

  public static void main(String[] args) {
    System.out.println(longestSubsequenceLength(new int[]{1, 11, 2, 10, 4, 5, 2, 1}));
  }
}
