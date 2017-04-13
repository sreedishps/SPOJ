import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Stack;

/**
 * Created by sreps on 11/7/2016.
 */
public class FRIEMEET {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String temp[] = br.readLine().split(" ");
            Integer N = Integer.parseInt(temp[0]);
            Integer M = Integer.parseInt(temp[1]);

            HashSet<Integer> Mset = new HashSet<>();

            int adj[][] = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(i == j){
                        adj[i][j] = 0;
                    }
                    adj[i][j] = 12000;
                }
            }

            for (int i = 0; i < N - 1; i++) {
                temp = br.readLine().split(" ");
                Integer U = Integer.parseInt(temp[0]) - 1;
                Integer V = Integer.parseInt(temp[1]) - 1;
                Integer L = Integer.parseInt(temp[2]);

                adj[U][V] = L;
                adj[V][U] = L;
            }

            temp = br.readLine().split(" ");

            for (int i = 0; i < M; i++) {
                Mset.add(Integer.parseInt(temp[i]) - 1);
            }

            Integer numerator = 0;
//            for (Integer current : Mset) {
//                numerator += getSumAllPAth(current, Mset, adj, N);
//            }

            Integer dist[][] = floydWarshall(N,adj);

            for(Integer current : Mset){
                numerator += getSum(current, Mset , dist , N);
            }


            Integer denominator = M * M;
            Integer gcd = gcd(numerator, denominator);

            System.out.println(numerator / gcd + " " + denominator / gcd);
        }
    }

    private static Integer getSum(Integer current, HashSet<Integer> mset, Integer[][] dist, Integer N) {
        Integer sum = 0;
        for(Integer val : mset){
            sum += dist[current][val];
        }
        return sum;
    }

    private static Integer gcd(Integer a, Integer b) {
        if (b == 0) {
            return a;
        } else return gcd(b, a % b);
    }

    private static Integer[][] floydWarshall(Integer N, int adj[][]) {
        Integer dist[][] = new Integer[N][N], i, j, k;
        for (i = 0; i < N; i++)
            for (j = 0; j < N; j++)
                dist[i][j] = adj[i][j];



        for (k = 0; k < N; k++) {
            // Pick all vertices as source one by one
            for (i = 0; i < N; i++) {
                // Pick all vertices as destination for the
                // above picked source
                for (j = 0; j < N; j++) {
                    // If vertex k is on the shortest path from
                    // i to j, then update the value of dist[i][j]
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }

        for (i = 0; i < N; i++)
            for (j = 0; j < N; j++)
                if(i == j)
                dist[i][j] = 0;
        return dist;

    }

    private static Integer getSumAllPAth(Integer current, HashSet<Integer> mset, int[][] adj, Integer N) {
        Stack<Integer> dfs = new Stack<>();
        Stack<Integer> weight = new Stack<>();
        boolean visited[] = new boolean[N];
        Integer currentWeight = 0;
        Integer totalWeight = 0;
        Integer detected = 0;

        dfs.push(current);
        weight.push(0);
        visited[current] = true;
        detected++;


        while (true) {
            if (detected.equals(mset.size())) {
                break;
            }

            boolean nextNode = false;
            for (int i = 0; i < N; i++) {
                if (adj[current][i] > 0 && !visited[i]) {
                    nextNode = true;
                    dfs.push(i);
                    weight.push(adj[current][i]);

                    currentWeight += adj[current][i];
                    current = i;
                    visited[current] = true;

                    if (mset.contains(i)) {
                        totalWeight += currentWeight;
                        detected++;
                    }
                    break;
                }
            }

            if (!nextNode && dfs.size() > 0) {
                dfs.pop();
                currentWeight -= weight.pop();
                if (dfs.size() > 0)
                    current = dfs.peek();
            }
        }
        return totalWeight;
    }
}