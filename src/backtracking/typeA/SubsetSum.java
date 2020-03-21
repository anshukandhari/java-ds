package backtracking.typeA;

import java.util.ArrayList;
import java.util.Arrays;

public class SubsetSum {

  public void subsetSum(int A[], int target){
    Arrays.sort(A);
    int set[] = new int[A.length];
    subsetSumUtil(A, set,0,0,0,target);

  }

  public void subsetSumUtil(int A[], int set[], int idx, int setIdx, int sum, int target){
    if(sum > target){
      return;
    }

    for(int i = idx; i<A.length;i++){
      set[setIdx++] = A[i];
      sum+= A[i];
      if(sum == target){
        for(int j =0; j< setIdx; j++){
          System.out.print(set[j] + " ");
        }
        System.out.println();
      }
      subsetSumUtil(A,set,idx+1,setIdx,sum, target);
      sum-=A[i];
      setIdx--;
      subsetSumUtil(A,set,idx+1,setIdx, sum, target);
    }
  }


// We cant get the subsets here, only we can get the possibility of whether any subset can form the given sum
  private static boolean subsetSumDP(int A[], int sum){

    boolean sol[] = new boolean[sum+1];

    ArrayList<Integer> al = new ArrayList<>();

    for(int i = 0; i<A.length;i++){
      for(int j =0; j<sol.length;j++){
        if(sol[j] && j+A[i] <= sum){
          al.add(j+A[i]);
        }
      }
      if(A[i]<=sum){
        al.add(A[i]);
      }

      al.forEach(x -> sol[x]= true);
      al.clear();
    }

    return sol[sum];
  }

  public static void main(String[] args) {
    int A[]= {10, 7, 5, 12};
    SubsetSum ss = new SubsetSum();
    ss.subsetSum(A,12);
  }

}
