import java.io.DataInputStream;
import java.io.IOException;

public class BYECAKES {

  public static void main(String[] args) throws IOException {
    Reader4 in = new Reader4();
    int arr[] = new int[8];
    while (true) {
      boolean breakFlag = true;
       for (int i = 0; i < 8; i++) {
        arr[i] = in.nextInt();
         if(arr[i] != -1 && breakFlag){
           breakFlag = false;
         }
      }

      if(breakFlag){
        break;
      }

      int maxCakes = 0;
      for (int i = 0; i < 4; i++) {
        if (arr[i] == 0 || arr[i + 4] == 0) {
          continue;
        }
        int max = (int) Math.ceil((double) arr[i ] / (double) arr[i+4]);
        if(max > maxCakes){
          maxCakes = max;
        }
      }

      for(int i =0;i<4 ; i++){
        System.out.printf( (arr[i+4] * maxCakes) - arr[i]  +" ");
      }
      System.out.println();
    }
  }


}

class Reader4 {
  final private int BUFFER_SIZE = 1 << 16;
  private DataInputStream din;
  private byte[] buffer;
  private int bufferPointer, bytesRead;

  public Reader4() {
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
