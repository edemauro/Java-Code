public class Traversal {
  public static void main(String[] args) {
    Node a = new Node(2);
    Node b = new Node(3);
    Node root = new Node(a, b, 1);
    
    preorder(root); // 1 2 3
    System.out.println("");
    inorder(root); // 2 1 3
    System.out.println("");
    postorder(root); // 2 3 1
  }

  public static void preorder(Node root) {
    if( root == null ) return;
    root.printValue();
    preorder( root.getLeft() );
    preorder( root.getRight() );
  }

  public static void inorder(Node root) {
    if( root == null ) return;
    inorder( root.getLeft() );
    root.printValue();
    inorder( root.getRight() );
  }

  public static void postorder(Node root) {
    if( root == null ) return;
    postorder( root.getLeft() );
    postorder( root.getRight() );
    root.printValue();
  }

  private static class Node {
    private Node left;
    private Node right;
    private int value;

    public Node( Node left, Node right, int value ) {
      this.left = left;
      this.right = right;
      this.value = value;
    }

    public Node(int value) {
      this(null, null, value);
    }

    public Node getLeft() { return left; }
    public Node getRight() { return right; }
    public int getValue() { return value; }

    public void printValue() {
      System.out.print(value + " ");
    }
  }
}