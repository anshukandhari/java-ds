package tree.leetcode;

import com.sun.tools.javah.Gen;
import java.util.LinkedList;
import java.util.List;
import tree.TreeNode;

public class GenerateBST {

  public List<TreeNode> generateTrees(int n) {
    return generateSubtrees(1, n);
  }

  private List<TreeNode> generateSubtrees(int s, int e) {
    List<TreeNode> res = new LinkedList<>();
    if (s > e) {
      res.add(null); // empty tree
      return res;
    }

    for (int i = s; i <= e; ++i) {
      List<TreeNode> leftSubtrees = generateSubtrees(s, i - 1);
      List<TreeNode> rightSubtrees = generateSubtrees(i + 1, e);

      for (TreeNode left : leftSubtrees) {
        for (TreeNode right : rightSubtrees) {
          TreeNode root = new TreeNode(i);
          root.left = left;
          root.right = right;
          res.add(root);
        }
      }
    }
    return res;
  }

  public static void main(String[] args) {
    GenerateBST b = new GenerateBST();
    b.generateTrees(2);
  }

}
