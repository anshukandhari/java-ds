package tree.leetcode;

import java.util.LinkedList;
import java.util.Queue;
import tree.TreeNode;

public class SerializingDeSerializing {
  public String serialize(TreeNode root) {
    StringBuffer sb = new StringBuffer();
    TreeNode temp;
    LinkedList<TreeNode> q = new LinkedList<>();

    if(root == null){
      return "";
    }

    q.offer(root);
    sb.append(root.data + ",");

    while(!q.isEmpty()){
      temp = q.poll();


      if(temp.left == null){
        sb.append("null,");
      } else {
        q.offer(temp.left);
        sb.append(temp.left.data + ",");
      }

      if(temp.right == null){
        sb.append("null,");
      } else {
        q.offer(temp.right);
        sb.append(temp.right.data + ",");
      }

    }

    return sb.toString().substring(0,sb.length()-1);

  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    if(data.length() == 0){
      return null;
    }

    String s[] = data.split(",");
    if(s.length == 1){
      return new TreeNode(Integer.valueOf(s[0]));
    }

    LinkedList<TreeNode> q = new LinkedList<>();
    TreeNode root = new TreeNode(Integer.valueOf(s[0]));
    q.offer(root);


    for (int i = 1; i < s.length; i++) {
      TreeNode parent = q.poll();
      if (!s[i].equals("null")) {
        TreeNode left = new TreeNode(Integer.parseInt(s[i]));
        parent.left = left;
        q.add(left);
      }
      if (i<s.length-1 && !s[++i].equals("null")) {
        TreeNode right = new TreeNode(Integer.parseInt(s[i]));
        parent.right = right;
        q.add(right);
      }
    }

    return root;

  }

  public static void main(String[] args) {
    SerializingDeSerializing sds = new SerializingDeSerializing();
    TreeNode root = new TreeNode().createTree1("small");

    System.out.println(sds.serialize(root));
    System.out.println(sds.serialize2(root));

  }


  public String serialize2(TreeNode root) {
    StringBuilder sb = new StringBuilder();
    Queue<TreeNode> q = new LinkedList<>();

    TreeNode curr;
    q.add(root);
    sb.append(root.data + ",");
    while(!q.isEmpty()){
      curr = q.poll();

      if(curr.left == null){
        sb.append("null,");
      } else {
        q.offer(curr.left);
        sb.append(curr.left.data + ",");
      }

      if(curr.right == null){
        sb.append("null,");
      } else {
        sb.append(curr.right.data + ",");
        q.offer(curr.right);
      }

    }

    if(sb.length() >0)
      return sb.toString().substring(0,sb.length()-1);

    return sb.toString();

  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize2(String data) {
    if(data.length() == 0){
      return null;
    }
    Queue<TreeNode> q = new LinkedList<>();
    int idx = 0;
    TreeNode curr, root;

    String nodeArr[] = data.split(",");
    root = new TreeNode(Integer.valueOf(nodeArr[idx++]));
    q.offer(root);

    while(!q.isEmpty()){
      curr = q.poll();

      if(idx == nodeArr.length)
        break;


      if(nodeArr[idx].equals("null")){
        curr.left = null;
      } else {
        curr.left = new TreeNode(Integer.valueOf(nodeArr[idx]));
        q.offer(curr.left);
      }
      idx++;

      if(idx == nodeArr.length)
        break;

      if(nodeArr[idx].equals("null")){
        curr.right = null;
      } else {
        curr.right = new TreeNode(Integer.valueOf(nodeArr[idx]));
        q.offer(curr.right);
      }
      idx++;

    }

    return root;
  }

}
