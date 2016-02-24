import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sreedish.ps on 2/12/16.
 */
public class MYQ1 {
    static Integer row;
    public static void main(String[] args) throws IOException {
        Reader6 in = new Reader6();
        Integer T = in.nextInt();
        while (T-- > 0) {
            Integer num = in.nextInt();
            if (num.equals(1)) {
                System.out.println("poor conductor");
                continue;
            }

            row = row(num);
            System.out.println(row + " " + position(num) + " " + direction(num));
        }
    }

    private static String direction(Integer num) {
        if (row % 2 == 0) {
            if( num % 5 < 2){
                return "L";
            }else {
                return "R";
            }
        }else {
            if( num % 5 == 2 || num % 5 ==3){
                return "L";
            }else {
                return "R";
            }
        }
    }

    private static String position(Integer num) {
        if (num % 5 == 2 || num % 5 == 1) {
            return "W";
        }
        if (row % 2 == 1) {
            if (num % 5 == 0) {
                return "M";
            } else {
                return "A";
            }
        } else {
            if (num % 5 == 3) {
                return "M";
            } else {
                return "A";
            }
        }
    }

    private static Integer row(Integer num) {
        return ((num - 2) / 5 + 1);
    }
}

class Reader6 {
    final private int BUFFER_SIZE = 1 << 16;
    private DataInputStream din;
    private byte[] buffer;
    private int bufferPointer, bytesRead;

    public Reader6() {
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

