package backtracking.typeA;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GenerateIPAddresses {

  public List<String> restoreIpAddresses(String s) {
    List<String> sol = new LinkedList<>();
    if(s.length() < 4 || s.length()> 12)
      return sol;
    String cur ="";
    restoreIpAddressesUtil(s, sol, "", 0, 0);
    return sol;
  }

  private void restoreIpAddressesUtil(String s, List<String> sol, String cur, int count, int idx) {

    if(count == 4 && idx == s.length()){
      sol.add(new String(cur.substring(0, cur.length()-1)));
      return;
    }


    if(idx >= s.length())
      return;

    restoreIpAddressesUtil(s, sol, cur+ s.substring(idx, idx+1)+".", count+1, idx+1);

    if(s.charAt(idx) != '0' && idx<s.length()-1)
      restoreIpAddressesUtil(s, sol, cur + s.substring(idx, idx+2)+".", count+1, idx+2);


    if(idx<s.length()-2 && s.charAt(idx) != '0' && (Integer.valueOf(s.substring(idx, idx+3)) < 256))
      restoreIpAddressesUtil(s, sol, cur + s.substring(idx, idx+3)+".", count+1, idx+3);
  }


  public static void main(String[] args) {
    GenerateIPAddresses gip = new GenerateIPAddresses();
    gip.restoreIpAddresses("25525511135");
  }
}
