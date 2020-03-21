package stack.other;

public class KStacksInArray {
  int arr[];
  int prev[];
  int nextFree;
  int stop[];
  int n,k;

  public KStacksInArray(int k, int n) {
    this.n = n;
    this.k = k;
    arr = new int[n];
    prev = new int[n];
    stop = new int[k];
    nextFree = 0;

    // initialize stop
    for(int i = 0; i <k; i++){
      stop[i] = -1;
    }

    // initialize arr
    for(int i = 0; i <n-1; i++){
      arr[i] = i+1;
    }
    arr[n-1]= -1;
  }


  public void push(int value, int stackNumber){
    if(isFull()){
      System.out.println("MyStack is full");
      return;
    }

    int temp = arr[nextFree];
    arr[nextFree] = value;

    prev[nextFree]=stop[stackNumber];
    stop[stackNumber]= nextFree;
    nextFree = temp;

  }

  public int pop(int stackNumber){
    if(isEmpty(stackNumber)){
      return Integer.MIN_VALUE;
    }

    int poppedValue = arr[stop[stackNumber]];
    arr[stop[stackNumber]] = nextFree;
    nextFree = stop[stackNumber];
    stop[stackNumber] = prev[stop[stackNumber]];


    return poppedValue;
  }

  public boolean isFull() {
    return nextFree == -1;
  }

  public boolean isEmpty(int stackNumber) {
    return stop[stackNumber]==-1;
  }


  // Driver program
  public static void main(String[] args)
  {
    // Let us create 3 stacks in an array of size 10
    int k = 3, n = 10;

    KStacksInArray ks = new KStacksInArray(k, n);

    ks.push(15, 2);
    ks.push(45, 2);

    // Let us put some items in stack number 1
    ks.push(17, 1);
    ks.push(49, 1);
    ks.push(39, 1);

    // Let us put some items in stack number 0
    ks.push(11, 0);
    ks.push(9, 0);
    ks.push(7, 0);

    ks.push(71, 2);
    ks.push(72, 2);

    ks.push(81, 1);


    System.out.println("Popped element from stack 2 is " + ks.pop(2));
    System.out.println("Popped element from stack 1 is " + ks.pop(1));
    System.out.println("Popped element from stack 0 is " + ks.pop(0));

    ks.push(82, 1);

  }
}
