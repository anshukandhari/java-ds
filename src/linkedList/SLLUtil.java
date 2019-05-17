package linkedList;

/**
 * Created by anshukandhari on 3/30/19.
 */
public class SLLUtil {
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



}
