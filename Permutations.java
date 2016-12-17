public class Permutations {
  private static StringBuilder sb = new StringBuilder();
  // public static void perm(String s) { perm("", s); }
  // private static void perm(String prefix, String s) {
  //   if(s.length() == 0) {
  //     System.out.println(prefix);
  //   } else {
  //     for(int i = 0; i < s.length(); i++) {
  //       perm(prefix + s.charAt(i), s.substring(0, i) + s.substring(i + 1, s.length()));
  //     }
  //   }
  // }

  public static void perm(String s) {
    if(s.length() == 0) {
      System.out.println(sb);
    } else {
      for(int i = 0; i < s.length(); i++) {
        sb.append(s.charAt(i));
        perm(s.substring(0, i) + s.substring(i + 1, s.length()));
        sb.setLength(sb.length() - 1); // had to use setLength over delete
      }
    }
  }

  public static void main(String[] args) {
    perm("abc");
  }
}