import java.util.ArrayList;
import linkedList.LinkedList;
import linkedList.SLLUtil;
import practiceJava.JavaCollections;
import projecteuler.ProjectEulerSet1;

public class Main {


  public static void main(String[] args) {

//    JavaCollections jc = new JavaCollections();
//    jc.performArrayListOperations();
//    jc.performHashMapOperations();
//    ProjectEulerTest();
      linkedListTest();

  }
  private static void ProjectEulerTest() {
    ProjectEulerSet1 projectEulerSet1 = new ProjectEulerSet1();

    /**
     * int[] A = {3,5};
     * System.out.println(projectEulerSet1.findSumOfMultiples(A,1000));
     * System.out.println(projectEulerSet1.fibonacciEvenSum(4000000));
     * System.out.println(projectEulerSet1.maxPrimeFactor(600851475143L));
     * System.out.println(projectEulerSet1.maxPalindrome());
     * System.out.println(projectEulerSet1.findLCMOfRange(1,20));
     * */
    System.out.println(projectEulerSet1.sumSquareDifference());


  }

  private static void linkedListTest() {
    int[] A = {1,2,3,4,5,6};
    LinkedList ll = new LinkedList();

    SLLUtil sslu = new SLLUtil();

    ll.createFromArray(A);
    /*ll.print();



    // Reversing a linked list
    ll.setHead(sslu.recReverse(ll.getHead()));
    ll.printAndRefresh(A);

    // Reverse in set of K
    ll.setHead(sslu.reverseInSetOfK(ll.getHead(), 2));
    ll.printAndRefresh(A);*/
    //    System.out.println(sslu.isPalindromeRecUtil(ll.getHead(),ll.getHead()));
  }


}
