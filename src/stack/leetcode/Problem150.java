package stack.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

public class Problem150 {
  public int evalRPN(String[] tokens) {
    LinkedList<Integer> st = new LinkedList<>();
    HashSet<String> hs = new HashSet<>(Arrays.asList("*","/","-", "+"));

    int v1, v2;
    for(String str : tokens){
      if(hs.contains(str)){
        v2 = st.pop();
        v1 = st.pop();
        st.add(evaluate(v1,v2,str));
      } else {
        st.add(Integer.valueOf(str));
      }
    }

    return st.pop();
  }

  private int evaluate(int v1, int v2, String str){
    if(str.equals("/")){
      return v1/v2;
    }
    if(str.equals("*")){
      return v1*v2;
    }
    if(str.equals("+")){
      return v1+v2;
    }

    return v1-v2;

  }

  public static void main(String[] args) {
    Problem150 lc = new Problem150();
    System.out.println(lc.evalRPN(new String[]{"0","3","/"}));
  }

}
