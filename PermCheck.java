import java.util.Arrays;

public class PermCheck {
  public static void main(String[] args) {
      System.out.println(permCheck("cat", "tac"));
  }

  public static boolean permCheck(String x, String y) {
    char[] xCharArray = x.toCharArray();
    char[] yCharArray = y.toCharArray();
    boolean isEqual = true;
    Arrays.sort(xCharArray);
    Arrays.sort(yCharArray);

    for(int i = 0; i < xCharArray.length; i++) {
      if(xCharArray[i] != yCharArray[i]) {
        isEqual = false;
      }
    }

    return isEqual;
  }
}