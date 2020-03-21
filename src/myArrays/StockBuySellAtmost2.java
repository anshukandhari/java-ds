package myArrays;

public class StockBuySellAtmost2 {

  public static int maxProfit(int[] a) {
    int s = Integer.MAX_VALUE, b = -1;
    int ans[] = new int[2];

    for(int n : a){
      if(n <= s){
        if (b == -1){
          s = n;
        }else {
          setMaxVals(ans, b-s);
          b = -1;
          s = n;
        }
      } else if(n > s) {
        if( b == -1){
          b = n;
        } else if (n<b){
          setMaxVals(ans, b-s);
          b = -1;
          s = n;
        } else if(n>b){
          b = n;
        }

      }
    }
    if (b!= -1){
      setMaxVals(ans, b-s);
    }

    return ans[0]+ans[1];
  }

  private static void setMaxVals(int a[], int v){
    if(v>a[1]){
      a[0] = a[1];
    } else if (v> a[0]){
      a[0] = v;
    }
  }

  public static void main(String[] args) {
    int a[] = {3,3,5,0,0,3,1,4};
    System.out.println(maxProfit(a));
  }

}
