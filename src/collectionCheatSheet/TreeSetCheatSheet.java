package collectionCheatSheet;

import java.util.Arrays;
import java.util.TreeSet;

public class TreeSetCheatSheet {

  public static void main(String[] args) {
    TreeSet<Integer> ts = new TreeSet<>(Arrays.asList(3,4,1,2,6,5,7,8));

    System.out.println(ts.pollFirst()); // poll lowest element
    System.out.println(ts.pollLast()); // poll highest element


    System.out.println(ts.first()); // lowest element
    System.out.println(ts.last()); // highest element

    System.out.println(ts.lower(5)); // highest element that is strictly lower
    System.out.println(ts.higher(5)); // lowest element that is strictly higher


    System.out.println(ts.floor(5)); // highest element that is not strictly lower i.e. <= this element
    System.out.println(ts.ceiling(5)); // lowest element that is not strictly higher i.e. >= this element


  }

}
