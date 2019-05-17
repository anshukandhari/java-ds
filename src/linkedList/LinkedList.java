package linkedList;

/**
 * Created by anshukandhari on 3/28/19.
 */
public class LinkedList {

  public void setHead(Node head) {
    this.head = head;
  }

  private Node head;
  private int length;

  public LinkedList(){
    length = 0;
  }

  public int getLength(){
    return length;
  }

  public Node getHead() {
    return head;
  }


  public boolean isEmpty(){
    return head == null;
  }

  public void prepend(Integer integer){
    inserAtIndex(0, integer);
  }

  public void append(Integer integer){
    inserAtIndex(length-1 , integer);
  }

  public void inserAtIndex(int index, int val) {

    if(index < 0 || index > length)
      throw new IllegalArgumentException("Add failed. Illegal index.");

    Node newNode = new Node(val);

    if (index == 0) {
        if(head != null) {
          newNode.setNext(head.getNext());
        }
        head = newNode;
    } else {
      Node curr = head;
      for(int i = 0 ; i < index -1 ; i ++) {
        curr = curr.getNext();
      }

      newNode.setNext(curr.getNext());
      curr.setNext(newNode);
    }
    length++;
  }


  public void removeAtIndex(int index){
    if (isEmpty()){
      System.out.println("List is empty");
      return;
    }

    if(index < 0 || index >= length)
      throw new IllegalArgumentException("Remove failed. Index is illegal.");


    Node retNode, curr;
    if (index == 0) {
      retNode = head;
      head = head.getNext();
    } else {
      curr = head;
      for (int i = 0; i < index - 1; i++)
        curr = curr.getNext();

      retNode = curr.getNext();
      curr.setNext(retNode.getNext());

    }
    System.out.println("Node  has been removed with data " + retNode.getData());
    length--;
  }

  public void removeFromBegin(){
    removeAtIndex(0);
  }

  public void removeFromEnd(){
    removeAtIndex(length - 1);
  }


  public Node getAtIndex(int index){

    if(index < 0 || index >= length)
      throw new IllegalArgumentException("Get failed. Illegal index.");

    Node cur = head;
    for(int i = 0 ; i < index ; i ++)
      cur = cur.getNext();
    return cur;
  }



  public Node getLast(){
    return getAtIndex(length - 1);
  }


  public void set(int index, int val){
    getAtIndex(index).setData(val);
  }

  public int FindIndexOfElement(int val){

    int index = 0;
    if(head.getData() == val){
      return index;
    } else {
      Node curr = head;
      while(curr.getNext() != null){
        if(curr.getNext().getData()== val){
          return index;
        }
        curr = curr.getNext();
        index++;
      }
    }
    return -1;
  }




  public void removeElement(int val){
    if(head.getData() == val){
      head = head.getNext();
    } else {
      Node prev = head;
      while(prev.getNext() != null){
        if(prev.getNext().getData()==val){
          prev.setNext(prev.getNext().getNext());
          break;
        }
        prev = prev.getNext();
      }
    }
  }

  public void print(){
    StringBuilder res = new StringBuilder();

    Node cur = head;
    while(cur != null){
      res.append(cur.getData() + "->");
      cur = cur.getNext();
    }

    System.out.println("The list is : "+ res);
  }

  public void truncate(){
    head = null;
  }

  public void createFromArray(int[] A){
    for (int i = 0; i < A.length; i++){
      inserAtIndex( i, A[i]);
    }

    int totalNodes = 0;
    for (Node temp = head; temp != null; temp= temp.next){
      totalNodes++;
    }
    System.out.println("Total nodes are"+ totalNodes);
  }

  public void printAndRefresh(int [] A) {
    print();
    truncate();
    createFromArray(A);

  }

}
