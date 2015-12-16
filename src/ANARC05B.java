import java.io.DataInputStream;
import java.io.IOException;

public class ANARC05B {

  public static void main(String[] args) throws IOException {
    Reader3 in = new Reader3();
    while (true) {
      Integer n = in.nextInt();
      if (n.equals(0)) {
        break;
      }

      Integer arr1[] = new Integer[n];
      for (int i = 0; i < n; i++) {
        arr1[i] = in.nextInt();
      }

      Integer m = in.nextInt();

      Integer arr2[] = new Integer[m];
      for (int i = 0; i < m; i++) {
        arr2[i] = in.nextInt();
      }

      int pointer1 = 0, pointer2 = 0;
      Integer sum = 0, sum1 = 0, sum2 = 0;

      while (pointer1 < n && pointer2 < m) {
        if (arr1[pointer1].equals(arr2[pointer2])) {
          sum += Math.max(sum1, sum2);
          sum += arr1[pointer1];
          pointer1++;
          pointer2++;
          sum1 = 0;
          sum2 = 0;
        } else if (arr1[pointer1].compareTo(arr2[pointer2]) > 0) {
          sum2 += arr2[pointer2];
          pointer2++;
        } else {
          sum1 += arr1[pointer1];
          pointer1++;
        }
      }

      while (pointer1 < n) {
        sum1 += arr1[pointer1];
        pointer1++;
      }
      while (pointer2 < m) {
        sum2 += arr2[pointer2];
        pointer2++;
      }

      sum += Math.max(sum1, sum2);
      System.out.println(sum);
    }
  }

}

class Reader3 {
  final private int BUFFER_SIZE = 1 << 16;
  private DataInputStream din;
  private byte[] buffer;
  private int bufferPointer, bytesRead;

  public Reader3() {
    din = new DataInputStream(System.in);
    buffer = new byte[BUFFER_SIZE];
    bufferPointer = bytesRead = 0;
  }

  public int nextInt() throws IOException {
    int ret = 0;
    byte c = read();
    while (c <= ' ')
      c = read();
    boolean neg = (c == '-');
    if (neg) c = read();
    do {
      ret = ret * 10 + c - '0';
    } while ((c = read()) >= '0' && c <= '9');
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
}
