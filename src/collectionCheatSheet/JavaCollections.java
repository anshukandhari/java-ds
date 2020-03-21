package collectionCheatSheet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;


public class JavaCollections {

  // To compare 2 non-primitive data type use .equals i.e. stack1.peek() == stack2.peek() will fail
  // https://github.com/SirGnip/JavaCheatSheets/tree/master/src
  // https://github.com/nlharri/JavaCollectionsFrameworkCheatSheet/blob/master/javacollectionsframeworkexamples/JavaCollectionsFrameworkExamples.java


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

      int length = s.length();


      // convert String to char[] array
      char[] chars = s.toCharArray();

      // we can use s.charAt(i) also to get the characters


      // iterate over char[] array using enhanced for loop
      for (char ch : chars) {

        System.out.print(ch);

      }


      HashSet hs = new HashSet();
//      String s = "Anshu";

    }


    public void stackOperations(){
      Stack<Character> s = new Stack<>();
    }

    public void heapOperation(){

    }

  public static void main(String[] args) {
    ArrayList<Integer> al = new ArrayList<>();
    al.add(0,12);
    al.add(1,10);
    al.add(0,101);
    JavaCollections jc = new JavaCollections();
    jc.heapOperation();

  }

}
