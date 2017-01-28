import java.util.LinkedList;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Set;
import java.util.Queue;
import java.util.List;

public class GraphSearch {
  static Set<Node> visited = new HashSet<Node>();

  public static void main(String[] args) {
    List<Node> adjList = init();

    DFS(adjList.get(0));

    visited.clear();

    BFS(adjList.get(0));
  }

  public static void DFS(Node root) {
    if(root == null) {
      return;
    }

    visited.add(root);
    System.out.println(root);

    for(Node n : root.neighbors) {
      if(!visited.contains(n)) {
        DFS(n);
      }
    }
  }

  public static void BFS(Node root) {
    Queue<Node> queue = new LinkedList<Node>();

    queue.add(root);

    while(!queue.isEmpty()) {
      Node curr = queue.poll();
      visited.add(curr);
      System.out.println(curr);

      for(Node n : curr.neighbors) {
        if(!visited.contains(n)) {
          queue.add(n);
        }
      }
    }
  }

  public static List<Node> init() {
    List<Node> adjList = new ArrayList<Node>();
    Node zero = new Node(0);
    Node one = new Node(1);
    Node two = new Node(2);
    Node three = new Node(3);
    Node four = new Node(4);
    Node five = new Node(5);

    zero.add(one);
    zero.add(four);
    zero.add(five);

    one.add(three);
    one.add(four);

    two.add(one);

    three.add(two);
    three.add(four);

    adjList.add(zero);
    adjList.add(one);
    adjList.add(two);
    adjList.add(three);
    adjList.add(four);
    adjList.add(five);

    return adjList;
  }

  private static class Node {
    int value;
    Set<Node> neighbors;

    public Node(int value) {
      this.value = value;
      neighbors = new HashSet<Node>();
    }

    public void add(Node e) {
      neighbors.add(e);
    }

    public String toString() {
      return String.valueOf(value);
    }
  }
}