package tree;

public class BST {

  TreeNode treeRoot;

  public TreeNode searchBST(TreeNode root, int data) {
    if (root==null || root.data==data){
      return root;
    }

    if (root.data > data){
      return searchBST(root.left, data);
    }

    return searchBST(root.right, data);
  }

  public void insert(int data){
    treeRoot = insertBSTUtil(treeRoot, data);
  }

  public TreeNode insertBSTUtil(TreeNode root, int data){
    if (root == null){
      return new TreeNode(data);
    }

    if (data > root.data){
      root.right = insertBSTUtil(root.right,data);
    }

    if (data < root.data){
      root.left = insertBSTUtil(root.left,data);
    }

    return root;
  }

  public void delete(int data) {
      treeRoot = deleteUtil(treeRoot, data);
  }

  private TreeNode deleteUtil(TreeNode root, int data){
    if (root == null){
      return root;
    }

    if (data > root.data){
      root.right = deleteUtil(root.right,data);
    }

    if (data < root.data){
      root.left = deleteUtil(root.left,data);
    }

    if(root.data == data){
      if(root.left == null){
        return root.right;
      }

      if(root.right == null){
        return  root.left;
      }

      TreeNode temp = findMax(root.left);
      root.data = temp.data;

      root.left =  deleteUtil(root.left,temp.data);

    }

    return root;
  }

  public TreeNode findMax(TreeNode root){
    if (root == null){
      return  root;
    }

    if (root.right == null){
      return  root;
    }

    return findMax(root.right);
  }

  public void inOrder(TreeNode root){
    if (root != null){
      inOrder(root.left);
      System.out.println(root.data);
      inOrder(root.right);
    }
  }

  public static void main(String[] args) {
    BST bst = new BST();
    bst.insert(6);
    bst.insert(4);
    bst.insert(5);
    bst.insert(8);
    bst.insert(7);
    bst.insert(3);
    bst.insert(2);
    bst.insert(9);
    bst.insert(1);
    bst.insert(10);



    bst.delete(3);
    bst.inOrder(bst.treeRoot);



  }

}
