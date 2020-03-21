package dynamicProgramming.leetcode;

//https://leetcode.com/discuss/interview-question/348510
// TODO
public class GoogleInterviewCakeCutting {

  /*public double largestCakePiece(int radius[], int totalGuests){
    double a[][] = new double[][radius.length];

//    for(int i = 0; i < radius.length; i++){
//      a[i] = 3.14*(double)(radius[i]*radius[i]);
//    }

    double dp[][] = new double[radius.length+1][totalGuests];

    for(int i = 0; i< dp.length; i++){
      for(int j = 0; j < dp[0].length; j++){
        if(i == 0 || j == 0){
          dp[i][j] = 0;
        } else {
          dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        }
      }
    }
    return 0;

  }


  public double largestCakePiece(int a[], int totalGuests){
    if(a.length == 0){
      return 0;
    }

    if(a.length == 1){
      return a[0]/totalGuests;
    }

    
  }
*/


}
