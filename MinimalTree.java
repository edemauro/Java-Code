public class MinimalTree {
  public static void main(String[] args) {
    int[] arr = new int[]{1, 2, 3};

    Node tree = createTree(arr, 0, arr.length - 1);

    preOrder(tree);
  }

  public static Node createTree(int[] arr, int start, int end) {
    if(start > end) {
      return null;
    }

    int mid = (start + end) / 2;

    Node root = new Node(arr[mid]);
    root.left = createTree(arr, start, mid - 1);
    root.right = createTree(arr, mid + 1, end);

    return root;
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
      return "" + value;
    }
  }
}