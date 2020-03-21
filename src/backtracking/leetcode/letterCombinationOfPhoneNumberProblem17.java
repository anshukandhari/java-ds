package backtracking.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class letterCombinationOfPhoneNumberProblem17 {
  public List<String> letterCombinations(String digits) {
    // Try to solve it in 2 ways
    // recursion and without recursion
    HashMap<Integer,String> hm = new HashMap<>();
    hm.put(2, "abc");
    hm.put(3, "def");
    hm.put(4, "ghi");
    hm.put(5, "jkl");
    hm.put(6, "mno");
    hm.put(7, "pqrs");
    hm.put(8, "tuv");
    hm.put(9, "wxyz");

    List<String> sol = new LinkedList<>();
    String strArr[] = new String[digits.length()];

    for(int i = 0 ;i < digits.length(); i++){
      strArr[i] = hm.get(digits.charAt(i)-'0');
    }


    letterCombinationsUtil(sol,strArr,"",0);

    return sol;

  }


  void letterCombinationsUtil(List<String> sol, String strArr[], String curr, int idx){
    if(curr.length() == strArr.length){
      sol.add(new String(curr));
      return;
    }
    if(idx >= strArr.length){
      return;
    }

    String temp = strArr[idx];
    for(int i = 0; i<temp.length(); i++){
      letterCombinationsUtil(sol,strArr,curr+temp.charAt(i),idx+1);
    }
  }


  public static void main(String[] args) {
    letterCombinationOfPhoneNumberProblem17 lc = new letterCombinationOfPhoneNumberProblem17();
    lc.letterCombinations("23");
  }

}
