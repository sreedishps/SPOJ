import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by sreps on 7/30/2016.
 */
public class CLOSEFAR {
    static HashMap<Integer,HashSet<Integer>> adj = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.parseInt(br.readLine());
        Integer values[] = new Integer[N+1];
        String temp[] = br.readLine().split(" ");

        for(int i =1; i <= N ; i++){
            values[i] = Integer.parseInt(temp[i]);
            adj.put(i,new HashSet<Integer>());
        }


        for(int i =0; i < N-1 ; i++){
            temp = br.readLine().split(" ");
            Integer A = Integer.parseInt(temp[0]);
            Integer B = Integer.parseInt(temp[1]);

            adj.get(A).add(B);
            adj.get(B).add(A);
        }

        Integer Q = Integer.parseInt(br.readLine());
        while (Q-- > 0){
            temp = br.readLine().split(" ");
            boolean visited[] = new boolean[N+1];
            if(temp[0].equals("F")){
                Integer A = Integer.parseInt(temp[1]);
                Integer B = Integer.parseInt(temp[2]);
                HashSet<Integer> path = dfs(A,B,visited, new HashSet<Integer>());

            }else {

            }
        }

    }

    private static HashSet<Integer> dfs(Integer a, Integer b, boolean[] visited,HashSet<Integer> path ) {
        for(Integer adjacent : adj.get(a)){
            path.add(adjacent);
            if(adjacent == b){
                return path;
            }
            path.remove(adjacent);
        }
        return null;
    }
}
