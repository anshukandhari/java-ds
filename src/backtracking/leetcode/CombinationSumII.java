package backtracking.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
  public List<List<Integer>> combinationSum2(int[] a, int target) {
    Arrays.sort(a);
    List<List<Integer>> sol = new ArrayList();
    ArrayList<Integer> set = new ArrayList();
    combinationSumUtil(sol,set,a,target,0);
    return sol;

  }

  public void combinationSumUtil(List<List<Integer>> sol, ArrayList<Integer> set, int[] a, int target, int idx) {
    if(target == 0){
      sol.add(new ArrayList(set));
      return;
    }

    if(idx < a.length && target < a[idx]){
      return;
    }

    for(int i=idx; i<a.length; i++){
      if(i>idx && a[i]== a[i-1]){
        continue;
      }
      set.add(a[i]);
      combinationSumUtil(sol,set,a,target-a[i], i+1);
      set.remove(set.size()-1);
    }

  }

  public static void main(String[] args) {
    CombinationSumII cs = new CombinationSumII();
    cs.combinationSum2(new int[]{1,2,5}, 7);

  }
}
