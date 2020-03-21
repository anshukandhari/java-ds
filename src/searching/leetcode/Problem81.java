package searching.leetcode;

public class Problem81 {

  public boolean search(int[] nums, int target) {
    boolean ans = false;
    if(nums.length == 0){
      return false;
    }

    int maxElementIndex = getBitonicIndex(nums, 0, nums.length-1, nums[0]);

    if(target == nums[maxElementIndex]){
      return true;
    }

    if(target > nums[maxElementIndex]){
      return false;
    }

    if(maxElementIndex >0){
      ans = binarySearch(nums, 0, maxElementIndex-1, target);
    }

    if(maxElementIndex < nums.length && ans == false){
      ans = binarySearch(nums, maxElementIndex+1, nums.length-1, target);
    }

    return ans;
  }

  public boolean binarySearch(int A[], int start, int end, int key){
    int mid;

    while(start <= end) {
      mid = (end-start)/2 + start;
      if (A[mid] == key){
        return true;
      }

      if (A[mid] > key){
        end = mid-1;
      } else if (A[mid] < key){
        start = mid +1;
      }
    }

    return false;
  }


  public int getBitonicIndex(int A[], int start, int end, int head) {
    if (start == end) {
      return start;
    }
    if (end == start + 1) {
      return A[end] > A[start] ? end : start;
    }

    int mid = (end - start) / 2 + start;

    if (A[mid] == A.length -1 || A[mid] > A[mid + 1]) {
      return mid;
    }

    if (A[mid] >= head) {
      return getBitonicIndex(A, mid + 1, end, head);
    } else {
      return getBitonicIndex(A, start, mid-1, head);
    }

  }

  public static void main(String[] args) {
    Problem81 p = new Problem81();
    int A[] = {1,3,1,1,1};
    System.out.println(p.search(A,3));
  }

}
