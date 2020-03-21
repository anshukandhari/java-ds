package searching;

public class BitonicArraySearch {

  public int searchKey(int A[], int key, int btIndex){
    if(key > A[btIndex]){
      System.out.println("Key not found");
      return -1;
    }

    if (key == A[btIndex]) {
      return btIndex;
    }

    System.out.println("Key not found");
    return -1;
  }

  public int getMaxElementIndex(int A[], int start, int end) {
    if (start == end) {
      return start;
    }
    if (end == start + 1) {
      return A[end] > A[start] ? end : start;
    }

    int mid = (end - start) / 2 + start;

    if (A[mid - 1] < A[mid] && A[mid] > A[mid + 1]) {
      return mid;
    }

    if (A[mid] > A[mid - 1]) {
      return getMaxElementIndex(A, mid + 1, end);
    } else {
      return getMaxElementIndex(A, start, mid-1);
    }

  }

  int getRotatedIndex(int A[]){
    int b = 0, e = A.length-1, mid, sol =0;

    if(A[b] < A[e]){
      return e;
    }

    while(b<=e){
      mid = (e+b)/2;
      if(mid < A.length-1 && A[mid] > A[mid+1] && (mid == 0 || A[mid]> A[mid-1])){
        sol = mid;
        break;
      }

      if(A[mid] < A[b]){
        e = mid-1;
      } else {
        b = mid+1;
      }
    }

    return sol;

  }





  public static void main(String[] args) {
    int A[] = {-3, 1,5, 8, 20, 217, 251, 98, 90, 45, 31, 18, 2};
    int key = 98;
    BitonicArraySearch bs = new BitonicArraySearch();
/*
    int maxIndex = bs.getMaxElementIndex(A,0,A.length-1);
    System.out.println(maxIndex);*/
    System.out.println(bs.getRotatedIndex(A));

  }
}
