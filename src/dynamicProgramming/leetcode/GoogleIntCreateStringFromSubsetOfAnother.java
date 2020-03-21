package dynamicProgramming.leetcode;

// REF: https://leetcode.com/discuss/interview-question/365191/Google-or-Form-String-A-from-suffix-of-String-B
// Not working, I though myself of a hashmap solution where I will store the character and all their ocurrences
public class GoogleIntCreateStringFromSubsetOfAnother {
  public static int  getCount(String A, String B){
    return getCountUtil(A,B,A.length()-1,B.length()-1);
  }

  static int getCountUtil(String a, String b, int i, int j){
    if(i == -1){
      return 1;
    }

    if(j == -1){
      return 1+ getCountUtil(a,b,i,b.length()-1);
    }

//    int min = Integer.MAX_VALUE;
    if(a.charAt(i) == b.charAt(j)){
      return getCountUtil(a,b,i-1,j-1);
//      min = Math.min(min,getCountUtil(a,b,i-1,j-1));
    } else {
      return getCountUtil(a,b,i,j-1);
//      min = Math.min(min,1+getCountUtil(a,b,i,j-1));
    }

//    return min;

  }


  public static void main(String[] args) {

    System.out.println(getCount("cdcd","dcd"));
    System.out.println(getCount("abcabcabcabcabc","abcabc"));
    System.out.println(getCount("zaza","baz"));
  }
}
