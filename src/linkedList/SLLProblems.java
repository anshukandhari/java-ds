package linkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by anshukandhari on 3/30/19.
 */
public class SLLProblems {
  Node temp;

  public int getLength(Node head){
    int len = 0;

    Node curr = head;
    while(curr != null){
      curr = curr.getNext();
      len++;
    }
    return len;
  }

  boolean compareLists(Node head1, Node head2)
  {
    Node temp1 = head1;
    Node temp2 = head2;

    while (temp1 != null && temp2 != null)
    {
      if (temp1.data == temp2.data)
      {
        temp1 = temp1.next;
        temp2 = temp2.next;
      } else
        return false;
    }

        /* Both are empty reurn 1*/
    if (temp1 == null && temp2 == null)
      return true;

        /* Will reach here when one is NULL
           and other is not */
    return false;
  }

  public Node reverseInSetOfK(Node h, int k){
    int l = getLength(h);
    if (h == null || h.getNext() == null || k > getLength(h)){
      return h;
    }

    Node p,q,r;
    p = null;
    q = h;
    r = q.getNext();

    for(int i = 0; i<k && r !=null; i++){
      q.setNext(p);
      p = q;
      q = r;
      r = r.getNext();
    }

    if(r == null){
      q.setNext(p);
      p = q;
      q = r;
    }
    h.setNext(reverseInSetOfK(q,k));

    return p;
  }

   public Node reverse(Node h){
    if (h == null || h.getNext() == null){
      return h;
    }

    Node p,q,r;
    p = null;
    q = h;
    r = q.getNext();

    do{
      q.setNext(p);
      p = q;
      q = r;
      r = r.getNext();
    } while (r != null);

    q.setNext(p);
    return q;
  }

  public Node recReverseUtil(Node h){
    if(h== null || h.getNext() == null){
      temp = h;
      return  h;
    }
    Node curr = recReverseUtil(h.getNext());
    curr.setNext(h);
    return h;
  }

  public Node recReverse(Node h){
    Node oldHead = recReverseUtil(h);
    oldHead.setNext(null);
    return temp;
  }


  public boolean isPalindromeRecUtil(Node h, Node r){
    temp = h;
    if( r == null ){
      return true;
    }

    boolean isp = isPalindromeRecUtil(temp,r.getNext());
    if (!isp) {
      return false;
    }

    if (temp.getData() == r.getData()) {
      temp = temp.getNext();
      return true;
    } else {
      return false;
    }

  }


  public Node getIntersectionNode(Node headA, Node headB) {
    Node a = headA, b = headB;
    int la = 0, lb = 0;

    while(a!=null){
      la++;
      a = a.next;
    }

    while(b != null){
      lb++;
      b = b.next;
    }

    if(lb < la){
      headA = advanceList(headA, la-lb);
    }

    if(la < lb){
      headB = advanceList(headB, lb-la);
    }


    while(headA != null && headB != null && headA != headB){
      headA = headA.next;
      headB = headB.next;
    }

    if(headA == null || headB == null)
      return null;

    return headA;

  }

  private Node advanceList(Node h, int k){
    while(h != null && k >0){
      h = h.next;
      k--;
    }

    return h;

  }

  // https://www.geeksforgeeks.org/maximum-sum-linked-list-two-sorted-linked-lists-common-nodes/
  // TODO : Almost done
  private Node maxSumList(Node l1, Node l2){
    if(l1 == null || l2 == null)
      return l1==null?l2:l1;


    Set<Integer> set = new HashSet<>();
    Node cur = l1;

    while(cur != null){
      set.add(cur.data);
      cur = cur.next;
    }

    int sum1 = 0, sum2 = 0;
    Node prev = null, l1start = l1, l2start = l2, cur1 = l1, cur2 = l2, head = null;

    while(cur1 != null && cur2 != null){
      if(set.contains(cur2.data)){
        if(sum1 > sum2){
          if(prev == null){
            head = l1start;
          } else {
            prev.next = l1start;
            prev = cur1;
          }
        } else {
          if(prev == null){
            head = l2start;
          } else {
            prev.next = l2start;
            prev = cur2;
          }
        }

        l1start = cur1;
        l2start = cur2;
      } else {
        sum1 += cur1.data;
        sum2 += cur2.data;
      }
      cur1 = cur1.next;
      cur2 = cur2.next;
    }

    while(cur1 != null){
      sum1 += cur1.data;
      cur1 = cur1.next;
    }

    while(cur2 != null){
      sum2 += cur2.data;
      cur2 = cur2.next;
    }


    if(sum1 > sum2){
      if(prev == null){
        head = l1start;
      } else {
        prev.next = l1start;
        prev = cur1;
      }
    } else {
      if(prev == null){
        head = l2start;
      } else {
        prev.next = l2start;
        prev = cur2;
      }
    }

    return head;
  }

  public static void main(String[] args) {
    SLLProblems sll = new SLLProblems();
    Node head = new Node(4);
    head.next = new Node(1);
    head.next.next = new Node(8);

    Node head2 = new Node(5);
    head2.next = new Node(0);
    head2.next.next = new Node(1);
    head2.next.next.next = head.next.next;

    System.out.println(sll.getIntersectionNode(head,head2).data);
  }



}
