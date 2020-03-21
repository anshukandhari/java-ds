package backtracking.typeB;

import java.util.Arrays;
import java.util.HashSet;

// Ref: https://www.geeksforgeeks.org/word-break-problem-using-backtracking/
public class WordBreakProblem {
  int count = 0;
  public int countBreakingWays(String s, HashSet<String> hs){
    if(s.length() == 0)
      return 0;
    countBreakingWays(s, hs, 0);
    return count;
  }


  public void countBreakingWays(String s, HashSet<String> hs, int start){
    if(start == s.length()){
      count++;
      return;
    }

    for(int i = start; i< s.length(); i++){
      if(hs.contains(s.substring(start, i+1))){
        countBreakingWays(s,hs,i+1);
      }
    }
  }

  public static void main(String[] args) {
    WordBreakProblem wbp = new WordBreakProblem();
    HashSet<String> hs =  new HashSet<>(Arrays.asList("i","like","sam","sung","samsung","mobile","ice","cream","icecream","man","go","mango", "and"));
    System.out.println(wbp.countBreakingWays("ilikeicecreamandmango", hs));
  }
}
