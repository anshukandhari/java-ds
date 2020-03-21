package tree;

import java.util.Stack;

public class BSTTraversal {
  int max = 0, max2 = Integer.MAX_VALUE;
  int res;

  private class Info {
    int max;
    int min;
    int size;
    boolean isBst;

    private Info(TreeNode root){
      isBst = true;
      max = root.data;
      min = root.data;
      size = 1;
    }
  }

  public TreeNode lca(TreeNode root, int a, int b){
    if(root == null){
      return root;
    }

    if(root.data < a && root.data < b){
      return lca(root.right,a,b);
    }

    if(root.data > a &&  root.data > b ){
      return lca(root.left,a,b);
    }

    return root;
  }

  public boolean isBST(TreeNode root, int min, int max){
    if(root == null){
      return  true;
    }

    if(root.data > max || root.data < min){
      return false;
    }

    return isBST(root.left, min, root.data) && isBST(root.right, root.data, max);
  }


  public Info largestBSTInBT(TreeNode root){
    if(root == null){
      return null;
    }

    Info lh = largestBSTInBT(root.left);
    Info rh = largestBSTInBT(root.right);

    Info ans = new Info(root);

    if(lh != null){
      if(lh.isBst && lh.max < root.data){
        ans.size += lh.size;
      } else {
        ans.isBst = false;
        ans.size = 0;
      }
    }

    if(rh != null && ans.isBst){
      if(rh.isBst && rh.min > root.data){
        ans.size += rh.size;
      } else {
        ans.isBst = false;
        ans.size = 0;
      }
    }

    if(ans.isBst){
      max = Math.max(ans.size, max);
    }

    return ans;

  }

  public TreeNode removeBSTOutsideRange(TreeNode root, int min, int max){
    if(root == null){
      return root;
    }

    root.left = removeBSTOutsideRange(root.left,min,root.data);
    root.right = removeBSTOutsideRange(root.right,root.data,max);

    if(root.data <min){
      return root.right;
    }

    if(root.data > max){
      return root.left;
    }

    return root;

  }

  public void closestElement(TreeNode root, int k){
    if(root == null){
      return;
    }

    if(root.data > k){
      if(max >  root.data-k){
        max = root.data-k;
        res = root.data;
      }
      closestElement(root.left, k);
    } else if(root.data < k){
      if(max >  k-root.data){
        max = root.data-k;
        res = root.data;
      }
      closestElement(root.right, k);
    } else {
      max =0;
      res = root.data;
    }


  }


  public void sortedPrint2BST(TreeNode a, TreeNode b){
    TreeNode t1=a, t2=b;
    Stack<TreeNode> s1 = new Stack<>();
    Stack<TreeNode> s2 = new Stack<>();

    s1.push(t1);
    t1 = t1.left;
    s2.push(t2);
    t2 = t2.left;

    while(s1.size()>0 || t1 != null || s2.size() >0 || t2 != null){

      while(t1 != null){
        s1.push(t1);
        t1 = t1.left;
      }

      while(t2 != null){
        s2.push(t2);
        t2 = t2.left;
      }


      t1 = s1.size()>0?s1.pop(): null;
      t2 = s2.size()>0?s2.pop(): null;

      if(t1 == null){
        System.out.println(t2.data);
        t2 = t2.right;
      } else if(t2 == null){
        System.out.println(t1.data);
        t1 = t1.right;
      } else if(t1.data < t2.data){
        System.out.println(t1.data);
        t1 = t1.right;
      } else {
        System.out.println(t2.data);
        t2 = t2.right;
      }


    }

  }

  public static void main(String[] args) {
    BSTTraversal bstTraversal = new BSTTraversal();
//    TreeNode root = new TreeNode().createTree1("custom1");
//    bstTraversal.largetBSTInBT(root);
//    System.out.println(bstTraversal.max);
    TreeNode r1 = new TreeNode(2);
    r1.left = new TreeNode(1);
    r1.right = new TreeNode(13);

    TreeNode r2 = new TreeNode(5);
    r2.left = new TreeNode(4);
    r2.right = new TreeNode(6);

    bstTraversal.sortedPrint2BST(r1,r2);
    bstTraversal.sortedPrint2BST2(r1,r2);
  }

  public void sortedPrint2BST2(TreeNode a, TreeNode b){
    Stack<TreeNode> s1 = new Stack<>();
    Stack<TreeNode> s2 = new Stack<>();

    TreeNode p1 = a, p2  = b;

    while(!s1.empty() || !s2.empty() || p1 != null || p2 != null){
      while(p1 != null){
        s1.push(p1);
        p1 = p1.left;
      }

      while(p2 != null){
        s2.push(p2);
        p2 = p2.left;
      }

      if(!s1.empty() && !s2.empty()){
        if(s1.peek().data < s2.peek().data){
          System.out.println(s1.peek().data);
          p1 = s1.pop().right;
        } else {
          System.out.println(s2.peek().data);
          p2 = s2.pop().right;
        }
      } else if(s1.empty() || s2.empty()){
        if(s1.empty()){
          System.out.println(s2.peek().data);
          p2 = s2.pop().right;
        } else {
          System.out.println(s1.peek().data);
          p1 = s1.pop().right;
        }
      }

    }


  }




}
