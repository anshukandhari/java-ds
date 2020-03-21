package heap;

public class MyHeap {
  int capacity, size;
  int A[];

  public MyHeap(int c){
    capacity = c;
    A = new int[c];
    size = 0;
  }

  int getParent(int i){
    return (i-1)/2;
  }

  void swap(int i, int j){
    int temp = A[i];
    A[i] = A[j];
    A[j]= temp;
  }

  int getLeftChild(int i){
    return 2*i+1;
  }

  int getRightChild(int i){
    return 2*i+2;
  }

  private void upHeapify(int idx) {
    while( idx != 0 && A[getParent(idx)] > A[idx]){
      swap(idx, getParent(idx));
      idx = getParent(idx);
    }
  }



  private void downHeapify(int idx){
    int l = getLeftChild(idx);
    int r = getRightChild(idx);
    int smallest = idx;


    if (l< size && A[l] < A[idx]){
      smallest = l;
    }
    if (r< size && A[r] < A[smallest]){
      smallest = r;
    }

    if (smallest != idx){
      swap(idx, smallest);
      downHeapify(smallest);
    }
  }


  public void push(int k){
    if (capacity > size){
      A[size] = k;
      upHeapify(size);
      size++;
    } else {
      System.out.println("Heap is full");
    }
  }


  public int extractMin(){
    if (size == 0) {
      System.out.println("The heap is empty");
      return -1;
    }
    int ans = A[0];
    A[0]= A[size-1];
    size--;
    downHeapify(0);
    System.out.println("Minimum element in the heap is "+ ans);
    return ans;
  }

  public void decreaseKey(int idx, int newValue){
    if(idx >= size || idx <0){
      return;
    }

    A[idx] = newValue;
    upHeapify(idx);
  }

  public void deleteKey(int idx){
    if(idx >= size || idx <0){
      return;
    }

    A[idx] = Integer.MIN_VALUE;
    upHeapify(idx);

    extractMin();

  }



  public static void main(String[] args) {
    MyHeap heap = new MyHeap(5);
    heap.push(5);
    heap.push(4);
    heap.push(3);
    heap.push(2);
    heap.push(1);
    heap.push(0);

    heap.extractMin();
    heap.extractMin();
    heap.extractMin();
    heap.extractMin();
    heap.extractMin();
    heap.extractMin();

  }
}
