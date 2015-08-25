import java.io.*;
import java.util.HashSet;
import java.util.Iterator;


public class ETF {
  static boolean sieve[];

  public static void main(String[] args) throws IOException {
    sieve = primeSieve(1002);

    Reader in = new Reader();
        PrintWriter out = new PrintWriter(System.out, true);
        int T = in.nextInt();


    while (T-- > 0) {
      Integer N = in.nextInt();
      //  for(int i=1;i<=1000000;i++) {
      // N=i;
      if (N == 1) {
        System.out.println(1);
        continue;
      }
      HashSet<Integer> factors = findFactors(N);
      System.out.println(totientFunction(N, factors));
    }
    //  }

  }

  private static HashSet<Integer> findFactors(int i) {
    HashSet<Integer> factors = new HashSet<Integer>();
    int j = 2;
    int limit = (int) Math.sqrt(i);
    while (j <= limit) {
      while (!sieve[j] && j <= limit) {
        j++;
      }
      if (i % j == 0) {
        factors.add(j);
        i = i / j;
      }
      while (i % j == 0) {
        i = i / j;
      }
      j++;
    }
    if (i >= limit) {
      factors.add(i);
    }
    return factors;
  }

  private static Long totientFunction(int i, HashSet<Integer> factors) {
    Long numerator = new Long(i + "");
    Iterator<Integer> itr = factors.iterator();
    while (itr.hasNext()) {
      numerator = numerator * (itr.next() - 1);
    }
    Iterator<Integer> itr2 = factors.iterator();
    while (itr2.hasNext()) {
      numerator = numerator / (itr2.next());
    }
    return numerator;
  }

  public static boolean[] primeSieve(int a) {
    boolean[] arr = new boolean[a];

    for (int i = 0; i < a; i++) {
      arr[i] = true;
    }
    arr[0] = arr[1] = false;

    for (int i = 0; i < a; i++) {
      if (!arr[i]) {
        continue;
      }
      for (int j = i + i; j < a; j += i) {
        arr[j] = false;
      }
    }

    return arr;
  }


  /**
   * Faster input
   **/
  static class Reader {
    final private int BUFFER_SIZE = 1 << 16;
    private DataInputStream din;
    private byte[] buffer;
    private int bufferPointer, bytesRead;

    public Reader() {
      din = new DataInputStream(System.in);
      buffer = new byte[BUFFER_SIZE];
      bufferPointer = bytesRead = 0;
    }

    public Reader(String file_name) throws IOException {
      din = new DataInputStream(new FileInputStream(file_name));
      buffer = new byte[BUFFER_SIZE];
      bufferPointer = bytesRead = 0;
    }

    public String readLine() throws IOException {
      byte[] buf = new byte[64];
      int cnt = 0, c;
      while ((c = read()) != -1) {
        if (c == '\n') break;
        buf[cnt++] = (byte) c;
      }
      return new String(buf, 0, cnt);
    }

    public int nextInt() throws IOException {
      int ret = 0;
      byte c = read();
      while (c <= ' ') c = read();
      boolean neg = (c == '-');
      if (neg) c = read();
      do {
        ret = ret * 10 + c - '0';
      } while ((c = read()) >= '0' && c <= '9');
      if (neg) return -ret;
      return ret;
    }

    public long nextLong() throws IOException {
      long ret = 0;
      byte c = read();
      while (c <= ' ') c = read();
      boolean neg = (c == '-');
      if (neg) c = read();
      do {
        ret = ret * 10 + c - '0';
      } while ((c = read()) >= '0' && c <= '9');
      if (neg) return -ret;
      return ret;
    }

    public double nextDouble() throws IOException {
      double ret = 0, div = 1;
      byte c = read();
      while (c <= ' ') c = read();
      boolean neg = (c == '-');
      if (neg) c = read();
      do {
        ret = ret * 10 + c - '0';
      } while ((c = read()) >= '0' && c <= '9');
      if (c == '.')
        while ((c = read()) >= '0' && c <= '9') ret += (c - '0') / (div *= 10);
      if (neg) return -ret;
      return ret;
    }

    private void fillBuffer() throws IOException {
      bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
      if (bytesRead == -1) buffer[0] = -1;
    }

    private byte read() throws IOException {
      if (bufferPointer == bytesRead) fillBuffer();
      return buffer[bufferPointer++];
    }

    public void close() throws IOException {
      if (din == null) return;
      din.close();
    }
  }
}
