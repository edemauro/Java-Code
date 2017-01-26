public class BinarySearch {
  public static void main(String[] args) {
    int[] arr = new int[]{1,3,5};

    System.out.println(2 == binaryInsert(arr, 4));
    System.out.println(1 == binaryInsert(arr, 2));
  }

  public static int binaryInsert(int[] a, int insertKey) {
    int nElems = a.length;
    int lower = 0;
    int upper = nElems - 1;
    int curr = (lower + upper) / 2;

    while(true) {
      if(a[curr] == insertKey) {
        return curr;
      } else if(a[curr] > insertKey) {
        upper = curr - 1; // in lower half

        if(lower == upper) {
          return curr;
        }
      } else {
        lower = curr + 1; // in upper half

        if(lower == upper) {
          return curr + 1;
        }
      }
    }
  }
}