import java.io.*;
import java.math.BigInteger;

public class HOTELS {
  private static Reader in = new Reader();
  public static void main(String[] args) throws IOException {
    String temp[] = in.readLine().replace("\n","").split(" ");
    Integer N = Integer.parseInt(temp[0]);
    BigInteger M = new BigInteger(temp[1])   ;

    temp = in.readLine().replace("\n","").replace("  "," ").split(" ");

    int hotels[] = new int[N];

    for (int i = 0; i < N; i++) {
      hotels[i] = Integer.parseInt(temp[i]);
    }

    int maximumValue = 0;

    int tail = 0, head = 0;
    BigInteger currentSum = new BigInteger(hotels[0]+"");
    BigInteger difference = BigInteger.ZERO;
    BigInteger mindifference = new BigInteger(M+"") ;

    while (head < N) {
      if (currentSum.compareTo(M) == -1) {

        difference = M.subtract(currentSum);
        if (difference.compareTo(mindifference) == -1) {
          mindifference = difference;
        }
        head++;
        if(head == N){
          break;
        }
        currentSum = currentSum.add(new BigInteger(hotels[head] + ""));

      } else if (currentSum.compareTo(M) == 1) {
        currentSum = currentSum.subtract(new BigInteger(hotels[tail] + ""));
        tail++;
      }  else{
        mindifference = BigInteger.ZERO;
        break;
      }
    }

    System.out.println(M.subtract(mindifference));
  }

  static class Reader
     {
         final private int BUFFER_SIZE = 1 << 16;

         private DataInputStream din;
         private byte[] buffer;
         private int bufferPointer, bytesRead;

         public Reader()
         {
             din = new DataInputStream(System.in);
             buffer = new byte[BUFFER_SIZE];
             bufferPointer = bytesRead = 0;
         }

         public Reader(String file_name) throws IOException
         {
             din = new DataInputStream(new FileInputStream(file_name));
             buffer = new byte[BUFFER_SIZE];
             bufferPointer = bytesRead = 0;
         }

         public String readLine() throws IOException
         {
             byte[] buf = new byte[64]; // line length
             int cnt = 0, c;
             while( (c=read()) != -1) {
                 buf[cnt++] = (byte)c;
                 if(c == '\n') break;
             }
             return new String(buf,0,cnt);
         }

         public int nextInt() throws IOException
         {
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

         public long nextLong() throws IOException
         {
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

         public double nextDouble() throws IOException
         {
             double ret = 0, div = 1;
             byte c = read();
             while(c <= ' ') c = read();
             boolean neg = c == '-';
             if(neg) c = read();
             do {
                 ret = ret * 10 + c - '0';
                 c = read();
             } while (c >= '0' && c <= '9');
             if(c == '.')
                 while((c=read()) >= '0' && c <= '9') {
                     div *= 10;
                     ret = ret + (c - '0') / div;
                 }
             if (neg) return -ret;
             return ret;
         }

         private void fillBuffer() throws IOException
         {
             bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
             if (bytesRead == -1) buffer[0] = -1;
         }

         private byte read() throws IOException
         {
             if (bufferPointer == bytesRead) fillBuffer();
             return buffer[bufferPointer++];
         }

         public void close() throws IOException
         {
             if(din == null) return;
             din.close();
         }
     }

}
