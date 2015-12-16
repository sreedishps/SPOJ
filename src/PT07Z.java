import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class PT07Z {
  static int N;

  public static void main(String[] args) throws IOException {
    BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(f.readLine());
    if(N == 0){
      System.out.println("0");
      return;
    }

    ArrayList<Integer> adj[] = new ArrayList[N + 1];

    for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<Integer>();

    }

    for (int i = 1; i <= N - 1; i++) {
      String temp[] = f.readLine().split(" ");
      Integer u = Integer.parseInt(temp[0]);
      Integer v = Integer.parseInt(temp[1]);

      adj[u].add(v);
      adj[v].add(u);
    }

    Integer farthestNode = findFarthest(1, adj);
    Integer distance = findDistance(farthestNode, adj);
    System.out.println(distance-1);


  }

  private static Integer findDistance(Integer farthestNode,
                                      ArrayList<Integer>[] adj) {

    Queue<Integer> q = new LinkedList<Integer>();

    q.add(farthestNode);
    q.add(-1);
    boolean visited[] = new boolean[N + 1];
    int distance = 0;
    int farthest;
    while (!q.isEmpty()) {
      farthest = q.remove();
      if(farthest == -1){
        distance++;
        if(!q.isEmpty())   {
          q.add(-1) ;
        }
        continue;
      }
      visited[farthest] = true;
      for (int adjacent : adj[farthest]) {
        if (!visited[adjacent]) {
          q.add(adjacent);
        }
      }
    }

    return distance;
  }

  private static Integer findFarthest(int i, ArrayList<Integer>[] adj) {
    Queue<Integer> q = new LinkedList<Integer>();

    q.add(i);
    Integer farthest = i;
    boolean visited[] = new boolean[N + 1];

    while (!q.isEmpty()) {
      farthest = q.remove();
      visited[farthest] = true;
      for (int adjacent : adj[farthest]) {
        if (!visited[adjacent]) {
          q.add(adjacent);
        }
      }
    }
    return farthest;
  }

}
