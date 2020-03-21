package tree;

import java.util.ArrayList;
import java.util.HashMap;

public class TraversalSet2 {
  int preIdx = 0;
  int maxLevel = -1;

  // print post order given pre and in order
  void printPost(int in[], int pre[], int s, int e, HashMap<Integer,Integer> hm){
    if(s>e){
      return;
    }

    int m = hm.get(pre[preIdx++]);

    printPost(in,pre,s, m-1,hm);
    printPost(in,pre,m+1, e,hm);
    System.out.println(in[m]);

  }

  public HashMap<Integer, Integer> createMap(int A[]){
    HashMap<Integer,Integer> hm = new HashMap<>();
    for(int i =0; i<A.length;i++){
      hm.put(A[i], i);
    }
    return hm;
  }


  public void printLeftView(TreeNode r, int l){
    if(r == null){
      return;
    }
    if(l> maxLevel) {
      System.out.println(r.data);
      maxLevel = l;
    }

    if(r.left != null){
      printLeftView(r.left, l+1);
    }

    if (r.right != null){
      printLeftView(r.right, l+1);
    }
  }

  // Try this, my old solution looked hacky. This is clean
  public TreeNode removeNodesFromLessSumPath(TreeNode root, int k){
    if(root == null || root.data > k)
      return root;


    root.left = removeNodesFromLessSumPath(root.left, k-root.data);
    root.right = removeNodesFromLessSumPath(root.right, k-root.data);

    if(root.left == null && root.right == null && root.data < k){
      return null;
    }

    return root;

  }

  static void print(TreeNode root) {
    if (root != null)
    {
      print(root.left);
      System.out.print(root.data + " ");
      print(root.right);
    }
  }

  public TreeNode printRightNode(TreeNode root, int k){
    if(root == null){
      return null;
    }

    TreeNode temp;

    ArrayList<TreeNode> al = new ArrayList<>();
    al.add(root);
    al.add(null);


    while(al.size()>0){
      temp = al.remove(0);

      if(temp == null){
        continue;
      }

      if (temp.data == k){
        if(al.size()>0){
          TreeNode t = al.remove(0);
          return t;
        }
        return null;
      } else {
        if(temp.left!=null)
          al.add(temp.left);

        if(temp.right!=null)
          al.add(temp.right);
      }
    }

    return null;
  }

  // Good approach!! Did not thought of this one
  public void kDistanceFromLeaf(TreeNode root, int k, int path[], boolean visited[], int idx){
    if(root == null){
      return;
    }

    path[idx] = root.data;
    visited[idx]= false;

    if(root.left == null && root.right == null && idx-k>0 && visited[idx-k] == false){
      visited[idx-k] = true;
      System.out.println(path[idx-k]);
    }

    kDistanceFromLeaf(root.left, k, path, visited, idx+1);
    kDistanceFromLeaf(root.right, k, path, visited, idx+1);

  }

  public int kDistanceFromNode(TreeNode root, TreeNode target, int k){
    if(root == null || k < 0 ){
      return -1;
    }

    if (root == target){
      kDistanceFromRoot(root,k);
      return 0;
    }

    if(root.left == null && root.right == null){
      return -1;
    }

    int l = kDistanceFromNode(root.left, target,k);
    int r = kDistanceFromNode(root.right, target, k);

    if (l != -1){
      if(k == l+1){
        System.out.println(root.data);
        return  l+1;
      }

      if(k>l+1){
        kDistanceFromRoot(root.right,k-l-2);
      }

      return l+1;

    }

    if (r != -1){
      if( k == r+1){
        System.out.println(root.data);
        return  r+1;
      }

      if(k>r+1){
        kDistanceFromRoot(root.left,k-r-2);
      }

      return r+1;

    }

    return  -1;
  }

  private void kDistanceFromRoot(TreeNode root, int k){
    if(root == null){
      return;
    }

    if (k == 0){
      System.out.println(root.data);
      return;
    }

    kDistanceFromRoot(root.left, k-1);
    kDistanceFromRoot(root.right, k-1);
  }


  public void boudaryTraversal(TreeNode root) {
  }

  private void printLeftBoundary(TreeNode root){
    if(root == null)
      return;


    if(root.left != null){
      System.out.println(root.data);
      printLeftBoundary(root.left);
    } else if(root.right != null){
      System.out.println(root.data);
      printLeftBoundary(root.right);
    }

  }


  private void printLeavesBoundary(TreeNode root){
    if(root == null)
      return;

    printLeavesBoundary(root.left);
    if(root.left == null && root.right == null){
      System.out.println(root.data);
    }

    printLeavesBoundary(root.right);

  }

  private void printRightBoundary(TreeNode root){
    if(root == null)
      return;


    if(root.right != null){
      printRightBoundary(root.right);
      System.out.println(root.data);
    } else if(root.left != null){
      printRightBoundary(root.left);
      System.out.println(root.data);
    }
  }

  public static void main(String[] args) {
    TraversalSet2 ts = new TraversalSet2();
    TreeNode root = new TreeNode().createTree1("big");

    int in[] = { 4, 2, 5, 1, 3, 6 };
    int pre[] = { 1, 2, 4, 5, 3, 6 };
    ts.printPost(in,pre,0,in.length-1,  ts.createMap(in));

//    ts.printLeftView(root,0);
//    ts.removeNodesFromLessSumPath(root,20);
//    TreeNode ans = ts.printRightNode(root,12);
//    System.out.println(ans==null?"NULL":ans.data);

//    ts.kDistanceFromNode(root, root.left.left, 3);
  }

}
