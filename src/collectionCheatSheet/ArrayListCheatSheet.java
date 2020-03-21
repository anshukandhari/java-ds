package collectionCheatSheet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class ArrayListCheatSheet {

  public static void main(String[] args) {
    int[] a = {14,16,12,13};

    // ############# BASICS ##################
    // Array to ArrayList
    ArrayList<Integer> al = new ArrayList();

    // Following will fail since we are trying to add the int array to Integer ArrayList.
    //    al.addAll(Arrays.asList(a));

    // adds at the end
    al.add(31);
    // adds at the beginning
    al.add(0,-1);
    al.addAll(Arrays.asList(1,2,3,4,5));

    // this requires cast
    ArrayList<Integer> clone = (ArrayList<Integer>)al.clone();

    clone.clear();

    List<Integer> clone2 = al.subList(1, 3);

    System.out.println(al);


    // Accessing
    System.out.println("Is list empty: "+ al.isEmpty());
    System.out.printf("The size of the Arraylist is %d, index of 13 is %d and value at index 2 is %d", al.size(), al.indexOf(13), al.get(2));
    System.out.println("Checking if list contains -1" + al.contains(-1));


    // mutation
    al.set(1, 99); // set index 1 to value 99
    al.remove(2); // by index
    al.remove((Integer)8); // by value (cast used to force use of the Object overload
    al.removeIf(o -> (o%19==0));

    Collections.sort(al);
//    Collections.reverse(al);
    System.out.println(al);




    ListIterator<Integer> itr = al.listIterator();
    int x =0;
    while(itr.hasNext()){
//      x = itr.next();
      itr.forEachRemaining(System.out::println);
//      if(al.indexOf(26-x) > 0 ){
//        System.out.println(x);
    }


  }

}
