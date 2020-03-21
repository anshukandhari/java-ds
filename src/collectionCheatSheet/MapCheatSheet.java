package collectionCheatSheet;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. capacity = number of buckets * load factor
 * 2. HashMap starts with storing Entry objects in linked list but after the number of items in a hash becomes larger than a certain threshold,
 * the hash will change from using a linked list to a balanced tree, which will improve the worst case performance from O(n) to O(log n)
 */
public class MapCheatSheet {

  public static void main(String[] args) {
    // basic
    HashMap<String, String> days = new HashMap<>();
    days.put("Mon", "Monday");
    days.put("Tues", "Tuesday");
    String day = days.get("Mon");
    System.out.println(days);

    // accessing
    days.isEmpty();
    days.size();
    days.get("nothing"); // returns null
    days.getOrDefault("nothing", "DEAULT");
    days.containsKey("Mon");
    days.containsValue("Noday");

    // copy
    HashMap<String, String> daysCopy = new HashMap<>(days);

    // mutate
    daysCopy.clear();
    HashMap<String, String> months = new HashMap<>();
    months.put("Jan", "January");
    String val = months.putIfAbsent("Feb", "NeverUsed"); // returns "January"
    months.putAll(days); // puts all elements from days into months
//      .merge() // ?
//      .compute() // ?
    months.remove("Mon");
    months.remove("Tues", "Tuesday"); // remove only if Tues is mapped ot Tuesday
    months.replace("Festivus", "Christmas"); // replace entry only if is currently mapped to some value
    months.replace("Jan", "NonJanuary", "January"); // replace entry only if is currently mapped to given value
    months.replaceAll((k, v) -> "NEW" + k + v); // replace each entry value with result of given function

    // iterating
    for (String key : days.keySet()) {
      System.out.println(days.get(key));
    }
    for (Map.Entry<String, String> entry: months.entrySet()) {
      System.out.println("Key:" + entry.getKey() + " Value:" + entry.getValue());
    }

  }

}
