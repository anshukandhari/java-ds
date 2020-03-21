package tree.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import tree.TreeNode;

public class levelOrder {
  public List<List<Integer>> levelOrder(TreeNode root) {
    if(root == null){
      return null;
    }
    List<List<Integer>> sol = new ArrayList<>();
    ArrayList<Integer> level = new ArrayList<>();
    LinkedList<TreeNode> ll = new LinkedList<>();
    ll.add(root);
    ll.add(null);

    TreeNode curr;

    while(ll.size()>0){
      curr = ll.removeFirst();
      if(curr == null) {
        sol.add(level);
        if(ll.size()>0){
          level = new ArrayList<>();
          ll.add(null);
        }
      } else {
        if(curr.left != null){
          ll.add(curr.left);
        }
        if(curr.right != null){
          ll.add(curr.right);
        }
        level.add(curr.data);
      }

    }
    return sol;
  }

  public static void main(String[] args) {
    levelOrder lo = new levelOrder();
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);

    lo.levelOrder(root);

  }

}
