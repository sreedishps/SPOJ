import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PHONELST {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            Integer N = Integer.parseInt(br.readLine());
            String temp[] = new String[N];
            for (int i = 0; i < N; i++) {
                temp[i] = br.readLine();
            }

            Arrays.sort(temp);
            boolean flag = false;
            for (int i = 0; i < N - 1; i++) {
                if (temp[i + 1].contains(temp[i])) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }


    }
}
