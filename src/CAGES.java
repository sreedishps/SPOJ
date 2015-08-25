import java.io.*;
import java.util.Arrays;

public class CAGES {
  static Integer M;
  static char[] light;
  static int[] cage;
  static char startLight = 'A';
  static boolean[] lit;
  static int A = 0, B = 0, C = 0;

  private static Reader1 in = new Reader1();
  ;
  private static PrintWriter out = new PrintWriter(System.out, true);
  ;


  public static void main(String[] args) throws IOException {
    Integer N = in.nextInt();
    M = N;
    light = new char[N + 1];
    lit = new boolean[N + 1];
    cage = new int[N + 1];
    int counter = 1;

    while (N-- > 0) {
      cage[counter] = in.nextInt();
      counter++;
    }

    int startCage = 1;
    while (startCage != 0) {
      startCage = check(lit);
      lightChain(startCage);
    }


      System.out.print(Arrays.copyOfRange(light, 1, M+1));

  }

  private static void lightChain(int startCage) {
    if (startCage == 0) {
      return;
    }
    char sos = startLight;
    int startOfCycle = startCage;
    int Atemp = A;
    int Btemp = B;
    int Ctemp = C;
    while (true) {
      light[startCage] = startLight;
      increment(startLight);
      lit[startCage] = true;
      if ((startLight == light[startOfCycle]) && (startOfCycle == cage[startCage])) {
        startLight = getNextLight(startLight);
        decrement(light[startCage]);
        light[startCage] = startLight;
        increment(startLight);
      }
      startCage = cage[startCage];
      startLight = getNextLight(startLight);

      if (startCage == startOfCycle) {
        if (!notBalanced()) {
          A = Atemp;
          B = Btemp;
          C = Ctemp;
          startLight = getNextLight(sos);
          lightChain(startOfCycle);
        }
        break;
      }
    }

//    System.out.println("Start of cycle " + startOfCycle);
//    System.out.println(A + " " + B + " " + C);
  }

  private static boolean notBalanced() {
    if (Math.abs(A - B) > 1) {
      return false;
    }
    if (Math.abs(C - B) > 1) {
      return false;
    }
    if (Math.abs(A - C) > 1) {
      return false;
    }
    return true;
  }

  private static void decrement(char startLight) {
    if (startLight == 'A')
      A--;
    if (startLight == 'B')
      B--;
    if (startLight == 'C')
      C--;
  }

  private static void increment(char startLight) {
    if (startLight == 'A')
      A++;
    if (startLight == 'B')
      B++;
    if (startLight == 'C')
      C++;
  }

  private static char getNextLight(char startLight) {
    if (startLight == 'A')
      return 'B';
    if (startLight == 'B')
      return 'C';
    if (startLight == 'C')
      return 'A';

    return 'A';
  }

  private static int check(boolean[] lit) {
    for (int i = 1; i <= M; i++) {
      if (!lit[i]) {
        return i;
      }
    }
    return 0;
  }


  /**
   * Faster input
   **/
  static class Reader1 {
    final private int BUFFER_SIZE = 1 << 16;

    private DataInputStream din;
    private byte[] buffer;
    private int bufferPointer, bytesRead;

    public Reader1() {
      din = new DataInputStream(System.in);
      buffer = new byte[BUFFER_SIZE];
      bufferPointer = bytesRead = 0;
    }

    public Reader1(String file_name) throws IOException {
      din = new DataInputStream(new FileInputStream(file_name));
      buffer = new byte[BUFFER_SIZE];
      bufferPointer = bytesRead = 0;
    }

    public String readLine() throws IOException {
      byte[] buf = new byte[64]; // line length
      int cnt = 0, c;
      while ((c = read()) != -1) {
        buf[cnt++] = (byte) c;
        if (c == '\n') break;
      }
      return new String(buf, 0, cnt);
    }

    public int nextInt() throws IOException {
      int ret = 0;
      byte c = read();
      while (c <= ' ') c = read();
      boolean neg = c == '-';
      if (neg) c = read();
      do {
        ret = ret * 10 + c - '0';
        c = read();
      } while (c >= '0' && c <= '9');
      if (neg) return -ret;
      return ret;
    }

    public long nextLong() throws IOException {
      long ret = 0;
      byte c = read();
      while (c <= ' ') c = read();
      boolean neg = c == '-';
      if (neg) c = read();
      do {
        ret = ret * 10 + c - '0';
        c = read();
      } while (c >= '0' && c <= '9');
      if (neg) return -ret;
      return ret;
    }

    public double nextDouble() throws IOException {
      double ret = 0, div = 1;
      byte c = read();
      while (c <= ' ') c = read();
      boolean neg = c == '-';
      if (neg) c = read();
      do {
        ret = ret * 10 + c - '0';
        c = read();
      } while (c >= '0' && c <= '9');
      if (c == '.')
        while ((c = read()) >= '0' && c <= '9') {
          div *= 10;
          ret = ret + (c - '0') / div;
        }
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


