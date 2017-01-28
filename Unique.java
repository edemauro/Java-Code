import java.util.*;

public class Unique {
  public static void main(String[] args) {
    System.out.println(uniqueCheck("abcb"));

    List<Integer> arr = removeDups(new int[]{ 1,1,2,2,3,4,4,5,1,6 });

    for(int i : arr) {
      System.out.println(i);
    }
  }

  public static boolean uniqueCheck(String str) {
    char[] s = str.toCharArray();
    Set<Character> charSet = new HashSet<>();
    
    for(char c : s) {
      charSet.add(c);
    }
    
    return s.length == charSet.size();
  }

  public static List<Integer> removeDups(int[] arr) {
    Set<Integer> flags = new HashSet<>();
    List<Integer> ret = new ArrayList<>();

    for(int i : arr) {
      if(!flags.contains(i)) {
        flags.add(i);
        ret.add(i);
      }
    }

    return ret;
  }
}