import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by sreedish.ps on 2/12/16.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println(findShortestNewSequence("HIHI"));
        System.out.println(findShortestNewSequence("A"));
        System.out.println(findShortestNewSequence("AACAGATGCT"));
    }


    static ArrayList printAllKLength(char set[], int k) {
        int n = set.length;
        ArrayList<String> strings = new ArrayList<>();
        printAllKLengthRec(set, "", n, k, strings);
        return strings;
    }

    static void printAllKLengthRec(char set[], String prefix, int n, int k, ArrayList strings) {
        if (k == 0) {
            strings.add(prefix);
            return;
        }
        for (int i = 0; i < n; ++i) {
            String newPrefix = prefix + set[i];
            printAllKLengthRec(set, newPrefix, n, k - 1, strings);
        }
    }

    public static String findShortestNewSequence(String sequence) {
        char set2[] = {'A', 'C', 'G', 'T'};
        ArrayList<String> strings;
        for (int i = 1; i <= 2000; i++) {
            strings = printAllKLength(set2, i);
            for (String string : strings) {
                if (!sequence.contains(string)) {
                    return string;
                }
            }
        }
        return null;
    }

    public static int longestDNASequence(String sequence) {
        int current = 0;
        int max = 0;
        for (int i = 0; i < sequence.length(); i++) {
            if (sequence.charAt(i) == 'A' || sequence.charAt(i) == 'C' || sequence.charAt(i) == 'G' || sequence.charAt(i) == 'T') {
                current++;
            } else {
                if (current > max) {
                    max = current;
                }
                current = 0;
            }
        }
        if (current > max) {
            max = current;
        }
        return max;
    }

    static Integer row;

    private static String direction(Integer num) {
        if (row % 2 == 0) {
            if (num % 5 < 2) {
                return "L";
            } else {
                return "R";
            }
        } else {
            if (num % 5 == 2 || num % 5 == 3) {
                return "L";
            } else {
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

class Reader5 {
    final private int BUFFER_SIZE = 1 << 16;
    private DataInputStream din;
    private byte[] buffer;
    private int bufferPointer, bytesRead;

    public Reader5() {
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

