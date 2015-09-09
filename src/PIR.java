import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PIR {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Integer T = Integer.parseInt(br.readLine());

    while (T-- > 0) {
      String temp[] = br.readLine().split(" ");
      Double U = Double.parseDouble(temp[0]);
      Double V = Double.parseDouble(temp[1]);
      Double W = Double.parseDouble(temp[2]);

      Double w = Double.parseDouble(temp[3]);
      Double v = Double.parseDouble(temp[4]);
      Double u = Double.parseDouble(temp[5]);

      Double ud = (v*v) + (w*w) -  (U*U);
      Double vd = (u*u) + (w*w) -  (V*V);
      Double wd = (v*v) + (u*u) -  (W*W);

      Double volumetemp =  (4.0*u * u * v * v * w * w )-( u * u * ud * ud )- (v * v *  vd * vd )- (w * w * wd * wd)
          + (ud * vd * wd) ;

      Double volume = Math.sqrt(volumetemp) / 12.0;


      System.out.printf("%.4f", volume);
    }
  }
}
