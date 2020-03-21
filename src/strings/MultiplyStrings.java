package strings;

public class MultiplyStrings {
  public String multiply(String a, String b) {
    if(a.length() == 0){
      return b;
    }

    if(b.length() == 0){
      return a;
    }

    int sum[] = new int [1000001], mul, curr, start = 1000000;
    int carry = 0, skip =0, v1, v2;
    String sol;

    for( int i = a.length()-1; i>=0; i--){
      v1 = a.charAt(i)-'0';
      curr = start;

      for( int j = b.length()-1; j>=0; j--){
        v2 = b.charAt(j)-'0';
        mul = v1*v2 + carry + sum[curr];
        if(mul >9){
          carry = mul/10;
          mul%=10;
        } else {
          carry = 0;
        }

        sum[curr] = mul;
        curr--;
      }
      if(carry >0){
        sum[curr] =carry;
        carry =0;
      }
      start--;
    }

    StringBuilder sb = new StringBuilder();
    for(int i = 0; i< sum.length; i++){
      if(sum[i] != 0){

        for(int j = i; j< sum.length; j++){
          sb.append(sum[j]);
        }
        break;
      }
    }

    System.out.println(sb.toString());


    return sb.toString();
  }

  public static void main(String[] args) {
    MultiplyStrings ms = new MultiplyStrings();

    ms.multiply("12", "21");
  }

}
