package backtracking;

import java.util.Arrays;
import java.util.HashSet;

public class StringPermutation {
  HashSet<String> hs;

  // Better alternative solution and easier to understand is https://www.youtube.com/watch?v=78t_yHuGg-0
  // To understand below check https://www.youtube.com/watch?v=MQcwxQK2DPA
  public void permutationOfString(String s, int start, int end){
    if(start == end && !hs.contains(s)){
      hs.add(s);
      System.out.println(s);
      return;
    }

    for(int i=start;i<=end;i++){
      s=swap(s,i,start);
      permutationOfString(s,start+1, end);
      s=swap(s,i,start);
    }

  }
  public void permutationWithoutHashSet(String s){
    char charArr[] = s.toCharArray();
    Arrays.sort(charArr);
    s = String.valueOf(charArr);
    permutationOfString2(s,0,s.length()-1);
  }


  public void permutationOfString2(String s, int start, int end){
    if(start == end){
      System.out.println(s);
      return;
    }

    for(int i=start;i<=end;i++){
      if(i>start && s.charAt(i) == s.charAt(i-1))
        continue;
      s=swap(s,i,start);
      permutationOfString2(s,start+1, end);
      s=swap(s,i,start);
    }

  }


  private String swap(String str, int i, int j){
    char s[] = str.toCharArray();
    char t = str.charAt(j);
    s[j]=str.charAt(i);
    s[i]=t;
    return String.valueOf(s);
  }



  public static void main(String[] args) {
    StringPermutation sp = new StringPermutation();
    sp.hs = new HashSet<>();
    String s = "ABAAC";
//    sp.permutationOfString(s, 0, s.length()-1);
    sp.permutationWithoutHashSet(s);
    // Following doesn't work with duplicate characters
//    sp.permuteString(s);
  }



  public void permuteString(String s){
    String curr = "";
    HashSet<Character> hs = new HashSet<>();
    permuteStringUtil(s,hs,curr);

  }

  public void permuteStringUtil(String s, HashSet<Character> hs, String curr){
    if(curr.length() == s.length()){
      System.out.println(curr);
      return;
    }

    for(int i = 0; i< s.length(); i++){
      if(hs.contains(s.charAt(i)))
        continue;
      hs.add(s.charAt(i));
      permuteStringUtil(s, hs,curr + s.charAt(i));
      hs.remove(s.charAt(i));
    }
  }


}
