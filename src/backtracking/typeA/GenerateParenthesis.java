package backtracking.typeA;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

  int diff = 0;
  public List<String> generateParenthesis(int n) {
    StringBuffer sb = new StringBuffer();
    for(int i = 0; i<n; i++){
      sb.append('(');
      sb.append(')');
    }

    String str = sb.toString();
    List<String> sol = new ArrayList<>();
    generateParenthesisUtil(str, sol,"",n);

    return sol;

  }

  void generateParenthesisUtil(String s, List<String> sol, String curr, int n) {
    if(diff == 0 && curr.length() == 2*n){
      sol.add(new String(curr));
      return;
    }

    if(curr.length()>2*n){
      return;
    }

    for(int i = 0; i<2*n-1;i++){
      if(s.charAt(i) == '(' && diff < n){
        diff++;
        generateParenthesisUtil(s,sol,curr+s.charAt(i),n);
      } else if(s.charAt(i) == ')' && diff >0){
        diff--;
        generateParenthesisUtil(s,sol,curr+s.charAt(i),n);
      }

    }


  }

  public static void main(String[] args) {
    GenerateParenthesis gp = new GenerateParenthesis();
    gp.generateParenthesis(3);
  }

}
