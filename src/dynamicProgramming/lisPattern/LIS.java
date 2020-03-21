package dynamicProgramming.lisPattern;

import java.util.Arrays;

public class LIS {

  //TODO: nlogn is so simple, just read the solution here https://leetcode.com/problems/longest-increasing-subsequence/solution/
  private static int lis(int a[]){
    int lis[] = new int[a.length];
    lis[0]=1;

    for(int i =1; i<a.length;i++) {
      for (int j = 0; j < i; j++) {
        if(a[j]<a[i] && lis[j]+1 > lis[i]){
          lis[i] = lis[j]+1;
        }
      }
    }
    return Arrays.stream(lis).max().getAsInt();
  }

  public static int lengthOfLIS(int[] nums) {
    int[] tails = new int[nums.length];
    int size = 0;
    for (int x : nums) {
      int i = 0, j = size;
      while (i != j) {
        int m = (i + j) / 2;
        if (tails[m] < x)
          i = m + 1;
        else
          j = m;
      }
      tails[i] = x;
      if (i == size) ++size;
      System.out.println(Arrays.toString(tails));
    }
    return size;
  }

  public static void main(String[] args) {
//    int a[] = {10, 58, 22, 9, 33, 21, 50, 41, 60, 80};
//    int a[] = {4,5,6,3};
//    System.out.println(lis(a));
//    System.out.println(lengthOfLIS(a));
    int a[] = {3,13,23,33};

    System.out.println("Hello World"+ Arrays.binarySearch(a,0,4,12));

  }
}
