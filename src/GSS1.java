import java.io.*;
import java.util.*;
import static java.lang.Math.max;

/**
 * Created by sreedish.ps on 27/12/14.
 */
public class GSS1 {
  static int tree[];
  static Integer N;
  private static Reader in;

  public static void main(String[] args) throws IOException{

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintStream out = new PrintStream(new BufferedOutputStream(System.out));
    in = new Reader();
    N = Integer.parseInt(br.readLine());
    int arr[] =new int[N];
    for (int i = 0; i < N; i++) {
      arr [i] = in.nextInt ();
    }
    int height = (int)(Math.ceil(Math.log(N) /  Math.log(2)));
    int  maxsize = 2 * (int) Math.pow(2, height) - 1;
    tree = new int[maxsize];
   // long startTime = System.nanoTime();
    constructSegmentTree(N,arr);
   // System.out.println("Time taken (in ms)= "+
     // (System.nanoTime() - startTime) / 1E6);
    Integer M = Integer.parseInt(br.readLine());
    String s;
    for(int i =0 ;i<M;i++){
      s = br.readLine();
      out.println(getMax(Integer.parseInt(s.split(" ")[0]) -1 ,Integer.parseInt(s.split(" ")[1]) -1));
      out.flush();
    }
  }

  private static int getMax(int querystart, int queryend) {

    return getSumUtil(0, N-1, querystart, queryend, 0);

  }

  private static int getSumUtil(int start, int end, int queryStart, int queryEnd, int current) {
    if (queryStart <= start && queryEnd >= end )
    {
      return tree[current];
    }
    if (end < queryStart || start > queryEnd)
    {
      return -16000;
    }
    int mid = midFind(start, end);
    return  Math.max(getSumUtil(start, mid, queryStart, queryEnd, leftchild(current))
      , getSumUtil( mid + 1, end, queryStart, queryEnd, rightchild(current)));

  }

  private static void constructSegmentTree(Integer n, int[] arr) {
    constructSegmentTreeUtil(arr, 0, n - 1, 0);

  }

  private static int constructSegmentTreeUtil(int[] arr, int start, int end, int current) {
    if(start == end){
      tree[current] = arr[start];
      return tree[current];
    }
    int mid = midFind(start, end);
    tree[current] = Math.max(constructSegmentTreeUtil(arr, start, mid, 2 * current + 1)
      , constructSegmentTreeUtil(arr, mid + 1, end, 2 * current + 2));

    return tree[current];
  }

  private static int midFind(int start, int end) {
    return (start + (end - start) / 2);
  }
  private static int leftchild(int pos)
  {
    return 2 * pos + 1;
  }

  private static int rightchild(int pos)
  {
    return 2 * pos + 2;
  }
  /** Faster input **/
  static class Reader {
    final private int BUFFER_SIZE = 1 << 16;private DataInputStream din;private byte[] buffer;private int bufferPointer, bytesRead;
    public Reader(){din=new DataInputStream(System.in);buffer=new byte[BUFFER_SIZE];bufferPointer=bytesRead=0;
    }public Reader(String file_name) throws IOException{din=new DataInputStream(new FileInputStream(file_name));buffer=new byte[BUFFER_SIZE];bufferPointer=bytesRead=0;
    }public String readLine() throws IOException{byte[] buf=new byte[64];int cnt=0,c;while((c=read())!=-1){if(c=='\n')break;buf[cnt++]=(byte)c;}return new String(buf,0,cnt);
    }public int nextInt() throws IOException{int ret=0;byte c=read();while(c<=' ')c=read();boolean neg=(c=='-');if(neg)c=read();do{ret=ret*10+c-'0';}while((c=read())>='0'&&c<='9');if(neg)return -ret;return ret;
    }public long nextLong() throws IOException{long ret=0;byte c=read();while(c<=' ')c=read();boolean neg=(c=='-');if(neg)c=read();do{ret=ret*10+c-'0';}while((c=read())>='0'&&c<='9');if(neg)return -ret;return ret;
    }public double nextDouble() throws IOException{double ret=0,div=1;byte c=read();while(c<=' ')c=read();boolean neg=(c=='-');if(neg)c = read();do {ret=ret*10+c-'0';}while((c=read())>='0'&&c<='9');if(c=='.')while((c=read())>='0'&&c<='9')ret+=(c-'0')/(div*=10);if(neg)return -ret;return ret;
    }private void fillBuffer() throws IOException{bytesRead=din.read(buffer,bufferPointer=0,BUFFER_SIZE);if(bytesRead==-1)buffer[0]=-1;
    }private byte read() throws IOException{if(bufferPointer==bytesRead)fillBuffer();return buffer[bufferPointer++];
    }public void close() throws IOException{if(din==null) return;din.close();}
  }
}
