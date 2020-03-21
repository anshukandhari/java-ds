package searching;

public class DuplicateArraySearch {
  // Find the start and the end of an element containing duplicates

  public int[] searchRange(int[] A, int target) {
    int ans[] = {-1,-1};
    int i = -1, j = -1;
    int t = search(A,target);

    if( t == -1){
      return ans;
    }

    i = searchStart(A, 0, t, target);
    j = searchEnd(A, t, A.length-1, target);


    ans[0] = i;
    ans[1] = j;
    return ans;
  }

  public int search(int A[], int key){
    int start = 0, end = A.length-1;
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

    return -1;
  }

  public int searchStart(int A[], int start, int end, int key){
    int mid;

    while(start <= end) {
      mid = (end-start)/2 + start;
      if (A[mid] == key && (mid == 0 || A[mid-1] != key)){
        return mid;
      }

      if (A[mid] == key){
        end = mid-1;
      } else if (A[mid] < key){
        start = mid +1;
      }
    }

    return -1;
  }

  public int searchEnd(int A[], int start, int end, int key){

    int mid;

    while(start <= end) {
      mid = (end-start)/2 + start;
      if (A[mid] == key && (mid == A.length-1 || A[mid+1] != key)){
        return mid;
      }

      if (A[mid] == key){
        start = mid+1;
      } else if (A[mid] > key){
        end = mid - 1;
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    DuplicateArraySearch da = new DuplicateArraySearch();
    int A[]= {1,2,8,8,8,8,8,9};
    int ans[] = da.searchRange(A,8);
    System.out.println("Start: "+ans[0]+ " and End: "+ans[1]);
  }
}
