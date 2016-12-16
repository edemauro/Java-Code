public class StringToInt {
  public static void main(String[] args) {
    System.out.println( convert("-421") );
  }

  public static int convert(String str) {
    char[] s = str.toCharArray();
    int i = 0, numb = 0;
    boolean negative = false;

    if(s[0] == '-') {
      negative = true;
      i = 1;
    }

    while(i < s.length) {
      numb *= 10;
      numb += (s[i++] - '0');
    }

    return negative ? (numb *= -1) : numb;
  }
}