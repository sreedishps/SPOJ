import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.DelayQueue;

/**
 * Created by sreedish.ps on 12/27/15.
 */
public class ABROADS {
    static HashMap<Integer, HashSet<Integer>> adj = new HashMap<>();
    static HashMap<Integer, Road> roads = new HashMap<>();
    static Integer N, M, Q;
    static Integer maximum = 0;
    static HashMap<Integer, Integer> population = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp[] = br.readLine().split(" ");
        N = Integer.parseInt(temp[0]);
        M = Integer.parseInt(temp[1]);
        Q = Integer.parseInt(temp[2]);


        temp = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            population.put(i, Integer.parseInt(temp[i-1]));
        }
        int i = 1;
        while (M-- > 0) {
            temp = br.readLine().split(" ");
            Integer A = Integer.parseInt(temp[0]);
            Integer B = Integer.parseInt(temp[1]);
            addEdge(A, B);
            roads.put(i, new Road(A, B));
            i++;
        }

        boolean visited[] = new boolean[N+1];
        maximum = 0;
        for (int t = 1; t <= N; t++) {
            if (!visited[t]) {
                Integer currentMaximum = getMaxBFS(t, visited);
                if (currentMaximum.compareTo(maximum) > 0) {
                    maximum = currentMaximum;
                }
            }
        }

        while (Q-- > 0) {
            String query = br.readLine();
            if (query.contains("D")) {
                Road road = roads.get(Integer.parseInt(query.split(" ")[1]));
                Integer currentMaximum = getMaxBFS(road.a);
                if (!maximum.equals(currentMaximum)) {
                    System.out.println(maximum);
                    deleteEdge(road.a, road.b);
                } else {
                    deleteEdge(road.a, road.b);
                    visited = new boolean[N+1];
                    maximum = 0;
                    for (int t = 1; t <= N; t++) {
                        if (!visited[t]) {
                            currentMaximum = getMaxBFS(t, visited);
                            if (currentMaximum.compareTo(maximum) > 0) {
                                maximum = currentMaximum;
                            }
                        }
                    }
                    System.out.println(maximum);
                }
                continue;
            }
            if (query.contains("P")) {
                Integer town = Integer.parseInt(query.split(" ")[1]);
                Integer newPop = Integer.parseInt(query.split(" ")[2]);
                Integer currentMaximum = getMaxBFS(town);
                population.put(town, newPop);

                visited = new boolean[N+1];
                maximum = 0;
                for (int t = 1; t <= N; t++) {
                    if (!visited[t]) {
                        currentMaximum = getMaxBFS(t, visited);
                        if (currentMaximum.compareTo(maximum) > 0) {
                            maximum = currentMaximum;
                        }
                    }
                }
                System.out.println(maximum);

            }
        }

    }


    private static Integer getMaxBFS(Integer town, boolean visited[]) {
        Queue<Integer> bfs = new LinkedList<Integer>();
        bfs.add(town);
        Integer maximum = 0;

        while (!bfs.isEmpty()) {
            Integer current = bfs.remove();
            maximum += population.get(current);
            visited[current] = true;
            for (Integer neighbour : adj.get(current)) {
                if (!visited[neighbour]) {
                    bfs.add(neighbour);
                    visited[neighbour] = true;
                }
            }
        }
        return maximum;
    }

    private static Integer getMaxBFS(Integer town) {
        boolean visited[] = new boolean[N+1];
        Queue<Integer> bfs = new LinkedList<Integer>();
        bfs.add(town);
        Integer maximum = 0;

        while (!bfs.isEmpty()) {
            Integer current = bfs.remove();
            maximum += population.get(current);
            visited[current] = true;
            for (Integer neighbour : adj.get(current)) {
                if (!visited[neighbour]) {
                    bfs.add(neighbour);
                    visited[neighbour] = true;
                }
            }
        }
        return maximum;
    }

    private static void deleteEdge(Integer a, Integer b) {
        if (adj.get(a) == null) {
            //do nothing
        } else {
            adj.get(a).remove(b);
        }

        if (adj.get(b) == null) {
            //do nothing
        } else {
            adj.get(b).remove(a);
        }
    }

    private static void addEdge(Integer a, Integer b) {
        if (adj.get(a) == null) {
            HashSet<Integer> neighbours = new HashSet<>();
            neighbours.add(b);
            adj.put(a, neighbours);
        } else {
            adj.get(a).add(b);
        }

        if (adj.get(b) == null) {
            HashSet<Integer> neighbours = new HashSet<>();
            neighbours.add(a);
            adj.put(b, neighbours);
        } else {
            adj.get(b).add(a);
        }
    }

}

class Road {
    Integer a, b;

    public Road(Integer a, Integer b) {
        this.a = a;
        this.b = b;
    }
}