package collectionCheatSheet;

import java.util.Arrays;


public class ArrayCheatSheet {
  /**
   * Notes:
   * 1. Cant change size of array in Java
   * 2. When passed into a method, they are passed as reference and the contents of an array are muteable
   * 3. For Pass by value/reference check : https://stackoverflow.com/a/40523
   */


  public static void main(String[] args) {
    int[] odds = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};

    // Arrays.toString()
    System.out.println("odds is "+ Arrays.toString(odds));
    // Arrays.binarySearch()
    System.out.println(" binary searching 19 in odds: " + Arrays.binarySearch(odds, 19));

    System.out.println(" binary searching 9 at first 5 location in odds: " + Arrays.binarySearch(odds, 19));

    // Arrays.copyOf()
    int a[] = Arrays.copyOf(odds, odds.length -3);

    // Arrays.copyOfRange()
    int b[] = Arrays.copyOfRange(odds,odds.length-3, odds.length);

    System.out.println("a is "+ Arrays.toString(a));
    System.out.println("b is "+ Arrays.toString(b));

    // Arrays.equals()
    // Arrays.fill

    // We cant use comparators for primitive data types. Hence cannot sort this in reverse order using library directly.
    // Check https://www.baeldung.com/java-sorting-arrays
    Arrays.sort(a);
    for (int val: a) {
      System.out.print(val + " ");
    }
  }

}
