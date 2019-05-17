package practiceJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ListIterator;
import sun.awt.SunHints.Value;


public class JavaCollections {
  /** Reading input
   *
   *  Scanner scan = new Scanner(System.in);
   *         int i = scan.nextInt();
   *         double d = scan.nextDouble();
   *         scan.nextLine(); // because nextInt/nextDouble doesn't read the end of the line and hence we need do this entry
   *         String s = scan.nextLine();
   *         scan.close();
   *
   * */

  /**
   * Do following with the Array/List
   * number of elements in the collection ==> size()
   * add element at a start, end, specific position
   * search for an element ==>  indexOf() will return -1 if not present
   * sort array
   * sort array based on a specific criteria
   * concatenate 2 arrays ==> addAll(Collection c)
   * add array in the middle of another array
   *
   *
   */
  public void performArrayListOperations(){
    Integer[] A = {4,6,2,3};
    ArrayList<Integer> al = new ArrayList();
    al.add(3);
    al.add(10);
    al.add(18);
    al.add(11);
    al.add(15);
    al.add(19);
    al.add(al.size(),-1);
    al.set(al.size()-1, 13);
    al.removeIf(o -> (o%19==0));
    al.remove(3);

    System.out.println(al);


    ArrayList<Integer> a2 = new ArrayList<>(Arrays.asList(A));

    al.addAll(3,a2);
    System.out.println(al);
    Collections.sort(al);
//    Collections.reverse(al);
    System.out.println(al);
    System.out.printf("The size of the Arraylist is %d, index of 18 is %d and index of 10 is %d", al.size(), al.indexOf(18), al.indexOf(120));


    ListIterator<Integer> itr = al.listIterator();
    int x =0;
    while(itr.hasNext()){
//      x = itr.next();
      itr.forEachRemaining(System.out::println);
//      if(al.indexOf(26-x) > 0 ){
//        System.out.println(x);
    }


//    al.sort();

  }



  /**
   * Do following with the Map/Set
   * search for a key
   * Map having Map as its value
   * Iterate over a map with a criteria
   * Threadsafe map ==> use Hashtable
   *
   */
  public void performHashMapOperations(){
    int A[] = {2, 3, 3, 4, 6, 10, 13, 15, 18, 10};
    HashMap<Integer,Integer> hm = new HashMap<>();

    for (int i=0; i< A.length; i++){
      if(hm.containsKey(A[i])){
        hm.put(A[i], hm.get(A[i])+1);
      } else {
        hm.put(A[i],1);
      }
    }
    int target =24;

    for (Integer key : hm.keySet()) {
      hm.put(key, hm.get(key)-1);
      if(hm.get(target-key)!= null && hm.get(target-key) >0){
        System.out.printf("Values are %d and %d", key, target-key);
      }
    }

//    System.out.println(hm);
  }

  /**
   * String Operations
   * iterate through each character
   */

    // Iterate over characters of a String
    public void stringOperations() {
      String s = "Techie Delight";

      // convert String to char[] array
      char[] chars = s.toCharArray();

      // iterate over char[] array using enhanced for loop
      for (char ch : chars) {
        System.out.print(ch);
      }

      HashSet hs = new HashSet();
//      String s = "Anshu";

    }

}
