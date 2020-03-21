package linkedList;

public class DLL {
  public static class ListNode{
    private ListNode prev;
    private ListNode next;
    private Integer value;

    public ListNode(ListNode prev, ListNode next, Integer value) {
      this.prev = prev;
      this.next = next;
      this.value = value;
    }
  }

  ListNode head, tail;

  public boolean isEmpty(){
    return head == null;
  }

  public void addFirst(ListNode node){
    if(head == null){
      head = node;
      tail = node;
    } else {
      node.next = head;
      head.prev = node;
      head = node;
    }
  }

  public void addLast(ListNode node){
    if(head == null){
      head = node;
      tail = node;
    } else {
      node.prev = tail;
      tail.next = node;
      tail = node;
    }
  }

  public void remove(ListNode node){
    if (node == null){
      return;
    }

    if (node == head) {
      if (head == tail){
        head = null;
        tail = null;
        return;
      }
      head = head.next;
      head.prev = null;
      return;
    }

    if (node == tail){
      node.prev.next = node.next;
      tail = node.prev;
      return;
    }

    node.prev.next = node.next;
    node.next.prev = node.prev;
  }

  public Integer removeLast(){
    if (head == null){
      return null;
    }

    Integer ans = tail.value;

    if (head == tail){
      head = null;
      tail = null;
    } else{
      tail.prev.next = tail.next;
      tail = tail.prev;
    }

    return ans;
  }

  public void print(){
    StringBuilder res = new StringBuilder();

    ListNode cur = head;
    while(cur != null){
      res.append(cur.value + "->");
      cur = cur.next;
    }

    System.out.println("The list is : "+ res);
  }

}
