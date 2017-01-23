import java.util.*;

public class LinkedList {
  private Node head;
  private Node tail;

  public static void main(String[] args) {
    LinkedList list = new LinkedList();
    for(int i = 5; i > 0; i--) {
      list.insert(new Node(i));
    }

    // System.out.println(list.mToLast(4));

    Node a = new Node(5);
    Node b = new Node(33);
    Node c = new Node(17);
    Node d = new Node(2);
    Node e = new Node(1);

    LinkedList list2 = new LinkedList();
    list2.insert(e);
    list2.insert(d);
    list2.insert(c);
    list2.insert(b);
    list2.insert(a);

    Node f = new Node(6);
    Node g = new Node(25);

    f.setNext(g);
    g.setPrev(f);
    a.setChild(f);

    list2.flatten();

    Node ptr = list2.getHead();

    while(ptr != null) {
      System.out.println(ptr);
      ptr = ptr.next();
    }

    System.out.println("");
    System.out.println(list2.getTail());
    System.out.println("");
    list2.unflatten();

    ptr = list2.getHead();

    while(ptr != null) {
      System.out.println(ptr);
      ptr = ptr.next();
    }

    System.out.println("");
    System.out.println(list2.getTail());
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
    Node curr = head;

    while(curr.next() != null) {
      if(curr.child != null) {
        appendToList(curr.child, tail);
      }
      curr = curr.next();
    }

    tail = curr;
  }

  public void appendToList(Node child, Node tail) {
    tail.setNext(child);
    child.setPrev(tail);

    while(child != null) {
      child = child.next();
    }

    tail = child;
  }

  public void unflatten() {
    Node curr = head;

    explore(head);

    for(; curr != null; curr = curr.next())
    tail = curr;
  }

  public void explore(Node start) {
    Node curr = start;
    while(curr != null) {
      if(curr.child != null) {
        curr.child.prev.next = null;
        curr.child.setPrev(null);
        explore(curr.child);
      }

      curr = curr.next();
    }
  }

  public Node insert(Node elem) {
    if(head == null) {
      head = tail = elem;
    } else {
      elem.next = head;
      head.prev = elem;
      head = elem;
    }

    return elem;
  }

  private static class Node {
    private int data;
    private Node next;
    private Node prev;
    private Node child;

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