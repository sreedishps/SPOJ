import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class ARRAYSUB {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        Integer N = sc.nextInt();

        int numbers[] = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }
        Integer K = sc.nextInt();

        Deque<Integer> dq = new LinkedList();

        for (int i = 0; i < K; i++) {
            if (dq.isEmpty()) {
                dq.addLast(i);
            } else {
                Integer current = numbers[i];
                while (true) {
                    if (dq.isEmpty()) {
                        break;
                    }
                    Integer lastInQueue = numbers[dq.peekLast()];
                    if (lastInQueue.compareTo(current) < 0) {
                        dq.removeLast();
                    } else {
                        break;
                    }
                }
                dq.addLast(i);
            }
        }

        for (int i = K; i < N; i++) {
            System.out.print(numbers[dq.peekFirst()] + " ");
            if (dq.isEmpty()) {
                dq.addLast(i);
            } else {

                while (true) {
                    if (dq.isEmpty()) {
                        break;
                    }
                    if (dq.peekFirst() <= (i - K)) {
                        dq.removeFirst();
                    } else {
                        break;
                    }
                }
                Integer current = numbers[i];
                while (true) {
                    if (dq.isEmpty()) {
                        break;
                    }
                    Integer lastInQueue = numbers[dq.peekLast()];
                    if (lastInQueue.compareTo(current) < 0) {
                        dq.removeLast();
                    } else {
                        break;
                    }
                }
                dq.addLast(i);
            }
        }
        System.out.print(numbers[dq.peekFirst()]);
    }
}
