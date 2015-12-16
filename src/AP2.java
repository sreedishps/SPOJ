import java.io.*;
public class AP2 {
  public static void main(String[] args) throws IOException {
    BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(f.readLine());
    Reader2 in = new Reader2();
    while (t-- > 0) {
      Integer s3 = in.nextInt();
      Integer sn3 = in.nextInt() ;
      Integer sum = in.nextInt();
      Integer n = (2 * sum) / (s3 + sn3);
      Integer d = (sn3 - s3) / (n - 5);
      Integer a = s3 - (2 * d);
      System.out.println(n);
      for (int i = 0; i < n; i++) {
        System.out.print((a + (i * d)) + " ");
      }
      System.out.println();
    }
  }
}
class Reader2 {
		final private int			BUFFER_SIZE	= 1 << 16;
		private DataInputStream din;
		private byte []			buffer;
		private int					bufferPointer, bytesRead;
		public Reader2() {
			din = new DataInputStream (System.in);
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}
		public int nextInt () throws IOException {
			int ret = 0;
			byte c = read ();
			while (c <= ' ')
				c = read ();
			boolean neg = (c == '-');
			if (neg) c = read ();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read ()) >= '0' && c <= '9');
			if (neg) return -ret;
			return ret;
		}
		private void fillBuffer () throws IOException {
			bytesRead = din.read (buffer, bufferPointer = 0, BUFFER_SIZE);
			if (bytesRead == -1) buffer[0] = -1;
		}
		private byte read () throws IOException {
			if (bufferPointer == bytesRead) fillBuffer ();
			return buffer[bufferPointer++];
		}
	}
