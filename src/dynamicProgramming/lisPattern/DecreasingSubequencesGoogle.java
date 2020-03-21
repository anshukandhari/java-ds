package dynamicProgramming.lisPattern;

import java.util.Arrays;

// here is the reference of
// Very good question, it is same as LIS but

/**
 * Question: https://leetcode.com/discuss/interview-question/350233/Google-or-Summer-Intern-OA-2019-or-Decreasing-Subsequences
 *
 * The number of decreasing subsequence partitions is equal to the length of the longest non-decreasing subsequence,
 * because every non-decreasing number represents a point where a continuation of a previous decreasing subsequence is impossible.
 * We don't care what the subsequences are, so the length is enough to tell us how many times a new decreasing subsequence is required.
 *
 * but here we need to write our own function of binary search, see the test case which fails, if we use the predefined binary search.
 *
 */
public class DecreasingSubequencesGoogle {
  public static int leastSubsequences(int... nums) {
    int[] piles = new int[nums.length];
    int size = 0;
    for (int val : nums) {
      int pile = binarySearch(piles, 0, size, val);
      piles[pile] = val;
      if (pile == size) size++;
    }
    return size;
  }

  // find first element greater than target
  public static int binarySearch(int[] nums, int lo, int hi, int target) {
    while (lo < hi) {
      int mid = (lo + hi) >>> 1;
      if (nums[mid] <= target) { // this <=  is important to handle cases like [1,1,1]
        lo = mid + 1;
      } else {
        hi = mid;
      }
    }
    return lo;
  }


  public static void main(String[] args) {
    test(leastSubsequences(2, 9, 12, 13, 4, 7, 6, 5, 10), 4);
    test(leastSubsequences(5, 2, 4, 3, 1, 6), 3);
    test(leastSubsequences(1, 1, 1), 3);
    test(leastSubsequences2(new int[]{2, 9, 12, 13, 4, 7, 6, 5, 10}), 4);
    test(leastSubsequences2(new int[]{5, 2, 4, 3, 1, 6}), 3);
    test(leastSubsequences2(new int[]{1, 1, 1}), 3); // it fails because we expect 3, if we expect 1 then binary search works perfect
  }

  private static void test(int actual, int expected) {
    if (actual == expected) {
      System.out.println("PASSED!");
    } else {
      System.out.println(String.format("FAILED! Expected %d, but got %d", expected, actual));
    }
  }



  public static int leastSubsequences2(int nums[]) {
    int dp[] = new int[nums.length];
    int len = 0, idx;

    for(int i = 0; i < nums.length;i++){
        idx = Arrays.binarySearch(dp, 0,len, nums[i]);

        if(idx < 0)
          idx = -(idx +1);

        dp[idx] = nums[i];

        if(len == idx)
          len++;
    }

    return len;
  }

}
