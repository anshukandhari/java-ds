package dynamicProgramming;

public class EditDistance {
  // it assumes a.length <= b.length
  static int editDistRecur(String a , String b, int ai, int bi){
    if(a.length() == 0 || b.length() == 0) {
      return a.length() + b.length();
    }

    if(ai == a.length() && bi == b.length()){
      return 0;
    }

    if(ai == a.length() || bi == b.length()){
      return a.length()+b.length()-ai-bi;
    }

    if(a.charAt(ai) == b.charAt(bi)){
      return editDistRecur(a,b,ai+1, bi+1);
    }

    return 1+ Math.min(Math.min(editDistRecur(a,b,ai,bi+1), editDistRecur(a,b,ai+1,bi+1)), editDistRecur(a,b,ai+1,bi));

  }

  // This can further be space optimized just like LongestCommonSubsequence
  static int editDist(String a , String b){
    int m[][] = new int[a.length()+1][b.length()+1];

    for(int i =0; i<=a.length(); i++) {
      for (int j = 0; j <= b.length(); j++) {
        if(i == 0){
          m[i][j] = j;
          continue;
        }
        if(j == 0){
          m[i][j] = i;
          continue;
        }

        if(a.charAt(i-1) == b.charAt(j-1)){
          m[i][j] = m[i-1][j-1];
        } else {
          m[i][j] = 1+ Math.min(Math.min(m[i][j-1], m[i-1][j-1]), m[i-1][j]);
        }
      }
    }

    return m[a.length()][b.length()];

  }

  public static int editDistanceOptimized(String a, String b) {
    if(a.length() < b.length()){
      return editDistanceOptimized(b,a);
    }

    int m[] = new int[b.length()+1];
    int lastValue = 0, temp = 0;

    for(int i =0; i<=a.length(); i++) {
      for (int j = 0; j <= b.length(); j++) {
        if(i == 0){
          lastValue = m[j];
          m[j] = j;
          continue;
        }
        if(j == 0){
          lastValue = m[j];
          m[j] = i;
          continue;
        }

        if(a.charAt(i-1) == b.charAt(j-1)){
          temp = m[j];
          m[j] = lastValue;
          lastValue = temp;
        } else {
          temp = m[j];
          m[j] = 1+ Math.min(Math.min(m[j-1], lastValue), m[j]);
          lastValue = temp;
        }
      }
    }

    return m[b.length()];
  }

  public static void main(String[] args) {
    System.out.println(editDistRecur("sunday", "saturday", 0, 0));
    System.out.println(editDist("sunday", "saturday"));
    System.out.println(editDistanceOptimized("sunday", "saturday"));
  }

}
