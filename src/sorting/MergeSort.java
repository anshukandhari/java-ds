package sorting;

public class MergeSort {
  // Easier version to implement
  public int[] merge2(int A[], int l, int m, int r){
    int s1 = 0, s2 = m+1, e1 = m;
    int t;

    while(s1 <= e1) {
      if (A[s1] <= A[s2]){
      } else {
        t = A[s1];
        A[s1] = A[s2];
        A[s2] = t;
      }
      s1++;
    }

    return A;
  }

  public int[] merge(int A[], int l, int m, int r){
    int n1= m-l+1, n2= r-m;
    int L[] = new int[n1];
    int R[] = new int[n2];

    for(int i=0; i<n1;i++){
      L[i]=A[l+i];
    }

    for(int i=0; i<n2;i++){
      R[i]=A[m+1+i];
    }

    int i = 0, j =0, k =l;

    while(i<n1 && j<n2){
      if(L[i]<= R[j]){
        A[k] = L[i];
        i++;
      } else{
        A[k] = R[j];
        j++;
      }
      k++;
    }

    while(i<n1){
      A[k++] = L[i++];
    }

    while(j<n2){
      A[k++] = R[j++];
    }

    return A;
  }

  public void mergeSort(int A[], int l, int r){
    if(l>=r)
      return;
    int m= (r+l)/2;
    mergeSort(A,l,m);
    mergeSort(A,m+1,r);
    merge2(A,l,m,r);
  }

  void printArray(int arr[])
  {
    int n = arr.length;
    for (int i=0; i<n; ++i)
      System.out.print(arr[i] + " ");
    System.out.println();
  }

  public static void main(String[] args) {
    MergeSort ms = new MergeSort();
    int A[] = {1,2,3,4,5};

    ms.mergeSort(A,0,A.length-1);
    ms.printArray(A);
  }

  /**
   * [4,2,8,6]
   *
   */

}
