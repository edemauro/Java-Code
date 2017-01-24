import java.util.*;

public class SmallIsPermBig {
  public static void main(String[] args) {
    String s = "abbc";
    String b = "cbabadcbbabbcbabaabccbabc";
    boolean permFound = false;
    int start = 0;
    int end = s.length();
  
    while(end != b.length()) {
      String strToTest = b.substring(start, end);
      
      permFound = isPerm(s,strToTest);
      if(permFound) {
        System.out.println(strToTest);
        permFound = false;
      }
      start++;
      end++;
    }
  }

  public static boolean isPerm(String x, String y) {
    char[] xCharArray = new char[x.length()];
    char[] yCharArray = new char[y.length()];
    boolean ret = true;

    for(int i = 0; i < x.length(); i++) {
      xCharArray[i] = x.charAt(i);
      yCharArray[i] = y.charAt(i);
    }

    Arrays.sort(xCharArray);
    Arrays.sort(yCharArray);

    for(int i = 0; i < xCharArray.length; i++) {
      if(xCharArray[i] != yCharArray[i]) {
        return ret = false;
      }
    }

    return ret;
  }
}