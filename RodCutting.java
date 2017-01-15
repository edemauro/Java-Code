public class RodCutting {
  public static void main(String[] args) {
    int[] arr = new int[] {1, 5, 8, 9, 10, 17, 17, 20};

    System.out.println(dynamicCutRod(arr, arr.length));
    System.out.println(bottomUpRodCutting(arr, arr.length ));
  }

  public static int cutRod(int[] arr, int n) {
    if(n == 0) {
      return 0;
    }

    int q = Integer.MIN_VALUE;

    for(int i = 1; i <= n; i++) {
      q = Math.max(q, arr[i - 1] + cutRod(arr, n - i));
    }

    return q;
  }

  public static int dynamicCutRod(int[] arr, int n) {
    int[] r = new int[n + 1];
    r[0] = 0;

    for(int i = 1; i < r.length; i++) {
      r[i] = Integer.MIN_VALUE;
    }

    return dynamicCutRodHelper(arr, n, r);
  }

  private static int dynamicCutRodHelper(int[] arr, int n, int[] r) {
    int q;

    if(r[n] >= 0) {
      return r[n];
    }

    q = Integer.MIN_VALUE;
    for(int i = 1; i <= n; i++) {
      q = Math.max(q, arr[i - 1] + dynamicCutRodHelper(arr, n - i, r));
    }
    r[n] = q;
    return q;
  }

  public static int bottomUpRodCutting(int[] arr, int n) {
    int[] memo = new int[n + 1];
    memo[0] = 0;

    for(int i = 1; i <= n; i++) {
      int q = Integer.MIN_VALUE;
      for(int j = 1; j <= i; j++) {
        q = Math.max(q, arr[j - 1] + memo[i - j]);
      }
      memo[i] = q;
    }

    return memo[n];
  }
}