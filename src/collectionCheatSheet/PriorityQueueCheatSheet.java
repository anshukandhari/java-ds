package collectionCheatSheet;

import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueCheatSheet {

  public static void main(String[] args) {
    System.out.println("In queues offer is same as add and poll is same as remove. These are preferred method since they dont throw generic exceptions.");
    System.out.println("Min Heap Implementation");
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    pq.add(5);
    pq.offer(4);
    pq.offer(3);
    pq.offer(2);
    pq.offer(1);
    pq.remove(4);

    while(pq.size()>0) {
      System.out.println(pq.poll());
    }


    System.out.println("Max Heap Implementation");
    PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
    pq2.add(1);
    pq2.add(2);
    pq2.offer(3);
    pq2.offer(4);
    pq2.offer(5);
    while(pq2.size()>0) {
      System.out.println(pq2.poll());
    }

    System.out.println("Top of the heap is :"+pq.peek());
    System.out.println("Check how to implement custom comparator at https://www.callicoder.com/java-priority-queue/");
  }

}
