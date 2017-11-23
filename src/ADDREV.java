import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ADDREV {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String temp[] = br.readLine().split(" ");

            Integer A = Integer.parseInt(new StringBuilder(temp[0]).reverse().toString()) +
                    Integer.parseInt(new StringBuilder(temp[1]).reverse().toString());

            System.out.println(Integer.parseInt(new StringBuilder(A+"").reverse().toString()));
        }
    }
}
