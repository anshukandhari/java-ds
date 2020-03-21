package searching;

public class RotatedArraySearch {
  public int search(int[] nums, int target) {
    int ans = -1;
    if(nums.length == 0){
      return -1;
    }

    int maxElementIndex = getBitonicIndex(nums, 0, nums.length-1, nums[0]);

    if(target == nums[maxElementIndex]){
      return maxElementIndex;
    }

    if(target > nums[maxElementIndex]){
      return -1;
    }

    if(maxElementIndex >0){
      ans = binarySearch(nums, 0, maxElementIndex-1, target);
    }

    if(maxElementIndex < nums.length && ans == -1){
      ans = binarySearch(nums, maxElementIndex+1, nums.length-1, target);
    }

    return ans;

  }

  public int binarySearch(int A[], int start, int end, int key){
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


  public int getBitonicIndex(int A[], int start, int end, int head) {
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

    if (A[mid] > head) {
      return getBitonicIndex(A, mid + 1, end, head);
    } else {
      return getBitonicIndex(A, start, mid-1, head);
    }

  }


  public static void main(String[] args) {
    RotatedArraySearch ra = new RotatedArraySearch();
    int A[]= {4,5,6,7,0,1,2};
    System.out.println(ra.search(A,3));
  }

}
