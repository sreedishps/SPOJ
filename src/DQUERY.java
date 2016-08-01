import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by sreps on 7/31/2016.
 */
public class DQUERY {

    static Integer input[];
    static Integer answer;
    static HashMap<Integer, Integer> count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.parseInt(br.readLine());

        String temp[] = br.readLine().split(" ");
        input = new Integer[N + 1];
        answer = 0;
        count = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            input[i] = Integer.parseInt(temp[i - 1]);
        }


        Integer Q = Integer.parseInt(br.readLine());
        ArrayList<Query> queries = new ArrayList<>();
        for (int i = 0; i < Q; i++) {
            temp = br.readLine().split(" ");
            Integer left = Integer.parseInt(temp[0]);
            Integer right = Integer.parseInt(temp[1]);
            queries.add(new Query(left, right));
        }

        int currentLeft = 1, currentRight = 1;
        for (Query query : queries) {
            int left = query.left;
            int right = query.right;

            while (left < currentLeft) {
                currentLeft--;
                addition(currentLeft);
            }
            while (left > currentLeft) {
                removal(left);
                left--;
            }
            while (right < currentRight) {
                addition(right);
                right++;
            }
            while (right > currentRight) {
                removal(right);
                right--;
            }

            System.out.println(answer);
            currentLeft = query.left;
            currentRight = query.right;
        }
    }

    static class Query {
        public Integer left;
        public Integer right;

        Query(Integer left, Integer right) {
            this.left = left;
            this.right = right;
        }
    }

    public static void addition(int position) {
        Integer current = count.get(input[position]);
        if (current == null) {
            count.put(input[position], 1);
            answer++;
            return;
        }
        if (current == 0) {
            answer++;
            current = 0;
        }
        count.put(input[position], current + 1);
    }

    public static void removal(int position) {
        Integer current = count.get(input[position]);
        if (current == null) {
            return;
        }
        if (current == 1) {
            answer--;
        }
        count.put(input[position], current - 1);
    }
}
