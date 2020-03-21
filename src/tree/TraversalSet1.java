package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


public class TraversalSet1 {
  public class Height{
    int h;
  }

  public void inOrder(TreeNode root){
    if (root != null){
      inOrder(root.left);
      System.out.println(root.data);
      inOrder(root.right);
    }
  }

  public void preOrder(TreeNode root){
    if (root != null){
      System.out.println(root.data);
      preOrder(root.left);
      preOrder(root.right);
    }
  }

  public void postOrder(TreeNode root){
    if (root != null){
      postOrder(root.left);
      postOrder(root.right);
      System.out.println(root.data);
    }
  }

  public void iterativeInorder(TreeNode root) {
    if(root == null){
      return;
    }

    Stack<TreeNode> st  = new Stack<>();

    TreeNode temp;
    while(st.size() > 0 || root != null){
      while(root != null){
        st.push(root);
        root = root.left;
      }
      temp = st.pop();
      System.out.println(temp.data);
      root = temp.right;
    }
  }

  public void levelOrder(TreeNode root){
    if (root == null){
      return;
    }
    TreeNode temp;
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);

    while(q.size()>0){
      temp = q.poll();
      System.out.println(temp.data);
      if(temp.left != null){
        q.offer(temp.left);
      }
      if(temp.right != null){
        q.offer(temp.right);
      }
    }

  }

  // Print each level as a separate list inside the  parent List
  // Take a good look here, this BFS traversal is the bases of all BFS based problems
  public List<List<Integer>> individualLevelOrder(TreeNode root) {
    List<List<Integer>> sol = new ArrayList<>();
    ArrayList<Integer> level = new ArrayList<>();
    LinkedList<TreeNode> q = new LinkedList<>();

    if(root == null){
      return sol;
    }

    q.add(root);

    TreeNode curr;
    int levelNumber;
    while(q.size()>0){
      levelNumber = q.size();

      for(int i =0; i<levelNumber; i++){
        curr = q.removeFirst();

        if(curr.left != null){
          q.addLast(curr.left);
        }
        if(curr.right != null){
          q.addLast(curr.right);
        }
        level.add(curr.data);
      }

      sol.add(level);
    }
    return sol;
  }


  public boolean printAncestors(TreeNode root, int n) {
    if(root == null){
      return false;
    }

    if(root.data == n){
      return true;
    }

    if(printAncestors(root.left, n) || printAncestors(root.right, n)){
      System.out.println(root.data);
      return true;
    }

    return false;

  }

  public TreeNode lca(TreeNode root, int a, int b){
    if(root == null || root.data == a || root.data == b){
      return root;
    }

    TreeNode l = lca(root.left, a, b);
    TreeNode r = lca(root.right, a, b);

    if(l != null && r != null)
      return root;

    if(l != null)
      return l;

    return r;
  }

  public boolean isFoldable(TreeNode root){
    if (root == null){
      return  true;
    }
    return isFoldableUtil(root.left, root.right);
  }

  public boolean isFoldableUtil(TreeNode l, TreeNode r){
      if(l == null && r == null){
        return true;
      }

      if (l == null || r == null ){
        return  false;
      }

      return isFoldableUtil(l.left, r.right) && isFoldableUtil(l.right, r.left);
  }


  public boolean isSubtree(TreeNode m, TreeNode s){
    if(s == null){
      return true;
    }

    if(m == null){
      return false;
    }

    if(isIdentical(m,s)){
      return true;
    }

    return isSubtree(m.left, s) || isSubtree(m.right,s);
  }

  private boolean isIdentical(TreeNode a, TreeNode b){
    if(a == null && b == null){
      return true;
    }

    if (a == null || b == null) {
      return  false;
    }

    if ((a.data == b.data) &&  isIdentical(a.left, b.left) && isIdentical(a.right, b.right)){
      return  true;
    }
    return false;
  }

  public int diameter2(TreeNode r){
    Height h = new Height();
    return diameterUtil2(r,h); //
  }

  private int diameterUtil2(TreeNode r, Height height){
    if(r == null){
      return 0;
    }

    Height lh = new Height();
    Height rh = new Height();

    int d = Math.max(diameterUtil2(r.left, lh), diameterUtil2(r.right, rh));

    height.h = Math.max(lh.h,rh.h)+1;

    return Math.max(lh.h+rh.h, d);

  }

  int ans;
  public int diameterOfBinaryTree(TreeNode root) {
    diameterUtil(root);
    return ans;
  }


  private int diameterUtil(TreeNode root){
    if(root == null)
      return 0;

    int l = diameterUtil(root.left);
    int r = diameterUtil(root.right);

    ans = Math.max(ans, l+r);

    return Math.max(l,r) + 1;
  }

  private int getHeight(TreeNode r){
    if(r == null){
      return 0;
    }

    return 1+ Math.max(getHeight(r.left), getHeight(r.right));
  }


  public static void main(String[] args) {

    TraversalSet1 t = new TraversalSet1();

    TreeNode root = new TreeNode().createTree1("small");
//    t.preOrder(root);

//    System.out.println(t.getHeight(root));

//    System.out.println(t.diameter(root));

//    System.out.println("Inorder traversal is: ");
//    t.inOrder(root);

    System.out.println("Iterative Inorder traversal is: ");
    t.iterativeInorder(root);

//    System.out.println("PreOrder traversal is: ");
//    t.preOrder(root);
//
//
//    System.out.println("PostOrder traversal is: ");
//    t.postOrder(root);
//
//
//    System.out.println("LevelOrder traversal is: ");
//    t.levelOrder(root);
//    t.individualLevelOrder(root);


    // t.printAncestors(root,7);
    // System.out.println(t.lca(root,7,5).data);



  }

}
