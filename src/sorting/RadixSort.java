package sorting;

import java.util.Arrays;

// TODO : When free time
public class RadixSort {

  public void countSort(int A[], int exp){

  }

  public void radixSort(int A[]){
    int m = getMax(A);
    int exp = 0;
    for(int j = 10; m>0; exp++){
      m=m/j;
    }

  }

  private int getMax(int A[]){
    return Arrays.stream(A).max().getAsInt();
  }

}
