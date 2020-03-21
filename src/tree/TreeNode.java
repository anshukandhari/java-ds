package tree;

public class TreeNode {
  public int data;
  public TreeNode left, right;

  public TreeNode createTree1(String type){
    TreeNode root = null;

    if (type == "small") {
      root = new TreeNode(1);
      root.left = new TreeNode(2);
      root.right = new TreeNode(3);
      root.left.left = new TreeNode(4);
      root.left.right = new TreeNode(5);
      root.right.right = new TreeNode(7);
      root.right.right.right = new TreeNode(9);
    }

    if (type == "big"){
  /*
            1
        /      \
       2        3
     /   \     /  \
    4     5   6    7
   / \    /       /
  8   9  12      10
     / \           \
    13  14         11
        /
       15
*/
      root = new TreeNode(1);
      root.left = new TreeNode(2);
      root.right = new TreeNode(3);
      root.left.left = new TreeNode(4);
      root.left.right = new TreeNode(5);
      root.right.left = new TreeNode(6);
      root.right.right = new TreeNode(7);
      root.left.left.left = new TreeNode(8);
      root.left.left.right = new TreeNode(9);
      root.left.right.left = new TreeNode(12);
      root.right.right.left = new TreeNode(10);
      root.right.right.left.right = new TreeNode(11);
      root.left.left.right.left = new TreeNode(13);
      root.left.left.right.right = new TreeNode(14);
      root.left.left.right.right.left = new TreeNode(15);

    }

    if(type == "custom1"){
      root = new TreeNode(50);
      root.left = new TreeNode(30);
      root.right = new TreeNode(60);
      root.left.left = new TreeNode(5);
      root.left.right = new TreeNode(20);
      root.right.left = new TreeNode(45);
      root.right.right = new TreeNode(70);
      root.right.right.left= new TreeNode(65);
      root.right.right.right = new TreeNode(80);
    }

    return root;

  }

  public TreeNode(int d){
    data = d;
  }

  public TreeNode(){

  }
}
