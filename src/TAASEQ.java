import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * Created by sreps on 9/18/2016.
 */
public class TAASEQ {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String temp[] = br.readLine().split(" ");
            Integer N = Integer.parseInt(temp[0]);
            Long input[] = new Long[N];
            temp = br.readLine().split(" ");

            for (int i = 0; i < N; i++) {
                input[i] = Long.parseLong(temp[i]);
            }

            if (alreadyAp(input, N) || N == 2 || N == 3) {
                System.out.println(printMin(input));
                continue;
            }

            TreeSet<Long> answer = new TreeSet<>();

            Long difference = input[1] - input[0];
            int counter = 0;

            if (alreadyAp(input, N, N-1)) {
                answer.add(input[N-1]);
            }

            for (int i = 0; i < N - 1; i++) {
                if(counter > 10){
                    break;
                }
                if (input[i + 1] - input[i] != difference) {
                    counter++;
                    if (alreadyAp(input, N, i)) {
                        answer.add(input[i]);
                        break;
                    }
                }
            }

            difference = input[N-1] - input[N-2];
            counter = 0;
            for (int i = 0; i < N - 1; i++) {
                if(counter > 10){
                    break;
                }
                if (input[i + 1] - input[i] != difference) {
                    counter++;
                    if (alreadyAp(input, N, i)) {
                        answer.add(input[i]);
                        break;
                    }
                }
            }

            if(answer.size() > 0){
                System.out.println(answer.first());
                continue;
            }

            System.out.println("-1");
        }
    }

    private static Long printMin(Long[] input) {
        Long min = Long.MAX_VALUE;

        for (int i = 0; i < input.length; i++) {
            if (input[i].compareTo(min) < 0) {
                min = input[i];
            }
        }
        return min;
    }

    private static boolean alreadyAp(Long[] input, Integer N, Integer skip) {
        int first, second;

        Long diff;
        diff = input[1] - input[0];
        if (skip == 0) {
            diff = input[2] - input[1];
        }
        if (skip == 1) {
            diff = input[2] - input[0];
        }

        for (int i = 0; i < N - 1; i++) {
            first = i;
            second = i + 1;

            if (i == skip && i == 0) {
                continue;
            }

            if (i+1 == skip && i == N - 2) {
                continue;
            }

            if (first == skip) {
                continue;
            }

            if (second == skip) {
                second++;
            }

            if (diff != input[second] - input[first]) {
                return false;
            }

        }
        return true;
    }

    private static boolean alreadyAp(Long[] input, Integer N) {
        if (N == 2) {
            return true;
        }
        Long difference = input[1] - input[0];
        for (int i = 0; i < N - 1; i++) {
            if (input[i + 1] - input[i] != difference) {
                return false;
            }
        }
        return true;
    }
}