import java.util.Queue;
import java.util.LinkedList;
import java.util.*;

public class ListDepths {
  public static void main(String[] args) {
    Node root = new Node(1);

    root.left = new Node(2);
    root.right = new Node(3);

    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7);

    List<LinkedList<Node>> heads = new ArrayList<>();
    heads.add(new LinkedList<Node>());

    createLists(root, heads);

    printLists(heads);
  }

  public static void createLists(Node root, List<LinkedList<Node>> heads) {
    int level = 0;
    Queue<Node> queue = new LinkedList<>();

    queue.add(root);
    queue.add(null);

    while(!queue.isEmpty()) {
      Node curr = queue.poll();

      if(curr != null) {
        heads.get(level).add(curr);
      }

      if(curr == null) {
        level++;
        queue.add(null);
        if(queue.peek() == null) {
          break;
        } else {
          heads.add(new LinkedList<Node>());
          continue;
        }
      }

      if(curr.left != null) {
        queue.add(curr.left);
      }

      if(curr.right != null) {
        queue.add(curr.right);
      }
    }
  }

  public static void printLists(List<LinkedList<Node>> list) {
    int level = 0;

    for(LinkedList<Node> l : list) {
      for(Node n : l) {
        System.out.println(n);
      }
      System.out.println("LEVEL: " + level++);
    }
  }

  public static void preOrder(Node root) {
    if(root == null) {
      return;
    }

    System.out.println(root);
    preOrder(root.left);
    preOrder(root.right);
  }

  private static class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
      this.value = value;
      left = right = null;
    }

    public String toString() {
      return String.valueOf(value);
    }
  }
}