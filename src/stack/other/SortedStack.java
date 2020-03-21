package stack.other;

import java.util.Stack;

public class SortedStack {

  static void sortedInsert(Stack<Integer> s, int x){
    if(s.isEmpty() || x > s.peek()){
      s.push(x);
      return;
    }

    int v = s.pop();
    sortedInsert(s, x);
    s.push(v);
  }

  static void sortStack(Stack<Integer> s){
    if(!s.isEmpty()){
      int v = s.pop();
      sortStack(s);

      sortedInsert(s,v);
    }
  }
}
