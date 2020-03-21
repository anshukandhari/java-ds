package collectionCheatSheet;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetCheatSheet {

  public static void main(String[] args) {
    Set<Integer> items = new HashSet<>();
    items.add(42); // returns true if no element present, false if present

    items.addAll(Arrays.asList(2,3,4,5,6,8,11,12, 13,22));

    items.removeAll(Arrays.asList(2, 13));

    System.out.println(items.containsAll(Arrays.asList(3,5)));

    items.retainAll(Arrays.asList(42, 4, 6, 8, 11));
    System.out.println(Arrays.toString(items.toArray()));


    for (Integer i: items) {
      System.out.println(i);
    }
  }
}
