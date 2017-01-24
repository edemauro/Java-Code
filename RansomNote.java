public class RansomNote {
  public static void main(String[] args) {
    String msg = "an apple";
    String article = "testing ya apple";
    System.out.println(canMakeNote(msg, article));
  }

  public static boolean canMakeNote(String message, String article) {
    int[] counter = new int[256];

    for(int i = 0; i < article.length(); i++) {
      int asciiValue = (int) article.charAt(i);
      counter[asciiValue] += 1;
    }

    for(int i = 0; i< message.length(); i++) {
      int asciiValue = (int) message.charAt(i);
      counter[asciiValue] -= 1;
      if(counter[asciiValue] < 0) {
        return false;
      }
    }

    return true;
  }
}