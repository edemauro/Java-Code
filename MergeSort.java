import java.util.*;

public class MergeSort {
  public static void main(String[] args) {
    int[] arr = new int[]{ 5, 3, 20, 69 };

    sort(arr);

    for(int a : arr) {
      System.out.println(a);
    }
  }

  public static int[] sort(int[] arr) {
    if(arr.length < 2) {
      return arr;
    }

    int middle = arr.length / 2;
    int[] left = new int[middle];
    int[] right = new int[ arr.length - middle ];

    for(int i = 0; i < middle; i++) {
      left[i] = arr[i];
    }

    for(int i = 0; i < 5; i++) {
      
    }

    for(int i = middle, j = 0; i < arr.length; i++, j++) {

      right[j] = arr[i];
    }

    sort(left);
    sort(right);

    int i, j, k;
    i = j = k = 0;

    while(i < left.length && j < right.length) {
      if(left[i] < right[j]) {
        arr[k++] = left[i++];
      } else {
        arr[k++] = right[j++];
      }
    }

    while(i < left.length) {
      arr[k++] = left[i++];
    }

    while(j < right.length) {
      arr[k++] = right[j++];
    }

    return arr;
  }
}