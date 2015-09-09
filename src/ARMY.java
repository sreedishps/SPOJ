import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ARMY {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Integer N;
    N = Integer.parseInt(br.readLine());
    while (N-- > 0) {
      String temp[] = br.readLine().split(" ");
      temp = br.readLine().split(" ");

      Integer NG = Integer.parseInt(temp[0]);
      Integer NM = Integer.parseInt(temp[1]);

      temp = br.readLine().split(" ");
      Integer strongestGodzilla = 0;
      for (int i = 0; i < NG; i++) {
        Integer current = Integer.parseInt(temp[i]);
        if (current.compareTo(strongestGodzilla) > 0) {
          strongestGodzilla = current;
        }
      }

      temp = br.readLine().split(" ");
      Integer strongestMechaGodzilla = 0;
      for (int i = 0; i < NM; i++) {
        Integer current = Integer.parseInt(temp[i]);
        if (current.compareTo(strongestMechaGodzilla) > 0) {
          strongestMechaGodzilla = current;
        }
      }

      if(strongestGodzilla.compareTo(strongestMechaGodzilla) >= 0){
        System.out.println("Godzilla");
      }else{
        System.out.println("MechaGodzilla");
      }

    }
  }
}
