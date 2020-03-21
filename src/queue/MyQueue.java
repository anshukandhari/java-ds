package queue;

public class MyQueue {

  int front, rear;
  int capacity;
  int array[];

  public MyQueue(int capacity){
    this.capacity = capacity;
    front = -1;
    rear = -1;
    array = new int[this.capacity];

  }


  boolean isFull(){
    return (size() == capacity);
  }

  // Queue is empty when size is 0
  boolean isEmpty(){
    return size() == 0;
  }


  void enqueue(int item){
    if (isFull())
      return;

    if(isEmpty()){
      front = 0;
    }

    this.rear = (this.rear + 1)%this.capacity;
    this.array[this.rear] = item;
    System.out.println(item+ " enqueued to queue");
  }


  int dequeue(){
    if (isEmpty())
      return Integer.MIN_VALUE;

    int item = array[front];
    front = (front + 1)%capacity;
    return item;
  }


  int front() {
    if (isEmpty())
      return Integer.MIN_VALUE;

    return array[front];
  }


  int rear(){
    if (isEmpty())
      return Integer.MIN_VALUE;

    return this.array[this.rear];
  }

  public int size(){
    if (front == -1){
      return 0;
    }

    if (rear<front){
      return rear-front +1 + capacity;
    }

    return rear-front+1;
  }

  public static void main(String[] args)
  {
    MyQueue queue = new MyQueue(4);

    queue.enqueue(10);
    queue.enqueue(20);
    queue.enqueue(30);
    queue.enqueue(40);

    System.out.println(queue.dequeue() +
        " dequeued from queue\n");

    queue.enqueue(50);

    System.out.println(queue.dequeue() +
        " dequeued from queue\n");

    queue.enqueue(60);

    System.out.println("Front item is " +
        queue.front());

    System.out.println("Rear item is " +
        queue.rear());

    System.out.println(queue.size());
  }
}
