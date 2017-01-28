public class QuickSort {
  public static void main(String[] args) {
    int[] arr = new int[]{4,2,3,5,10,7};
    sort(arr, 0, arr.length - 1);

    for(int i : arr) {
      System.out.println(i);
    }
  }

  public static void sort(int[] arr, int left, int right) {
    int pivot = arr[(left + right) / 2];
    int i = left;
    int j = right;

    while(i <= j) {
      while(arr[i] < pivot) {
        i++;
      }

      while(arr[j] > pivot) {
        j--;
      }

      if(i <= j) {
        swap(arr, i, j);
        i++;
        j--;
      }
    }

    if(left < j) {
      sort(arr, left, j);
    }

    if(i < right) {
      sort(arr, i, right);
    }
  }

  private static void swap(int[] arr, int x, int y) {
    int tmp = arr[x];
    arr[x] = arr[y];
    arr[y] = tmp;
  }
}