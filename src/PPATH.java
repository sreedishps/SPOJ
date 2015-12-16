import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class PPATH {
  static boolean sieve[];

  public static void main(String[] args) throws IOException {
    sieve = new boolean[10000];

    for (int i = 2; i < Math.sqrt(10000); ) {
      for (int j = i; j < 10000; j += i) {
        sieve[j] = true;
      }

      while (sieve[i] && i < Math.sqrt(10000)) {
        i++;
      }
    }

    ArrayList<Integer> nodes = new ArrayList<Integer>();
    for (int i = 1000; i < 10000; i++) {
      if (!sieve[i]) {
        nodes.add(i);
      }
    }

    ArrayList<Integer> adj[] = new ArrayList[nodes.size()];
    HashMap<Integer, Integer> index = new HashMap<Integer, Integer>();
    int i = 0;
    for (Integer node : nodes) {
      adj[i] = new ArrayList<Integer>();
      index.put(node, i);
      for (Integer neighbour : nodes) {
        if (distance(node, neighbour)) {
          adj[i].add(neighbour);
        }
      }
      i++;
    }

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Integer T = Integer.parseInt(br.readLine());

    while (T-- > 0) {
      String temp[] = br.readLine().split(" ");
      Integer source = Integer.parseInt(temp[0]);
      Integer dest = Integer.parseInt(temp[1]);


      Queue<Integer> levelOrder = new LinkedList<Integer>();
      levelOrder.add(source);
      levelOrder.add(10000);
      HashSet<Integer> visited = new HashSet<Integer>();

      int cost = 0;
      boolean foundflag = false;
      while (!levelOrder.isEmpty()) {
        Integer currentNode = levelOrder.remove();
        visited.add(currentNode);
        if (currentNode.equals(dest)) {
          foundflag = true;
          break;
        }
        if (currentNode.equals(10000)) {
          cost++;
          if (!levelOrder.isEmpty()) {
            levelOrder.add(10000);
          }
          continue;
        }

        for (Integer adjacent : adj[index.get(currentNode)]) {
          if (visited.contains(adjacent)) {
            continue;
          }
          levelOrder.add(adjacent);
        }
      }
      if (foundflag)
        System.out.println(cost);
      else {
        System.out.println("Impossible");
      }

    }
  }

  private static boolean distance(Integer node, Integer neighbour) {
    int distance = 0;
    for (int i = 0; i < 4; i++) {
      if (node % 10 != neighbour % 10) {
        distance++;
        if (distance > 2) {
          return false;
        }
      }
      node /= 10;
      neighbour /= 10;

    }
    return (distance == 1);
  }
}
