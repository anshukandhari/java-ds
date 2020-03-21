package dynamicProgramming;

public class Game1 {
  private int countNumberOfWays(int n){
    int a[] = new int[n+1];
    a[3]=1;
    a[5]=1;
    a[10]=2;

    for(int i=4;i<=n;i++){
      a[i] += a[i-3];
    }

    for(int i=6;i<=n;i++){
      a[i] += a[i-5];
    }

    for(int i=11;i<=n;i++){
      a[i] += a[i-10];
    }

    return a[n];
  }



}
