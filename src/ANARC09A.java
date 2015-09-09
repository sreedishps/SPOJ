import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ANARC09A {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             int counter = 1;
    while (true) {
      String temp = br.readLine();
      if (temp.contains("-")) {
        break;
      }
      int open = 0;
      int closed = 0;
      int answer = 0;
      for (int i = 0; i < temp.length(); i++) {
        char bracket = temp.charAt(i);
        if (bracket == '{') {
          open++;
        } else if (bracket == '}') {
          if (open > 0) {
            open--;
          } else {
            answer++;
            open++;
          }
        }
      }

      answer += (open/2);
      System.out.println(counter+". "+answer);
      counter++;
    }

  }

}
