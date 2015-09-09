import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class STPAR {

  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    while (true) {
      Integer N = sc.nextInt();
      if (N.equals(0)) {
        break;
      }
      Integer counter = 1;
      Stack<Integer> stk = new Stack<Integer>();
      for (int i = 0; i < N; i++) {
        while (!stk.empty()) {
          if (stk.peek().equals(counter)) {
            counter++;
            stk.pop();
          } else {
            break;
          }
        }
        Integer love = sc.nextInt();
        if (love.equals(counter)) {
          counter++;
        } else {
          stk.push(love);
        }
      }

      while (!stk.empty()) {
        if (stk.peek().equals(counter)) {
          counter++;
          stk.pop();
        }  else {
          break;
        }
      }

      if (stk.empty()) {
        System.out.println("yes");
      } else {
        System.out.println("no");
      }
    }
  }
}
