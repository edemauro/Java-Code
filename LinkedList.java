public class LinkedList {
  Node head;
  Node tail;

  public static void main(String[] args) {
    LinkedList list = new LinkedList();
    for(int i = 5; i > 0; i--) {
      list.insert(new Node(i));
    }

    System.out.println(list.mToLast(4));

    LinkedList list2 = new LinkedList();

    list.insert(new Node(5));
  }

  public LinkedList() {
    head = tail = null;
  }

  public Node getHead() {
    return head;
  }

  public Node getTail() {
    return tail;
  }

  public void setTail(Node elem) {
    tail = elem;
  }

  public Node mToLast(int n) {
    Node curr, behindPtr;

    curr = behindPtr = head;

    for(int i = 0; i < n; i++) {
      curr = curr.next();
    }

    if(curr == null) {
      return null;
    }

    while(curr.next() != null) {
      curr = curr.next();
      behindPtr = behindPtr.next();
    }

    return behindPtr;
  }

  public void flatten() {

  }

  public void unflatten() {

  }

  public Node insert(Node elem) {
    if(head != null) {
      elem.next = head;
      head.prev = elem;
    }

    head = elem;

    return elem;
  }

  private static class Node {
    int data;
    Node next;
    Node prev;
    Node child;

    public Node(int data) {
      this(data, null, null, null);
    }

    public Node(int data, Node next, Node prev, Node child) {
      this.data = data;
      this.next = next;
      this.prev = prev;
      this.child = child;
    }

    public Node next() {
      return next;
    }

    public Node prev() {
      return prev;
    }

    public Node child() {
      return child;
    }

    public void setNext(Node elem) {
      next = elem;
    }

    public void setPrev(Node elem) {
      prev = elem;
    }

    public void setChild(Node elem) {
      child = elem;
    }

    public String toString() {
      return String.valueOf(data);
    }
  }
}