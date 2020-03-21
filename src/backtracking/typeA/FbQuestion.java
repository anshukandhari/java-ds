package backtracking.typeA;

/**
 * Given a sorted array and a value K, find count of all subsets that satisfy the following condition:
 * Max of Subset + Min of Subset <= K
 */
public class FbQuestion {

  public int countConditionalSubset(int A[], int K){
    int ans = 0;

    // shift end to right
    for(int start = 0; start < A.length; start++){
      for(int end = start; end <A.length; end++){
        if(A[start] + A[end] <= K){
          if(end-start <= 1){
            ans += 1;
          } else {
            ans += Math.pow(2, end-start-1);
          }
        }
      }
    }
    return ans;

  }

  public static void main(String[] args) {
    FbQuestion fb = new FbQuestion();
    int a[] = {2};
    int ans = fb.countConditionalSubset(a, 5);
    System.out.println(ans);

  }

}
