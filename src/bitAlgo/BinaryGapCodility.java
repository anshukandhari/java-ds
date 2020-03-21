package bitAlgo;

public class BinaryGapCodility {

  public int solution(int N) {
    // write your code in Java SE 8
    if(N<5){
      return 0;
    }

    int sol = 0, count = 0;
    boolean isCountable  = false;


    String s = getBinarySeq(N);
    System.out.println(s);

    for(int i = 0; i<s.length();i++){
      if(s.charAt(i) == '1'){
        if(isCountable){
          sol = Math.max(sol,count);
          count =  0;
        } else {
          isCountable = true;
        }
      } else {
        if(isCountable){
          count++;
        }
      }

    }
    System.out.println(sol);
    return sol;

  }

  String getBinarySeq(int N){
    StringBuffer sb = new StringBuffer();
    while(N>0){
      sb.append(N%2);
      N /= 2;
    }
    return sb.reverse().toString();
  }

  public static void main(String[] args) {
    BinaryGapCodility bcg = new BinaryGapCodility();
    bcg.solution(1162);
  }

}
