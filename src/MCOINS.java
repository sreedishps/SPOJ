import java.io.*;
import java.util.HashMap;

public class MCOINS {
  static int L, K;
  static HashMap<Integer, Boolean> win;
  static boolean winBit[] = new boolean[1000001];

  public static void main(String[] args) throws IOException {
    StdIn s = new StdIn(System.in);


    L = s.nextInt();
    K = s.nextInt();

    Integer N = s.nextInt();


    win = new HashMap<Integer, Boolean>();
    win.put(1, true);
    win.put(K, true);
    win.put(L, true);

    Long time = System.currentTimeMillis();
    for (int i = 1; i <= 10000; i++) {
      canWin(i * 100);
    }

  //  System.out.println("Time taken "+ (System.currentTimeMillis() - time));


    for (int i = 0; i < N; i++) {
      int num = s.nextInt();
      if (canWin(num)) {
        System.out.print("A");
      } else {
        System.out.print("B");
      }
    }
  }

  private static boolean canWin(int N) {

    if(winBit[N]){
         return true;
    }

    if (win.containsKey(N)) {
      return win.get(N);
    }

    if (N - K > 0) {
      boolean a = canWin(N - K);
      if (!a) {
        winBit[N] = true;
        return true;
      }
    }
    if (N - L > 0) {
      boolean a = canWin(N - L);
      if (!a) {
        winBit[N] = true;
        return true;
      }
    }

    if (N - 1 > 0) {
      boolean a = canWin(N - 1);
      if (!a) {
        winBit[N] = true;
        return true;
      }
    }

    win.put(N, false);
    return false;
  }


  private static class StdIn {
    final private int BUFFER_SIZE = 1 << 17;
    private DataInputStream din;
    private byte[] buffer;
    private int bufferPointer, bytesRead;

    public StdIn(InputStream in) {
      din = new DataInputStream(in);
      buffer = new byte[BUFFER_SIZE];
      bufferPointer = bytesRead = 0;
    }

    public int nextInt() {
      int ret = 0;
      byte c = read();
      while (c <= ' ') c = read();
      boolean neg = c == '-';
      if (neg) c = read();
      do {
        ret = ret * 10 + c - '0';
        c = read();
      } while (c > ' ');
      if (neg) return -ret;
      return ret;
    }

    private void fillBuffer() {
      try {
        bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
      } catch (Exception e) {
      }
      if (bytesRead == -1) buffer[0] = -1;
    }

    private byte read() {
      if (bufferPointer == bytesRead) fillBuffer();
      return buffer[bufferPointer++];
    }
  }

}
