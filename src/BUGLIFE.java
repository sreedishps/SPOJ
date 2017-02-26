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
    static boolean homo = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer T = Integer.parseInt(br.readLine());
        int counter  = 0;
        while (T-- > 0) {
            counter++;
            String temp[] = br.readLine().split(" ");
            Integer N = Integer.parseInt(temp[0]);
            Integer I = Integer.parseInt(temp[1]);
            homo = false;

            adj = new HashMap<>();
            while (I-- > 0) {
                temp = br.readLine().split(" ");
                Integer n1 = Integer.parseInt(temp[0]);
                Integer n2 = Integer.parseInt(temp[1]);
                addEdge(n1, n2, adj);
            }

            visited = new boolean[N+1];
            set1 = new boolean[N+1];
            set2 = new boolean[N+1];

            Queue queue = new LinkedList<>();

            for (Integer node : adj.keySet()) {
                if (!visited[node]) {
                    queue.add(node);
                    set1[node] = true;
                    BFS(queue);
                }
            }

            if(homo){
                System.out.println("Scenario #"+counter+":");
                System.out.println("Suspicious bugs found!");
            }else {
                System.out.println("Scenario #"+counter+":");
                System.out.println("No suspicious bugs found!");
            }
        }
    }

    private static void BFS(Queue queue) {
        Boolean set1Flag = true;

        while (!queue.isEmpty()) {
            if(homo){
                break;
            }
            Integer node = (Integer) queue.remove();
            visited[node] = true;


            if(set1[node]){
                set1Flag = true;
            }else {
                set1Flag = false;
            }

            if(!check(node,set1Flag)){
                homo = true;
            }

            List<Integer> neighbours = adj.get(node);
            if(neighbours == null){
                continue;
            }
            for(Integer n : neighbours){
                if(!visited[n]){
                    queue.add(n);
                    if(set1Flag){
                        set2[n] = true;
                    }else {
                        set1[n] = true;
                    }

                    if(!check(node,set1Flag)){
                        homo = true;
                    }
                }else {
                    if(set1Flag){
                        set2[n] = true;
                    }else {
                        set1[n] = true;
                    }
                    if(!check(node,set1Flag)){
                        homo = true;
                    }
                }
            }
        }

    }

    private static boolean check(Integer node, Boolean set1Flag) {
        if(set1[node] && set2[node]){
            return false;
        }
        if(set1Flag){
            if(set2[node]){
                return false;
            }
        }else {
            if(set1[node]){
                return false;
            }
        }

        return true;
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
