package heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {

    int count;
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;


    /** initialize your data structure here. */
    public MedianFinder() {
      count = 0;
      minHeap = new PriorityQueue<>();
      maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {
      count++;
      if(minHeap.size() == 0){
        minHeap.offer(num);
        return;
      }

      if(count%2 == 1){
        if (num < maxHeap.peek()){
          int t = maxHeap.poll();
          maxHeap.offer(num);
          minHeap.offer(t);
        } else {
          minHeap.offer(num);
        }
      } else {
        if (num > minHeap.peek()){
          int t = minHeap.poll();
          minHeap.offer(num);
          maxHeap.offer(t);
        } else {
          maxHeap.offer(num);
        }
      }

    }

    public double findMedian() {
      if(count%2 == 1){
        return Double.valueOf(minHeap.peek());
      } else {
        return (Double.valueOf(minHeap.peek()) + Double.valueOf(maxHeap.peek()))/2;
      }
    }

  public static void main(String[] args) {
    MedianFinder obj = new MedianFinder();
    obj.addNum(1);
    obj.addNum(2);
    System.out.println(obj.findMedian());
    obj.addNum(3);
    obj.addNum(4);
    obj.addNum(5);
    System.out.println(obj.findMedian());
  }


}
