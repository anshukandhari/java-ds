package stack;

public class MyStack {

  StackNode root;

  static class StackNode {
    int data;
    StackNode next;

    StackNode(int data) {
      this.data = data;
    }
  }

  public boolean isEmpty() {
    if (root == null) {
      return true;
    } else return false;
  }

  public void push(int data) {
    StackNode newNode = new StackNode(data);
    newNode.next = root;

    root = newNode;
  }

  public int pop() {
    int popped = Integer.MIN_VALUE;
    if (root == null) {
      System.out.println("MyStack is Empty");
    } else {
      popped = root.data;
      root = root.next;
    }
    return popped;
  }

  public int peek() {
    if (root == null) {
      System.out.println("MyStack is empty");
      return Integer.MIN_VALUE;
    } else {
      return root.data;
    }

  }


}
