import com.sun.org.apache.xerces.internal.impl.dv.xs.BooleanDV;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by sreedish.ps on 12/17/15.
 */
public class BUGLIFE {
    static boolean visited[];
    static boolean set1[];
    static boolean set2[];
    static HashMap<Integer, List<Integer>> adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String temp[] = br.readLine().split(" ");
            Integer N = Integer.parseInt(temp[0]);
            Integer I = Integer.parseInt(temp[1]);

            adj = new HashMap<>();
            while (I-- > 0) {
                temp = br.readLine().split(" ");
                Integer n1 = Integer.parseInt(temp[0]);
                Integer n2 = Integer.parseInt(temp[0]);
                addEdge(n1, n2, adj);
            }

            visited = new boolean[N];
            set1 = new boolean[N];
            set2 = new boolean[N];

            Queue queue = new LinkedList<>();

            for (Integer node : adj.keySet()) {
                if (!visited[node]) {
                    queue.add(node);
                    visited[node] = true;
                    BFS(queue);
                }
            }
        }
    }

    private static void BFS(Queue queue) {
        Boolean flip = true;
        while (!queue.isEmpty()) {
            Integer node = (Integer) queue.remove();
            if(node.equals(-1)){
                if(queue.isEmpty()){
                    break;
                }
                flip = !flip;
            }
            List<Integer> neighbours = adj.get(queue);
            for(Integer n : neighbours){
                if(!visited[n]){
                    queue.add(n);
                }
            }
        }

    }

    private static void addEdge(Integer n1, Integer n2, HashMap<Integer, List<Integer>> adj) {
        if (adj.containsKey(n1)) {
            adj.get(n1).add(n2);
        } else {
            List<Integer> list = new ArrayList<>();
            list.add(n2);
            adj.put(n1, list);
        }

        if (adj.containsKey(n2)) {
            adj.get(n1).add(n1);
        } else {
            List<Integer> list = new ArrayList<>();
            list.add(n1);
            adj.put(n2, list);
        }

    }
}
