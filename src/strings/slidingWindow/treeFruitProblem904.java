package strings.slidingWindow;

import java.util.HashMap;

public class treeFruitProblem904 {

  public int totalFruit(int[] a) {
    HashMap<Integer, Integer> hm = new HashMap<>();
    int b = 0, e = 0, count = 0, max = 0;

    while(e<a.length){
      if(hm.containsKey(a[e]) && hm.get(a[e]) > 0){
        hm.put(a[e], hm.get(a[e])+1);
      } else {
        hm.put(a[e],1);
        count++;
      }

      while(count > 2){
        hm.put(a[b], hm.get(a[b])-1);
        if(hm.get(a[b]) == 0){
          count--;
        }
        b++;
      }

      max = Math.max(e-b+1, max);
      e++;
    }

    return max;

  }

}
