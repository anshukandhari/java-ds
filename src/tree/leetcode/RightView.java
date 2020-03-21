package tree.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import tree.TreeNode;

public class RightView {

  public List<Integer> rightSideView(TreeNode root) {
    int solArr[] = new int[height(root)];
    rightSideViewUtil(root, solArr, 0);
    ArrayList<Integer> sol = new ArrayList();
//    sol.addAll(Arrays.asList(solArr));
    return sol;
  }

  private void rightSideViewUtil(TreeNode root, int a[], int idx){
    if(root == null){
      return;
    }

    if(a[idx] == 0){
      a[idx] = root.data;
    }

    rightSideViewUtil(root.right,a, idx+1);
    rightSideViewUtil(root.left,a, idx+1);
  }

  private int height(TreeNode root){
    if(root == null){
      return 0;
    }
    return 1+ Math.max(height(root.left), height(root.right));
  }

}
