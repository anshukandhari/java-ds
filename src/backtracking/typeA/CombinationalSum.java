package backtracking.typeA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationalSum {
  private List<List<Integer>> solution;

  private List<Integer> curSolution;

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    solution = new ArrayList<>();
    curSolution = new ArrayList<Integer>();
    Arrays.sort(candidates);
    backTrack(candidates, target, 0);
    return solution;
  }

  private void backTrack(int[] candidates, int target, int lastIdx) {
    if (target == 0) {
      solution.add(new ArrayList<>(curSolution));
    }
    else if (target < 0) {
      return;
    }
    else {
      int i = lastIdx;
      while (i < candidates.length) {
        int candidate = candidates[i];
        curSolution.add(candidate);
        backTrack(candidates, target - candidate, i);
        curSolution.remove(curSolution.size() - 1);
        while (i < candidates.length && candidates[i] == candidate) {
          i++;
        }
      }
    }
  }


  public static void main(String[] args) {
    CombinationalSum cs = new CombinationalSum();
    int a[] = {2,3,6,7};

    cs.combinationSum(a,7);
  }

}
