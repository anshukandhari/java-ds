package dynamicProgramming;

public class KnapSack {

  public static int knapSack(int W, int wt[], int val[], int idx){
    if(W == 0 || idx == val.length ){
      return  0;
    }

    if(wt[idx]> W){
      return 0;
    }

    return Math.max(val[idx]+ knapSack(W-wt[idx],wt,val,idx+1), knapSack(W,wt,val,idx+1));
  }


  public static int knapSackTabular(int W, int wt[], int val[], int idx){
    if(val.length == 0 || W == 0){
      return  0;
    }

    int m[][] = new int[val.length+1][W+1];

    for (int i=0;i<=wt.length;i++) {
      for (int j = 0; j <= W; j++) {

        if(i==0 || j == 0){
          m[i][j] = 0;
        } else {
          if (j - wt[i-1] < 0) {
            m[i][j] = m[i-1][j];
          } else {
            m[i][j] = Math.max(val[i-1] + m[i-1][j - wt[i-1]], m[i-1][j]);
          }
        }

      }
    }
    return m[val.length][W];
  }

  public static void main(String[] args) {
    int val[] = new int[]{60, 100, 120};
    int wt[] = new int[]{10, 20, 30};
    int  W = 50;
    int n = val.length;
    System.out.println(knapSack(W, wt, val, 0));
    System.out.println(knapSackTabular(W, wt, val, 0));
  }

}
