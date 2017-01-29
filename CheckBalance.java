public class CheckBalance {
  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);

    System.out.println(isBalanced(root));
  }

  public static boolean isBalanced(Node root) {
    return heightBalanced(root) != -1;
  }

  private static int heightBalanced(Node root) {
    if(root == null) {
      return 0;
    }

    int leftHeight = heightBalanced(root.left);
    int rightHeight = heightBalanced(root.right);

    if(leftHeight < 0 || 
      rightHeight < 0 || 
      Math.abs(leftHeight - rightHeight) > 1) {
      return -1;
    }

    return 1 + Math.max(leftHeight, rightHeight);
  }

  private static class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
      this.value = value;
      left = right = null;
    }
  }
}