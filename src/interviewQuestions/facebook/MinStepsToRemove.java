package interviewQuestions.facebook;

// Ref: https://leetcode.com/discuss/interview-question/349687/Facebook-or-Onsite-or-Min-steps-to-remove-elements
public class MinStepsToRemove {

  static int minStepsTpRemove(int a[]){
    if(a.length <2){
      return 0;
    }

    int max = 0, currMax = 0;
    for(int i = 0, j = 1; j<a.length;){
        if(a[i] > a[j]){
          i = j;
          j++;
          currMax = 0;
        } else {
          currMax++;
          j++;
          while(j<a.length && a[j] > a[j-1])
            j++;

        }
      max = Math.max(currMax, max);
    }
    return max;
  }
  public static void main(String[] args) {
    System.out.println(minStepsTpRemove(new int[]{6,3,2,8,9,5,4,3,1,8,9}));
  }
}
