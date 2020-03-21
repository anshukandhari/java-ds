package strings.slidingWindow;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class SmallestSequentiallyMatchingSubarray {
  class SubArray{
    int start;
    int end;
  }
  public SubArray findSmallestSubArrayHavingAllKeywordsInOrder(List<String> text, List<String> keywords){
    SubArray result = new SubArray();
    int minWindow = text.size();

    HashMap<String,Integer> keyToIdx = new HashMap<>();
    LinkedList<Integer> lastOccurence = new LinkedList<>();
    LinkedList<Integer> distanceFromStart = new LinkedList<>();

    for(int i = 0; i< keywords.size(); i++) {
      keyToIdx.put(keywords.get(i), i);
      lastOccurence.add(-1);
      distanceFromStart.add(Integer.MAX_VALUE);
    }


    for(int i = 0; i<text.size(); i++) {
      String s = text.get(i);

      if (!keyToIdx.containsKey(s))
        continue;

      int idx = keyToIdx.get(s);
      if (idx == 0) {
        distanceFromStart.set(idx, 0);
      } else {
        if (lastOccurence.get(idx - 1) == Integer.MAX_VALUE) {
          continue;
        }

        int distanceFromPrev = i - lastOccurence.get(idx - 1);
        distanceFromStart.set(idx, distanceFromPrev + distanceFromStart.get(idx - 1));

        if (idx == keyToIdx.size() - 1 && distanceFromStart.get(idx) < minWindow) {
          minWindow = distanceFromStart.get(idx);
          result.start = i - minWindow;
          result.end = i;
        }
      }
    }
    return result;
  }

}
