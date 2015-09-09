import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DOTAA {
  static Integer n, m, d;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Integer T = Integer.parseInt(br.readLine());
    while (T-- > 0) {
      String temp[] = br.readLine().split(" ");
      n = Integer.parseInt(temp[0]);
      m = Integer.parseInt(temp[1]);
      d = Integer.parseInt(temp[2]);

      for (int i = 0; i < n; i++) {
        Integer currentHero = Integer.parseInt(br.readLine());
        reduceTowers(currentHero);
      }

      if( m <=0){
        System.out.println("YES");
      } else {
        System.out.println("NO");
      }
    }
  }

  private static void reduceTowers(Integer currentHero) {
    while((currentHero - d ) > 0){
      currentHero -=d;
      m--;
    }
  }
}
