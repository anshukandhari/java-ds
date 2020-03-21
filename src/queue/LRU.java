package queue;

import java.util.HashMap;
import linkedList.DLL;

public class LRU {

  int capacity;
  DLL dll;
  HashMap<Integer,DLL.ListNode> hm;

  public LRU(int capacity){
    this.capacity = capacity;
    hm = new HashMap<>();
    dll = new DLL();
  }

  public void refer(int n){
    if(hm.containsKey(n)){
      dll.remove(hm.get(n));
      hm.remove(n);
    } else {
      if (hm.size() == capacity){
        Integer removedValue = dll.removeLast();
        hm.remove(removedValue);
      }
    }
    DLL.ListNode node = new DLL.ListNode(null,null,n);
    dll.addFirst(node);
    hm.put(n,node);
  }

  public static void main(String[] args) {
    LRU lru = new LRU(4);
    lru.refer(10);
    lru.refer(20);
    lru.refer(30);
    lru.refer(40);
    lru.refer(50);
    lru.refer(20);
    lru.refer(60);
    System.out.println(lru.hm);
    lru.dll.print();


  }





}
