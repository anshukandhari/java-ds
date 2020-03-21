package backtracking.typeA;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {

  public List<List<Integer>> powerSet(int[] nums) {
    int l = nums.length;
    if(l==0){
      return new ArrayList<>();
    }
    int n = (int)Math.pow(2,l);
    List<List<Integer>> sol = new ArrayList<>();

    for(int i=0;i<n;i++){
      List<Integer> temp = new ArrayList<>();
      for(int j =0;j<l;j++){
        if((i & 1<<j) > 0){
          temp.add(nums[j]);
        }
      }
      sol.add(temp);
    }
    return sol;
  }

}
