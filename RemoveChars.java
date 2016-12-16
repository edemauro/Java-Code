import java.io.*;
import java.util.*;

public class RemoveChars {
  public static String removeChars(String str, String remove) {
    char[] s = str.toCharArray();
    char[] r = remove.toCharArray();
    Set<Character> flags = new HashSet<Character>();
    int src, dst = 0;

    for(char c : r) {
      flags.add(c);
    }

    for( src = 0; src < s.length; ++src ) {
      if( !flags.contains( s[src] ) ) {
        s[dst++] = s[src];
      }
    }

    return new String( s, 0, dst );
  }

  public static void main(String[] args) {
    System.out.println(removeChars("Battle of the Vowels: Hawaii vs. Grozny", "aeiou"));
  }
}