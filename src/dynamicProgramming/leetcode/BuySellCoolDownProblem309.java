package dynamicProgramming.leetcode;

import java.util.Arrays;

public class BuySellCoolDownProblem309 {
  public static void main(String[] args) {
    System.out.println(maxProfit(new int[]{6,1,3,2,4,7}));
  }



  public static int maxProfit(int[] prices) {
    if(prices.length == 0){
      return 0;
    }

    int b = 0, s=0;
    int profit[] = new int[prices.length];
    profit[0] = 0;
    int profitsFromPrevTxns = 0;

    for(int i = 1; i< prices.length; i++){
      if(prices[i] < prices[s]){
        if(i>1){
          profitsFromPrevTxns += profit[i-2];
        }
        b = i;
        s = i;
      } else if(prices[i] > prices[s]){
        s = i;
      }
      profit[i] = prices[s]-prices[b] + profitsFromPrevTxns;
    }

    System.out.println(Arrays.toString(profit));

    return Arrays.stream(profit).max().getAsInt();

  }

}
