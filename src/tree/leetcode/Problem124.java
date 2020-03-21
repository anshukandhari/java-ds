package tree.leetcode;

import tree.TreeNode;

// Max Path Sum
public class Problem124 {
  int m = Integer.MIN_VALUE;

  public int maxPathSum(TreeNode root) {
    int t = maxPathSumUtil(root);
    return Math.max(t, m);
  }

  public int maxPathSumUtil(TreeNode root) {

    if(root == null){
      return -100000;
    }

    int l = maxPathSumUtil(root.left);
    int r = maxPathSumUtil(root.right);


    // return root | root + l | root + r | root + l + r
    // m = max of above return/l/r


    int max = Math.max(l,r);
    max = Math.max(root.data, max+root.data);
    max = Math.max(max, l+r+root.data);
    m = Math.max(m, Math.max(l,r));
    m = Math.max(m, max);
    return  max;



  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(4);
    root.right = new TreeNode(8);
    root.left.left = new TreeNode(11);
    root.right.left = new TreeNode(13);
    root.right.right = new TreeNode(14);
    root.left.left.left = new TreeNode(7);
    root.left.left.right = new TreeNode(2);
    root.right.left.right = new TreeNode(1);

    Problem124 lc = new Problem124();
    System.out.println(lc.maxPathSum(root));

  }

}
