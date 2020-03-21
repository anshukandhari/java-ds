package tree;

import java.util.LinkedList;
import java.util.Queue;

public class BSTConstruction {
  class RangeNode{
    TreeNode node;
    int min;
    int max;
    public RangeNode(TreeNode n, int min, int max){
      node = n;
      this.max = max;
      this.min = min;
    }
  }

  int idx = 0;


  public TreeNode bstFromPre(int pre[]){
    return bstFromPreUtil(pre, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  private TreeNode bstFromPreUtil(int pre[], int min, int max){
    if (idx > pre.length-1){
      return  null;
    }

    TreeNode curr = null;
    if(pre[idx]> min && pre[idx] <  max){
      curr = new TreeNode(pre[idx++]);

      curr.left = bstFromPreUtil(pre, min, curr.data);
      curr.right = bstFromPreUtil(pre, curr.data, max);

    }

    return curr;
  }

  public void inOrder(TreeNode root){
    if (root != null){
      inOrder(root.left);
      System.out.println(root.data);
      inOrder(root.right);
    }
  }

  //TODO: We can use a queue and create this also (similar the way we handled deserialing a tree). Check the bstFromLevelOrder2 function
  // following will take O(n^2) in worst case, we can do O(n) with above idea.
  private TreeNode bstFromLevelOrder(int level[]){
    if(idx >= level.length){
      return null;
    }

    TreeNode root = null;
    for(int i : level){
      root = bstFromLevelOrderUtil(root, level);
    }
    return root;
  }
  private TreeNode bstFromLevelOrderUtil(TreeNode root, int level[]) {
    if(root == null){
      return new TreeNode(level[idx++]);
    }
    if(root.data > level[idx]){
      root.left = bstFromLevelOrderUtil(root.left, level);
    }

    if(root.data < level[idx]){
      root.right = bstFromLevelOrderUtil(root.right, level);
    }

    return root;

  }

  private TreeNode bstFromLevelOrder2(int level[]){
    TreeNode root = null;
    if(level.length == 0){
      return root;
    }

    Queue<RangeNode> q = new LinkedList<>();
    root = new TreeNode(level[idx++]);


    q.offer(new RangeNode(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    RangeNode t;

    while(q.size() > 0 && idx < level.length){
      t = q.poll();

      if(level[idx] > t.min && level[idx] < t.node.data){
        t.node.left = new TreeNode(level[idx++]);
        q.offer(new RangeNode(t.node.left, t.min, t.node.data));
      }

      if(idx < level.length && level[idx] < t.max && level[idx] > t.node.data){
        t.node.right = new TreeNode(level[idx++]);
        q.offer(new RangeNode(t.node.right, t.node.data, t.max));
      }

    }

    return root;
  }

  private TreeNode bstFromSortedArray(int a[]){
    return bstFromSortedArrayUtil(a, 0, a.length-1);
  }

  private TreeNode bstFromSortedArrayUtil(int a[], int s, int e){
    if(s>e){
      return null;
    }

    if(s == e){
      return new TreeNode(a[s]);
    }

    int m = s+ (e-s)/2;
    TreeNode root = new TreeNode(a[m]);
    root.left = bstFromSortedArrayUtil(a, s, m-1);
    root.right = bstFromSortedArrayUtil(a,  m+1, e);
    return root;
  }

  public static void main(String[] args) {
    BSTConstruction bstc = new BSTConstruction();
    int level[] = {4,2,6,1,3,5,7};
    bstc.inOrder(bstc.bstFromLevelOrder2(level));

//    int pre[] = {10, 5, 1, 7, 40, 50};
//    bstc.inOrder(bstc.bstFromPre(pre));

//    int a[]= {1,2,3,4,5,6,7,8,9};
//    bstc.inOrder(bstc.bstFromSortedArray(a));
  }




}
