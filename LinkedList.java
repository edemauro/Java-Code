public class LinkedList {
  Node head;
  Node tail;

  public static void main(String[] args) {
    LinkedList list = new LinkedList();
    list.insert(new Node(5));
    list.insert(new Node(6));
    System.out.println(list.getHead().next());
  }

  public LinkedList() {
    head = tail = null;
  }

  public Node getHead() {
    return head;
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
      this.data = data;
      next = prev = child = null;
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