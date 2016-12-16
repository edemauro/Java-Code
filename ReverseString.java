/*
  javac ReverseString.java
  java ReverseString

  docker-compose run app bash
*/

public class ReverseString {
	public static void main(String[] args) {
    String a = "kobe is the man yo";
    char[] str = reverse(a.toCharArray(), 0, a.length() -1);
    int start = 0, end = 0;

    for(int i = 0; i < str.length; i++) {
      if(str[i] != ' ') {
        end++;
      } else {
        reverse(str, start, end - 1);
        str[end++] = ' '; 
        start = end;
      }
    }
    reverse(str, start, end - 1);

    System.out.println(str);

    System.out.println(recursiveReverse(a);
	}

  public static char[] reverse(char[] arr, int start, int end) {
    while(start < end) {
      char tmp = arr[start];
      arr[start++] = arr[end];
      arr[end--] = tmp;
    }

    return arr;
  }

  public static String recursiveReverse(String str) {
    if(str.length() <= 1) {
      return str;
    }

    return recursiveReverse(str.substring(1)) + str.charAt(0);
  }
}