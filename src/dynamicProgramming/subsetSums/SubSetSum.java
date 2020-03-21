package dynamicProgramming.subsetSums;

public class SubSetSum {
  static boolean isSubsetSum(int set[], int sum){
    boolean m[][] =new boolean[set.length+1][sum+1];
    for (int i = 0; i<=set.length; i++){
      m[i][0] = true;
    }

    for (int i = 1; i<=set.length; i++){
      for (int j = 1; j <= sum ; j++){
        if(set[i-1]<=j){
          m[i][j] = m[i-1][j] || m[i-1][j-set[i-1]];
        } else {
        m[i][j] = m[i-1][j];
        }
      }
    }
    return m[set.length][sum];
  }


  public static void main (String args[]) {
    int set[] = {3, 34, 4, 12, 5, 2};
    int sum = 13;
    if (isSubsetSum(set,sum) == true) {
      System.out.println("Found a subset"
          + " with given sum");

    } else {
      System.out.println("No subset with"
          + " given sum");
    }
  }

}
