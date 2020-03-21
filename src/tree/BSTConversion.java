package tree;

public class BSTConversion {
  int sum = 0;

  public int greaterSumTree(TreeNode root){
    if(root == null){
      return 0;
    }


    int rh = greaterSumTree(root.right);
    int temp = root.data;
    sum += rh;
    root.data = sum;
    sum += temp;
    return  greaterSumTree(root.left);
  }

  public void inOrder(TreeNode root){
    if (root != null){
      inOrder(root.left);
      System.out.println(root.data);
      inOrder(root.right);
    }
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(11);
    root.left = new TreeNode(2);
    root.right = new TreeNode(29);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(7);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(40);
    root.right.right.left = new TreeNode(35);

    BSTConversion bstConversion = new BSTConversion();
    bstConversion.greaterSumTree(root);

    bstConversion.inOrder(root);

  }

}
