import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class OFFSIDE {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    while (true) {
      String temp[] = br.readLine().split(" ");
      Integer A = Integer.parseInt(temp[0]);
      Integer D = Integer.parseInt(temp[1]);

      if (A.equals(0) && D.equals(0)) {
        break;
      }

      Integer attackers[] = new Integer[A];
      Integer defenders[] = new Integer[D];

      temp = br.readLine().split(" ");

      for (int i = 0; i < A; i++) {
        attackers[i] = Integer.parseInt(temp[i]);
      }

      temp = br.readLine().split(" ");

      for (int i = 0; i < D; i++) {
        defenders[i] = Integer.parseInt(temp[i]);
      }


      Arrays.sort(attackers);
      Arrays.sort(defenders);

      Integer closestAttacker = attackers[0];
      Integer secondClosestDefender = defenders[1];


      if (closestAttacker.compareTo(secondClosestDefender) < 0) {
        System.out.println("Y");
      } else {
        System.out.println("N");
      }
    }
  }

}
