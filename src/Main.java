import linkedList.LinkedList;
import linkedList.SLLUtil;

public class Main {

  public static void main(String[] args) {
    int[] A = {1,2,3,4,5,6};
    LinkedList ll = new LinkedList();

    SLLUtil sslu = new SLLUtil();

    ll.createFromArray(A);
    ll.print();

    // Reversing a linked list
    ll.setHead(sslu.recReverse(ll.getHead()));
    ll.printAndRefresh(A);


    // Reverse in set of K
    ll.setHead(sslu.reverseInSetOfK(ll.getHead(), 2));
    ll.printAndRefresh(A);

//    System.out.println(sslu.isPalindromeRecUtil(ll.getHead(),ll.getHead()));
  }




}
