import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by sreedish on 27/2/17.
 */
public class BugLife2Colouring {
    private static int[] color;
    private  static  ArrayList<Integer> [] adj  ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer T = Integer.parseInt(br.readLine());

        int counter = 0;
        while (T-- > 0) {

            String temp[] = br.readLine().split(" ");
            Integer N = Integer.parseInt(temp[0]);
            Integer I = Integer.parseInt(temp[1]);

             adj = new ArrayList[N];

            for(int i =0;i<N ;i++){
                adj[i] = new ArrayList<Integer>();
            }

            while (I-- > 0) {
                temp = br.readLine().split(" ");
                Integer n1 = Integer.parseInt(temp[0]) - 1;
                Integer n2 = Integer.parseInt(temp[1]) - 1;

                adj[n1].add(n2);
                adj[n2].add(n1);
            }

            System.out.println("Scenario #" + ++counter + ":");

            boolean ok = true;
            for (int i = 0; i < N; i++)
                if (color [i] == 0 && !clr (i, 1)) {
                    ok = false; break;
                }
            if (!ok) System.out.println("Suspicious bugs found!");
            else      System.out.println("No suspicious bugs found!");

        }
    }

    private static boolean clr(int node, int col) {
        if(color[node] != 0)
            return color[node] == col;

        int nc = (col == 1 ? 2 : 1);
        color[node] = col;

        for(int adjacent : adj[node]) {
            if(!clr(adjacent,nc)){
                return false;
            }
        }
        return true;
    }
}
