package projecteuler;


import Utilities.MathUtils;


public class ProjectEulerSet1 {

  // Problem 1
  public Integer findSumOfMultiples(int[] A, int end) {
    int sum = 0;
      for (int j=1; j<end; j++) {

        for (int i=0; i<A.length;i++) {
          if (A[i] < 0 || A[i] > end) {
            continue;
          }
          if (j % A[i] == 0) {
            sum = sum + j;
            break;
          }
        }

      }


    return sum;
  }

  //Problem 2
  // Better Solution: https://www.mathblog.dk/project-euler-problem-2/
  public int fibonacciEvenSum(int end) {
    int a = 1, b=2, c=0;
    int sum = b;

    for (int i =3; (a+b) < end; i++) {
      c = a+b;
      a=b;
      b =c;
      if (c%2 ==0){
        sum += c;
      }
    }
    return sum;
  }


  //Problem 3
  public long maxPrimeFactor(long n){
    long maxPF = 1;
    while(n%2 == 0) {
      maxPF = 2;
      n/=2;
    }

    for (int i = 3; i< Math.sqrt(n); i+=2) {
      while(n%i == 0){
        n/=i;
        maxPF = i;
      }
    }

    // TODO: very good I missed
    if (n>2){
      maxPF = n;
    }
    return maxPF;
  }

  // Problem 4
  public long maxPalindrome(){
    MathUtils mathUtils = new MathUtils();
    int temp = 0;
    for (int i = 998; i>100;i--){
      temp = makePalindrome(i);
      if (mathUtils.isPalindrome(temp)){
        if(hasFactorsInRange(temp, 99, 1000)){
          return temp;
        }
      }
    }
    return -1;
  }

  // Problem 5
  public long findLCMOfRange(int start, int end) {
    int[] A = {11,12,13,14,15,16,17,18,19,20};
    MathUtils mathUtils = new MathUtils();
    return mathUtils.lcmOfArray(A);
  }

  //Problem 6
  public long sumSquareDifference() {
    MathUtils mathUtils = new MathUtils();
    long res = 0, temp =0;
    long maxSum = mathUtils.sumOfNaturalNumber(100);
    for (int i=1; i<100; i++){
      temp = maxSum-mathUtils.sumOfNaturalNumber(i);
      res += 2*i*temp;
    }
    return  res;
  }






  private int makePalindrome(int n) {
    String firstHalf = Integer.valueOf(n).toString();
    String reversed = new StringBuilder(firstHalf).reverse().toString();
    return Integer.valueOf(firstHalf + reversed);
  }

  private boolean hasFactorsInRange(int n, int start, int end) {
    int maxFactor = (((int) Math.sqrt(n)));
    while(n/maxFactor > start && n/maxFactor<end) {
      if (n % maxFactor == 0) {
        return true;
      }
      maxFactor--;
    }
    return false;
  }

}