import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * Created by sreps on 9/7/2016.
 */
public class CHRMT {

    static int horizontalMax;
    static int verticalMax;

    static class item implements Comparable {
        Long number;
        int x;

        public item(Long number, int x, int y) {
            this.number = number;
            this.x = x;
            this.y = y;
        }

        int y;

        @Override
        public int compareTo(Object obj) {
            item it = (item) obj;
            return it.number.compareTo(this.number);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp[] = br.readLine().split(" ");
        Integer N = Integer.parseInt(temp[0]);
        Integer P = Integer.parseInt(temp[1]);

        Long arr[][] = new Long[N][N];

        TreeSet<item> numbers = new TreeSet<>();
        Long sum = 0L;


        for (int i = 0; i < N; i++) {
            temp = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Long.parseLong(temp[j]);
                numbers.add(new item(arr[i][j], i, j));
                sum += arr[i][j];
            }
        }

        Long avg = sum / (N * N);

        horizontalMax = P - 1;
        verticalMax = P - 1;

        HashSet<Integer> horizontal = new HashSet<>();
        HashSet<Integer> vertical = new HashSet<>();


//        for(item item : numbers){
//            Long current = item.number;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                if (arr[i][j] > avg) {
                    if (horizontal.size() < horizontalMax)
                        addHorizontal(horizontal, i, N);

                    if (vertical.size() < verticalMax)
                        addVertical(vertical, j, N);
                }
            }

        }


        int i = 1;
        while (vertical.size() < verticalMax) {
            vertical.add(i);
            i++;
        }

        i = 1;
        while (horizontal.size() < horizontalMax) {
            horizontal.add(i);
        }


        StringBuilder hanswer = new StringBuilder();
        for (Integer line : horizontal) {
            hanswer.append(line).append(" ");
        }


        StringBuilder vanswer = new StringBuilder();
        for (Integer line : vertical) {
            vanswer.append(line).append(" ");
        }

        System.out.println(hanswer);
        System.out.println(vanswer);

    }

    private static void addVertical(HashSet<Integer> vertical, int col, Integer N) {
        if (vertical.size() >= verticalMax) {
            return;
        }
        if (col != 0 && col != N - 1) {
            vertical.add(col);
            if (vertical.size() < verticalMax)
                vertical.add(col + 1);
            return;
        }

        if (col == 0) {
            vertical.add(1);
            return;
        }

        if (col == N - 1) {
            vertical.add(N - 1);
            return;
        }
    }

    private static void addHorizontal(HashSet<Integer> horizontal, int row, Integer N) {
        if (horizontal.size() >= horizontalMax) {
            return;
        }
        if (row != 0 && row != N - 1) {
            horizontal.add(row);
            if (horizontal.size() < horizontalMax)
                horizontal.add(row + 1);
            return;
        }

        if (row == 0) {
            horizontal.add(1);
            return;
        }

        if (row == N - 1) {
            horizontal.add(N - 1);
            return;
        }
    }
}