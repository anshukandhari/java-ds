package dynamicProgramming;

public class LongestCommonSubsequence {
  int lcs(String a, String b){
    int m[][] = new int[a.length()+1][b.length()+1];

    for(int i =0; i<=a.length(); i++) {
      for (int j = 0; j <= b.length(); j++) {
        if(i == 0 || j == 0){
          m[i][j] = 0;
          continue;
        }

        if(a.charAt(i-1) == b.charAt(j-1)){
          m[i][j] = m[i-1][j-1]+1;
        } else {
          m[i][j] = Math.max(m[i-1][j], m[i][j-1]);
        }
      }
    }

    return m[a.length()][b.length()];
  }


  /**
   * Space optimisations:
   *
   * If we see, we dont need anything apart from 3 values => m[i-1][j], m[i][j-1], m[i-1][j-1]
   * Of these m[i-1][j], m[i][j-1] can be easily retrieved if we use a single array
   * However, for m[i-1][j-1], I introduced a variable lastValue, which store the value of m[j-1] before it was updated.
   * And hence serve as m[i-1][j-1]
   *
  */
  int lcs2(String a, String b){
    if(a.length() < b.length()){
      String str = a;
      a = b;
      b = str;
    }

    int m[] = new int[b.length()+1];
    int lastVal = 0;
    int temp = 0;

    for(int i =0; i<=a.length(); i++) {
      for (int j = 0; j <= b.length(); j++) {
        if(i == 0 || j == 0){
          lastVal = m[j];
          m[j] = 0;
          continue;
        }


        if(a.charAt(i-1) == b.charAt(j-1)){
          temp= m[j];
          m[j] = lastVal+1;
          lastVal = temp;
        } else {
          lastVal = m[j];
          m[j] = Math.max(m[j], m[j-1]);
        }

      }
    }

    return m[b.length()];
  }

  public static void main(String[] args) {
    LongestCommonSubsequence lcs = new LongestCommonSubsequence();
    String s1 = "ABCDGH";
    String s2 = "AEDFHR";

    System.out.println(lcs.lcs(s1,s2));
    System.out.println(lcs.lcs2(s1,s2));

  }

}
