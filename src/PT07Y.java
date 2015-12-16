import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PT07Y {
  static int parent[];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String temp[] = br.readLine().split(" ");
    Integer N = Integer.parseInt(temp[0]);
    Integer M = Integer.parseInt(temp[1]);

    parent = new int[N + 1];
    boolean treeflag = true;

    for (int i = 0; i < M; i++) {
      temp = br.readLine().split(" ");
      if(!treeflag){
        continue;
      }
      int xparent = find(Integer.parseInt(temp[0]));
      int yparent = find(Integer.parseInt(temp[1]));

      if (xparent != yparent) {
        union(xparent, yparent);
      } else {
        treeflag = false;
      }
    }

    if (treeflag) {
      System.out.println("YES");
    } else {
      System.out.println("NO");
    }
  }

  private static void union(int xparent, int yparent) {
    parent[xparent] = yparent;
  }

  private static int find(int y) {
    if (parent[y] == 0) {
      return y;
    } else {
      return find(parent[y]);
    }
  }

}