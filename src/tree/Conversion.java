package tree;

public class Conversion {

  TreeNode head, prev;
  public TreeNode BT2DLL(TreeNode root){
    BT2DLLUtil(root);
    return head;
  }



  public void BT2DLLUtil(TreeNode root){
    if(root != null){
      BT2DLLUtil(root.left);

      if(prev == null){
        head = root;
      } else {
        prev.right = root;
        root.left = prev;
      }
      prev = root;


      BT2DLLUtil(root.right);
    }
  }


  public static void main(String[] args) {
    TreeNode root = new TreeNode().createTree1("small");
    Conversion c = new Conversion();
    TreeNode head = c.BT2DLL(root);
    while (head != null) {
      System.out.println(head.data);
      head = head.right;
    }
  }


}
