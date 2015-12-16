import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DANGER {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    while (true) {
      String temp = br.readLine();
      if (temp.equals("00e0")) {
        break;
      }
      Integer number = Integer.parseInt(
          temp.charAt(0) + "") * 10 + Integer.parseInt(temp.charAt(1) + "");

      Integer z = Integer.parseInt(temp.charAt(3) + "");
      for (int i = 0; i < z; i++) {
        number = number * 10;
      }

      long answer = 0;

      int height = (int) (Math.log(number) / Math.log(2));

      number = number - ((int) Math.pow(2, height) - 1);

      answer = 2 * (number - 1) + 1;
      System.out.println(answer);


    }

//    for (int i = 1; i <= 200; i++) {
//      int aliveCount = i;
//      boolean life[] = new boolean[i];
//
//      int kill = 1;
//      while (true) {
//        if (aliveCount == 1) {
//          printLastMan(life, i);
//          break;
//        }
//        life[kill] = true;
//        aliveCount--;
//        if (aliveCount == 1) {
//          printLastMan(life, i);
//          break;
//        }
//        kill = nextKill(life, i, kill);
//      }
//    }
  }

  private static int nextKill(boolean[] life, int limit, int current) {
    int i = current + 1;
    int found = 0;
    while (true) {
      if (i == limit) {
        i = 0;
      }
      if (!life[i]) {
        found++;
      }
      if (found == 2) {
        break;
      }
      i++;
    }

    return i;
  }

  private static void printLastMan(boolean[] life, int i) {
    for (int j = 0; j < i; j++) {
      if (!life[j]) {
        if (j == 0) {
          System.out.println();
        }
        System.out.print(j + 1 + " ");
        return;
      }
    }
  }

}
