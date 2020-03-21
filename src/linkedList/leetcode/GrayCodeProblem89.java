package linkedList.leetcode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GrayCodeProblem89 {
  public List<Integer> grayCode(int n) {
    List<Integer> sol = new LinkedList<>();
    LinkedList<String> l = new LinkedList<>();
    LinkedList<String> temp = new LinkedList<>();

    if(n==0){
      sol.add(0);
      return sol;
    }

    temp.add("0");
    temp.add("1");

    String t;
    int size;
    for(int i =2; i<= n; i++){
      size = temp.size();
      while(size>0){
        t = temp.removeFirst();
        temp.add(t);
        l.add("0"+t);
        size--;
      }
      size = temp.size();
      while(size>0){
        t = temp.removeLast();
        temp.addFirst(t);
        l.add("1"+t);
        size--;
      }

      temp = l;
      l = new LinkedList<>();
    }

    l = temp;

    Iterator<String> itr = l.iterator();
    while(itr.hasNext()){
      t = itr.next();
      sol.add(convertToNumber(t));
    }

    return sol;
  }

  private int convertToNumber(String s){
    int sum = 0;

    for(int i = s.length()-1; i>=0 ;i--){
      if(s.charAt(i) =='1'){
        sum+= Math.pow(2,i);
      }
    }
    return sum;
  }

  public static void main(String[] args) {
    GrayCodeProblem89 gc = new GrayCodeProblem89();
    gc.grayCode(2);
  }

}
