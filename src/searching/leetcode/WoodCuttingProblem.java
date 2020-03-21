package searching.leetcode;

import java.util.Arrays;

//https://leetcode.com/discuss/interview-question/354854/Facebook-or-Phone-Screen-or-Cut-Wood
public class WoodCuttingProblem {
    public static int getMaxLenPieces(int A[], int k){
        int min = Arrays.stream(A).min().getAsInt();
        int max = Arrays.stream(A).max().getAsInt();

        if(max <k)
            return 0;

        int low = 1, high = min, mid;

        while(low <= high){
            mid = (high-low)/2+low;
            if(isPossible(A,mid,k)){
                if(!isPossible(A,mid-1, k))
                    return mid;

                low = mid +1;
            } else {
                high = mid-1;
            }
        }

        return high;
    }


    private static boolean isPossible(int A[], int len, int k){
        if(len == 0)
            return true;
        int sum = 0;
        for(int a : A){
            sum += a/len;
            if(sum >= k)
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(getMaxLenPieces(new int[]{232, 124, 456}, 7));
    }
}
