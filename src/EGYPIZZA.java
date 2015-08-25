import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EGYPIZZA {
  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    Integer N = Integer.parseInt(in.readLine());

    int quart = 0, half = 0, threeQuart = 0;
    while (N > 0) {
      N--;
      String temp = in.readLine();
      if (temp.equals("1/2")) {
        half++;
      } else if (temp.equals("1/4")) {
        quart++;
      } else {
        threeQuart++;
      }
    }

    System.out.println(solve(quart, half, threeQuart));
  }

  private static int solve(int quart, int half, int threeQuart) {
    int pizzas = 0;
    //add all threequart
    pizzas += threeQuart;

    //add qaurters
    if (quart > threeQuart) {
      quart -= threeQuart;
    } else {
      quart = 0;
    }
    pizzas += (half / 2);
    quart += ((half % 2)*2);

    pizzas += (quart / 4);
    if(quart %4 > 0){
      pizzas++;
    }
    return pizzas + 1;
  }
}
