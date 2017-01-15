import java.util.*;

/*
  Only one letter can have an odd occurrence in a palindrome. if string length is odd,
  then a single letter occurs an odd number of times. if string length is even,
  then no letter can occur an odd number of times.
*/

public class PalindromePerm {
  public static void main(String[] args) {
    System.out.println(canMakePalindrome("tacocats"));
  }

  public static boolean canMakePalindrome(String str) {
    Map<Character, Integer> countChars = new HashMap<>();
    boolean hasOdd = false;

    for(char c : str.toCharArray()) {
      Integer count = countChars.get(c);
      if(count == null) {
        countChars.put(c, 1);
      } else {
        countChars.put(c, count + 1);
      }
    }

    for(Integer i : countChars.values()) {
      if(i % 2 != 0) {
        if(hasOdd) {
          return false;
        } else {
          hasOdd = true;
        }
      }
    }

    return true;
  }
}