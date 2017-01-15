import java.util.HashSet;

public class Unique {
  public static void main(String[] args) {
    System.out.println(uniqueCheck("abcb"));
  }

  public static boolean uniqueCheck(String str) {
    char[] s = str.toCharArray();
    HashSet<Character> charSet = new HashSet<>();
    
    for(char c : s) {
      charSet.add(c);
    }
    
    return s.length == charSet.size();
  }
}