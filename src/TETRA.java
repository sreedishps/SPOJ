import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sreedish.ps on 11/23/15.
 */
public class TETRA {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String temp[] = br.readLine().split(" ");
            double u = Double.parseDouble (temp[0]),
            W = Double.parseDouble (temp[1]), V = Double.parseDouble (temp[2]),
                    v = Double.parseDouble (temp[3]), w = Double.parseDouble (temp[4]), U = Double.parseDouble (temp[5]);

            double u_ = v * v + w * w - U * U,
                    v_ = w * w + u * u - V * V,
                    w_ = u * u + v * v - W * W,
                    vol = 4 * u * u * v * v * w * w -
                            u * u * u_ * u_ - v * v * v_ * v_ -
                            w * w * w_ * w_ + u_ * v_ * w_,
                    volume = Math.sqrt (vol) / 12.;

            double s = (u + W + v) / 2., plane1, plane2, plane3, plane4;
            plane1 = Math.sqrt (s * (s - u) * (s - W) * (s - v));
            s = (U + V + W) / 2.;
            plane2 = Math.sqrt (s * (s - U) * (s - V) * (s - W));
            s = (v + U + w) / 2.;
            plane3 = Math.sqrt (s * (s - v) * (s - U) * (s - w));
            s = (w + V + u) / 2.;
            plane4 = Math.sqrt (s * (s - w) * (s - V) * (s - u));

            double area = plane1 + plane2 + plane3 + plane4;
            System.out.print(String.format ("%.4f\n", 3 * volume / area));
        }
    }
}
