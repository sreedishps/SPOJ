import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by sreedish.ps on 11/13/15.
 */
public class CSTREET {
    public static ArrayList <Edge>[] grid;

    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int p = Integer.parseInt(br.readLine()), n = Integer.parseInt(br.readLine()), m = Integer.parseInt(br.readLine());
            grid = new ArrayList [n];
            for (int i = 0; i < n; i++)
                grid [i] = new ArrayList <Edge> ();
            for (int i = 0, a, b, w; i < m; i++) {
                String temp[] = br.readLine().split(" ");
                a = Integer.parseInt(temp[0]) - 1;
                b = Integer.parseInt(temp[1]) - 1;
                w = Integer.parseInt(temp[2]);
                grid [a].add (new Edge (b, w));
                grid [b].add (new Edge (a, w));
            }
            System.out.println(minSpanningTree () * p);
        }
    }

    private static int minSpanningTree () {
        int nodes = grid.length;
        boolean[] visited = new boolean [nodes];
        int i, treeSize, treeCost, node, weight;
        PriorityQueue <Edge> pq = new PriorityQueue <Edge> ();
        for (i = 0; i < nodes; i++) visited [i] = false;
        treeCost = 0; treeSize = 0;
        pq.add (new Edge (0, 0));
        Edge dequeue;
        while (treeSize < nodes) {
            dequeue = pq.poll();
            node = dequeue.to; weight = dequeue.weight;
            if(visited[node]) continue;
            treeSize++; treeCost += weight;
            visited[node] = true;
            for (Edge e : grid[node])
                pq.add (new Edge (e.to, e.weight));
        }
        return treeCost;
    }

    static class Edge implements Comparable<Edge> {
        public int to, weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        public int compareTo(Edge e) {
            return weight - e.weight;
        }
    }
}
