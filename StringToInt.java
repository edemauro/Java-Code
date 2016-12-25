public class StringToInt {
  public static void main(String[] args) {
    System.out.println( convert("-421") );
    System.out.println( intToString(-342) );
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

  public static String intToString(int numb) {
    StringBuilder sb = new StringBuilder();
    char[] tmp = new char[11];
    int i = 0;
    boolean isNeg = false;

    if( numb < 0 ) {
      isNeg = true;
      numb = -numb;
    }

    do {
      tmp[i++] = (char) ((numb % 10) + '0');
      numb /= 10;
    } while( numb != 0 );

    if(isNeg) {
      sb.append('-');
    }

    while(i >= 0) {
      sb.append(tmp[i--]);
    }
    return sb.toString();
  }
}