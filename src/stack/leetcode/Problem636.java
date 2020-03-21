package stack.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//Exclusive Time Of Function
public class Problem636 {

  public int[] exclusiveTime(int n, List<String> logs) {

    // start => push to stack and whatever is there on the top, update its count
    // stop => pop from the stack, update the sol array, update the start of the next top
    // {id, count, last_start}


    int sol[] = new int[n];
    LinkedList<int []> st = new LinkedList<>();

    String currEntry[];
    int timeNow, id, lastEntry[];

    for(String str : logs){
      currEntry = str.split(":");
      timeNow = Integer.valueOf(currEntry[2]);
      id = Integer.valueOf(currEntry[0]);

      if(currEntry[1].equals("start")){

        if(st.size()>0){
          lastEntry = st.removeLast();
          lastEntry[1] += timeNow-lastEntry[2];
          st.add(lastEntry);
        }
        st.add(new int[]{id, 0, timeNow});

      } else {
        lastEntry = st.removeLast();
        sol[id] = timeNow - lastEntry[2] + 1 +  lastEntry[1];

        //update the new top (if any) with the start
        if(st.size()>0){
          lastEntry =  st.removeLast();
          lastEntry[2] = timeNow+1;
          st.add(lastEntry);
        }
      }

    }

    return sol;
  }

  public static void main(String[] args) {
    Problem636 lc = new Problem636();
    List<String> l = new LinkedList<>(Arrays.asList("0:start:0","1:start:2","1:end:5","0:end:6"));
    lc.exclusiveTime(2, l);
  }

}
