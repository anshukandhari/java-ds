package dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class WordWrap {
  public static void wordWrap(String words[], int width) {
    int wl = words.length;
    int cost[][] = new int[wl][wl];
    int wd;

    for (int i = 0; i < wl; i++) {
      wd = width;
      for (int j = i; j < wl; j++) {
        if(wd != width){
          wd = wd -1;
        }
        if(wd - words[j].length() >= 0){
          wd -= words[j].length();
          cost[i][j] = wd*wd;
        } else {
          while(j<wl){
            cost[i][j] = Integer.MAX_VALUE;
            j++;
          }
        }
      }
    }

    int sol[] = new int[wl];
    int c[] = new int[wl];
    int min, res, tempCost;


    for(int i =wl-1; i>=0;i--){
      min = cost[i][wl-1];
      res = wl-1;
      for (int j = wl-1; j>=i;j--) {
        if(cost[i][j] == Integer.MAX_VALUE){
          continue;
        }
        tempCost = cost[i][j];
        if(j < wl-1){
          tempCost += c[j+1];
        }
        if(min > tempCost){
          min = tempCost;
          res = j;
        }
      }
      c[i]= min;
      sol[i] = res+1;
    }
  }



  public List<List<String>> wordWrap2(String words[], int width) {
    List<List<String>> sol = new ArrayList<>();

    if(words.length == 0 || width == 0){
      return sol;
    }

    ArrayList<String> currLine = new ArrayList<>();
    wordWrap2Util(words, width, sol, currLine, 0);
    return sol;

  }

  public void wordWrap2Util(String words[], int width, List<List<String>> sol, List<String> currLine, int idx) {
      if(idx == words.length){
        return ;
      }

  }

  /*public int wordWrap3(String words[], int width, int idx) {
    if(idx == words.length){
      return 0;
    }
    if(width)

    return Math.min(wordWrap3(words,width-words[idx].length()-1,idx+1)+ (int)Math.pow(width-words[idx].length(),3),
        wordWrap3(words,width,idx)+ (int)Math.pow(width,3) );
  }*/

  public static void main(String[] args) {
    String words[] = {"Tushar", "roy", "likes", "to", "code"};
    wordWrap(words, 10);
  }
}
