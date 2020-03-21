package queue;

public class CircularQueue {
  int q[];
  int f = -1, r = -1;
  /** Initialize your data structure here. Set the size of the queue to be k. */
  public CircularQueue(int k) {
    q = new int[k];
  }

  /** Insert an element into the circular queue. Return true if the operation is successful. */
  public boolean enQueue(int value) {
    if(isFull())
      return false;

    if(f == -1){
      f = 0;
      r = 0;
    } else if(r == q.length-1){
      r = 0;
    } else {
      r++;
    }
    q[r] = value;
    return true;
  }

  /** Delete an element from the circular queue. Return true if the operation is successful. */
  public boolean deQueue() {
    if(isEmpty())
      return false;

    if(f == r){
      f = -1;
      r = -1;
    } else if (f == q.length-1){
      f = 0;
    } else {
      f++;
    }

    return true;
  }

  /** Get the front item from the queue. */
  public int Front() {
    return q[f];
  }

  /** Get the last item from the queue. */
  public int Rear() {
    return q[r];
  }

  /** Checks whether the circular queue is empty or not. */
  public boolean isEmpty() {
    return f == -1;
  }

  /** Checks whether the circular queue is full or not. */
  public boolean isFull() {
    return (f == 0 && r == q.length-1) || (f == r+1);
  }

  public static void main(String[] args) {
    CircularQueue cq = new CircularQueue(6);
    cq.enQueue(6);
    cq.deQueue();
    cq.enQueue(5);
    cq.deQueue();
    cq.deQueue();
    cq.deQueue();
    cq.deQueue();
    cq.deQueue();
  }

}
