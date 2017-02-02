public class LCA {
  public static void main(String[] args) {
    Node root = init();

    System.out.println(LCA(root, 7, 9));
  }

  private static Node init() {
    Node root = new Node(2);

    root.left = new Node(7);
    root.right = new Node(5);

    root.left.left = new Node(2);
    root.left.right = new Node(6);
    root.right.right = new Node(9);

    root.left.right.left = new Node(5);
    root.left.right.right = new Node(11);
    root.right.right.left = new Node(4);

    return root;
  }

  private static Node LCA(Node root, int a, int b) {
    if(root == null) {
      return null;
    }

    if(root.value == a || root.value == b) {
      return root;
    }

    Node l = LCA(root.left, a, b); // for root = 2, l = 7
    Node r = LCA(root.right, a , b); // for 5, r = 9

    if(l != null && r != null) {
      return root;
    }

    return l == null ? r : l;
  }

  private static Node bstLCA(Node root, int a, int b) {
    if(root == null) {
      return null;
    }

    if(root.value > a && root.value > b) {
      bstLCA(root.left, a, b);
    }

    if(root.value < a && root.value < b) {
      bstLCA(root.right, a, b);
    }

    return root;
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
      return "" + value;
    }
  }
}