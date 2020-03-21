package dynamicProgramming;

public class largestSumContiguosSubArray {
  public static int kadane(int a[]){
    int l = a.length;

    int s=-1,maxSoFar=0,sum=0, fs =-1, fe =-1;
    for(int i =0; i<l;i++){
      sum += a[i];
      if(sum<0){
        sum = 0;
        s = -1;
      } else {
        if(s == -1){
          s = i;
        }

        if(sum>maxSoFar){
          fe = i;
          fs = s;
          maxSoFar = sum;
        }

      }
    }

    if(fs ==-1){
      return -1;
    }

    System.out.println("Max Subarray starts at"+ a[fs] +" and ends at " +a[fe]);
    return maxSoFar;
  }

  public static void main(String[] args) {
    int a[] = {-2, -3, 4, -1, -2, 1, 5, -3};
    System.out.println(kadane(a));
  }
}
