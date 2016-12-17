public class Combinations {
  public static void comb(String s) { comb("", s); }
  private static void comb(String prefix, String s) {
    System.out.println(prefix);
    for(int i = 0; i < s.length(); i++) {
      comb(prefix + s.charAt(i), s.substring(i + 1));
    }
  }

  public static void main(String[] args) {
    comb("abc");
  }
}