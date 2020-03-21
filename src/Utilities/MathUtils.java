package Utilities;

import java.util.Stack;

public class MathUtils {

  public boolean isPalindrome(int n) {
    if(n<10){
      return true;
    }
    int maxDiv = 10;
    while(n/maxDiv > 10) {
      maxDiv *= 10;
    }

    while(n>10 && maxDiv >0) {
      if (n % 10 == n/maxDiv) {
          n= n%maxDiv;
          n/=10;
          maxDiv /=100;
      } else {
        return false;
      }
    }

    return true;
  }

  public int gcd(int a, int b) {
    if (b == 0)
      return a;
    return gcd(b, a % b);
  }

  public  long sumOfNaturalNumber(int end) {
    return (end*(end+1))/2;
  }

  public long lcmOfArray(int[] element_array) {
      long lcm_of_array_elements = 1;
      int divisor = 2;

      while (true) {
        int counter = 0;
        boolean divisible = false;

        for (int i = 0; i < element_array.length; i++) {

         if (element_array[i] == 0) {
            return 0;
          }
          else if (element_array[i] < 0) {
            element_array[i] = element_array[i] * (-1);
          }
          if (element_array[i] == 1) {
            counter++;
          }


          if (element_array[i] % divisor == 0) {
            divisible = true;
            element_array[i] = element_array[i] / divisor;
          }
        }


        if (divisible) {
          lcm_of_array_elements = lcm_of_array_elements * divisor;
        }
        else {
          divisor++;
        }


        if (counter == element_array.length) {
          return lcm_of_array_elements;
        }

      }
  }

}
