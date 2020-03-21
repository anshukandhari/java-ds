package sorting;

import java.util.Arrays;

// Try to solve K closes element using this. Amazing application.
public class QuickSort {

  public void quickSort(int A[], int l, int r) {
    if(l<r){
      int p = partition(A,l,r);
      quickSort(A,l,p-1);
      quickSort(A,p+1,r);
    }

  }

  private int partition(int A[], int l, int r){
    int pv = A[r];

    int i =l;
    int temp;
    for (int j =l+1; j<r;j++){
      if(A[j] <= pv){
        temp = A[i];
        A[i] = A[j];
        A[j] = temp;
        i++;
      }
    }
    temp = A[i];
    A[i] = A[r];
    A[r] = temp;

    return i;
  }


  public static void main(String[] args) {
    int A[] = {3,1,6,4,9,1,-8};
    QuickSort qs = new QuickSort();
    qs.quickSort(A,0,A.length-1);
    Arrays.stream(A).forEach(a -> System.out.println(a));
  }

}
