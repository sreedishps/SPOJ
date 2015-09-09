import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ABSYS {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Integer T = Integer.parseInt(br.readLine());

    while (T-- > 0) {
      String temp1 = br.readLine();
      String temp = br.readLine();
      String a = temp.split("\\+")[0].trim();
      String b = temp.split("\\+")[1].split("=")[0].trim();
      String c = temp.split("=")[1].trim();

      if (a.contains("machula")) {
        Integer missing = Integer.parseInt(c) - Integer.parseInt(b);
        System.out.println(missing + " + " + b + " = " + c);
      } else if (b.contains("machula")) {
        Integer missing = Integer.parseInt(c) - Integer.parseInt(a);
        System.out.println(a + " + " + missing + " = " + c);
      } else {
        Integer missing = Integer.parseInt(a) + Integer.parseInt(b);
        System.out.println(a + " + " + b + " = " + missing);
      }

    }
  }

}
