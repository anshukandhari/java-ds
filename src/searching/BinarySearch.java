package searching;

import java.util.Arrays;

public class BinarySearch {
  public int search(int A[], int start, int end, int key){
    int mid;

    while(start <= end) {
      mid = (end-start)/2 + start;
      if (A[mid] == key){
        return mid;
      }

      if (A[mid] > key){
        end = mid-1;
      } else if (A[mid] < key){
        start = mid +1;
      }
    }
    Arrays.stream(A).min().getAsInt();

    return -1;
  }

  public static void main(String[] args) {
    int A[] = {1,2,3,4,5,6,7,8,9};
    BinarySearch bs = new BinarySearch();
    bs.search(A, 0, A.length-1, 0);
  }


}
