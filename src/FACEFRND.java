import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class FACEFRND {
  static HashSet<String> friends = new HashSet();
  static HashSet<String> fof = new HashSet();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Integer T = Integer.parseInt(br.readLine());
    while (T-- > 0) {
      String temp = br.readLine();
      parse(temp);
    }

   for(String friend : friends){
     fof.remove(friend);
   }

    System.out.println(fof.size());
  }

  private static void parse(String temp) {
    String[] f = temp.split(" ");
    for (int i = 0; i < f.length; i++) {
      if (i == 0) {
        friends.add(f[i]);
      } else if (i == 1) {
        continue;
      } else {
        fof.add(f[i]);
      }
    }
  }
}
