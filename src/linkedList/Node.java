package linkedList;

/**
 * Created by anshukandhari on 3/28/19.
 */
public class Node {
  public Node next;
  public Integer data;

  // Creates an empty node.
  public Node(int d){
    data = d;
  }


  public Node getNext() {
    return next;
  }

  public int getData() {
    return data;
  }

  public void setNext(Node next) {
    this.next = next;
  }

  public void setData(int data) {
    this.data = data;
  }


}