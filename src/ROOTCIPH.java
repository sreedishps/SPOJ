//import java.io.DataInputStream;
//import java.io.IOException;
//
//public class ROOTCIPH {
//
//  public static void main(String[] args) throws IOException {
//    Reader6 in = new Reader6();
//    Integer T = in.nextInt();
//    while (T-- > 0) {
//      long a = in.nextLong(), b = in.nextLong()   ;
//              in.nextLong();   // Ignore c
//      System.out.println(a*a-(b<<1));
//    }
//  }
//
//
//}
//
//class Reader5 {
//  final private int BUFFER_SIZE = 1 << 16;
//  private DataInputStream din;
//  private byte[] buffer;
//  private int bufferPointer, bytesRead;
//
//  public Reader5() {
//    din = new DataInputStream(System.in);
//    buffer = new byte[BUFFER_SIZE];
//    bufferPointer = bytesRead = 0;
//  }
//
//
//  public long nextLong() throws IOException {
//            long result = 0;
//            byte c = read();
//            while (c <= ' ') c = read();
//            boolean neg = (c == '-');
//            if (neg) c = read();
//            while (c >= '0' && c <= '9') {
//                result = result * 10 + c - '0';
//                c = read();
//            }
//            if (neg) return -result;
//            return result;
//        }
//
//  public int nextInt() throws IOException {
//    int ret = 0;
//    byte c = read();
//    while (c <= ' ')
//      c = read();
//    boolean neg = (c == '-');
//    if (neg) c = read();
//    do {
//      ret = ret * 10 + c - '0';
//    } while ((c = read()) >= '0' && c <= '9');
//    if (neg) return -ret;
//    return ret;
//  }
//
//  private void fillBuffer() throws IOException {
//    bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
//    if (bytesRead == -1) buffer[0] = -1;
//  }
//
//  private byte read() throws IOException {
//    if (bufferPointer == bytesRead) fillBuffer();
//    return buffer[bufferPointer++];
//  }
//}
