package backtracking.typeA;

import java.util.ArrayList;
import java.util.List;

public class PalindromicDecomposition {

  public List<List<String>> palindromePartitioning(String s) {
    List<List<String>> sol = new ArrayList<>();
    ArrayList<String> curr = new ArrayList<>();
    palindromePartitioningUtil(s, sol, curr, 0);
    return sol;
  }

  void palindromePartitioningUtil(String s, List<List<String>> sol, ArrayList<String> curr, int start) {
    if(start >= s.length()){
      sol.add(new ArrayList(curr));
      return;
    }

    for(int i = 0; i+start<s.length(); i++){
      String t = s.substring(start, start+i+1);

      if(isPalindrome(t)){
        curr.add(t);
        palindromePartitioningUtil(s, sol, curr, start+i+1);
        curr.remove(curr.size()-1);
      }
    }
  }

  boolean isPalindrome(String s){
    if(s.length() == 0){
      return true;
    }

    for(int i =0, j = s.length()-1; i<j; i++,j--){
      if(s.charAt(i) != s.charAt(j))
        return false;
    }

    return true;
  }

  public static void main(String[] args) {
    PalindromicDecomposition pd = new PalindromicDecomposition();
    List<List<String>> sol = pd.palindromePartitioning("0204451881");
    sol.forEach(v -> v.forEach(v2 -> System.out.println(v2)));

  }

}
