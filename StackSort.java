import java.util.*;

public class StackSort {
  public static void main(String[] args) {
    Stack<Integer> s = new Stack<>();
    Stack<Integer> r = new Stack<>();

    s.push(1);
    s.push(3);
    s.push(2);
    s.push(10);
    s.push(4);
    s.push(7);
    s.push(8);

    while(!s.empty()) {
      int tmp = s.pop();

      while(!r.empty() && r.peek() < tmp) {
        s.push(r.pop());
      }

      r.push(tmp);
    }

    while(!r.empty()) {
      System.out.println(r.pop());
    }
  }
}