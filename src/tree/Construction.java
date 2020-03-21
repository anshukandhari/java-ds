package tree;

import java.util.HashMap;
import java.util.TreeSet;

public class Construction {
  int idx = 0;

  public TreeNode constructFromPreIn(int in[], int pre[], int s, int e){
    if(s>e){
      return null;
    }

    TreeNode curr = new TreeNode(pre[idx]);

    int m = searchInArray(in,pre[idx++]);

    curr.left = constructFromPreIn(in,pre,s,m-1);
    curr.right = constructFromPreIn(in,pre,m+1,e);

    return curr;

  }

  private int searchInArray(int A[], int n){
    for(int i=0; i<A.length; i++){
      if(A[i] == n){
        return i;
      }
    }
    return -1;
  }

  public TreeNode constructFullTreeFromPreSpecial(int pre[], int leaf[]){
    if(pre.length == 0){
      return  null;
    }

    TreeNode curr = new TreeNode(pre[idx++]);
    if(leaf[idx-1] == 0){
      curr.left = constructFullTreeFromPreSpecial(pre,leaf);
      curr.right = constructFullTreeFromPreSpecial(pre,leaf);
    }

    return curr;
  }


  //Did it on my own!! Awesome work
  public TreeNode constructFullTreeFromPrePost(int pre[], int post[], int s, int e){
    if(s>e || idx == pre.length){
      return null;
    }

    TreeNode n = new TreeNode(pre[idx++]);

    if(s == e){
      return n;
    }

    int m = searchInArray(post, pre[idx]);

    if(m>=s && m<=e){
      n.left = constructFullTreeFromPrePost(pre, post,s,m);
      n.right = constructFullTreeFromPrePost(pre, post,m+1,e-1);

    }

    return n;

  }


  //TODO:
  // Great Question|| Do practice
  public TreeNode constructTreeFromInAndLevel(int in[], int level[]) {
    HashMap<Integer, Integer> hm = new HashMap<>();
    for(int i = 0; i< in.length; i++){
      hm.put(in[i],i);
    }

    return constructTreeFromInAndLevelUtil(in, level, 0, in.length-1, hm);
  }

  public TreeNode constructTreeFromInAndLevelUtil(int in[], int level[], int s, int e, HashMap<Integer, Integer> hm){
    if(s>e){
      return null;
    }

    TreeNode curr = null;

    if(s == e){
      curr = new TreeNode(in[s]);
      return curr;
    }


    int m = -1;
    for(int v : level){
      m = hm.get(v);
      m = (m>=s && m<=e) ? m: -1;
      if(m != -1){
        curr = new TreeNode(v);
        break;
      }
    }


    curr.left = constructTreeFromInAndLevelUtil(in,level, s,m-1, hm);
    curr.right = constructTreeFromInAndLevelUtil(in,level, m+1,e, hm);

    return curr;

  }


  static void print(TreeNode root) {
    if (root != null) {
      print(root.left);
      System.out.print(root.data + " ");
      print(root.right);
    }
  }

  public static void main(String[] args) {
    Construction cnstr = new Construction();


   /* int in[] = { 4, 2, 5, 1, 3, 6 };
    int pre[] = { 1, 2, 4, 5, 3, 6 };

    print(cnstr.constructFromPreIn(in,pre,0,in.length-1));*/


     /*
            1
        /      \
       2        3
     /   \     /  \
    4     5   6    7
   / \
  8   9
     / \
    13  14


      */

    int pre[] = { 1,2,4,8,9,13,14,5,3,6,7};
    int post[] = { 8,13,14,9,4,5,2,6,7,3,1};
//    int leaf[] = {0,0,0,1,0,1,1,1,0,1,1};
//    print(cnstr.constructFullTreeFromPreSpecial(pre,leaf));



    int in[] = {4, 8, 10, 12, 14, 20, 22};
    int level[] ={20, 8, 22, 4, 12, 10, 14};

//    print(cnstr.constructTreeFromInAndLevel(in,level));
//    print(cnstr.constructFullTreeFromPrePost(pre,post, 0, post.length-1));
    print(cnstr.constructFullTreeFromPrePost(pre,post, 0, post.length-1));

  }



}
