package queue.leetcode;

import java.util.HashMap;

public class LRUCache {
  class ListNode{
    ListNode next;
    ListNode prev;
    int key;
    int val;

    public ListNode(int key, int val){
      this.key = key;
      this.val = val;
    }
  }

  ListNode head, tail;

  HashMap<Integer, ListNode> hm = new HashMap<>();
  int capacity;

  public LRUCache(int capacity) {
    this.capacity = capacity;
  }

  public int get(int key) {
    if(hm.containsKey(key)){
      ListNode t = hm.get(key);
      bringToFront(t);
      return t.val;
    }
    return -1;
  }

  public void put(int key, int value) {
    if(hm.containsKey(key)){
      ListNode t = hm.get(key);
      bringToFront(t);
      t.val = value;
    } else {
      ListNode n = new ListNode(key, value);
      if(head == null){
        head = n;
        tail = n;
      } else {
        head.prev = n;
        n.next = head;
        head = n;
      }
      hm.put(key,n);

      if(hm.size() > capacity){
        removeNode();
      }
    }
  }

  private void removeNode(){
    hm.remove(tail.key);
    tail = tail.prev;
    tail.next = null;
  }

  private void bringToFront(ListNode t){
    if (t == head){
      return;
    }


    t.prev.next = t.next;
    if(t == tail){
      tail = t.prev;
    } else {
      t.next.prev = t.prev;
    }

    head.prev = t;
    t.next = head;
    head = t;
  }

  public static void main(String[] args) {
    LRUCache lru = new LRUCache(3);
    lru.put(1,1);
    lru.put(2,2);
    lru.put(3,3);
    lru.put(4,4);
    lru.get(4);
    lru.get(3);
    lru.get(2);
    lru.get(1);
    lru.put(5,5);
    lru.get(1);
    lru.get(2);
    lru.get(3);
    lru.get(4);
    lru.get(5);
  }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */