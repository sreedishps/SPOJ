import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by sreedish.ps on 2/6/16.
 */
public class DISUBSTR {

    static class Suffix implements Comparable {
        String suffix;
        Integer index;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Suffix suffix1 = (Suffix) o;

            return suffix != null ? suffix.equals(suffix1.suffix) : suffix1.suffix == null;

        }

        @Override
        public int hashCode() {
            return suffix != null ? suffix.hashCode() : 0;
        }

        public Suffix(String suffix, Integer index) {
            this.suffix = suffix;
            this.index = index;

        }

        @Override
        public int compareTo(Object o) {
            return this.suffix.compareTo(((Suffix)o).suffix);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String input = br.readLine();
            if(input.length() == 0){
                System.out.println("0");
                continue;
            }
            Suffix arr[] = buildSuffixArray(input);

            int count = 1;
            for(int i = 1; i <arr.length;i++){
                count += (arr[i].suffix.length() - LCS(arr[i-1].suffix,arr[i].suffix));
            }
            System.out.println(count);
        }
    }

    private static int LCS(String str1, String str2) {
        int count =0;
        if(str1.length() > str2.length()){
            for(int i =0;i<str2.length();i++){
                if(str1.charAt(i) == str2.charAt(i)){
                    count++;
                }else {
                    break;
                }
            }
        }else {
            for(int i =0;i<str1.length();i++){
                if(str1.charAt(i) == str2.charAt(i)){
                    count++;
                }else {
                    break;
                }
            }
        }
        //System.out.println(count);
        return count;
    }

    private static Suffix[] buildSuffixArray(String input) {
        Suffix suffixes[] = new Suffix[input.length()];
        for (int i = 0; i < input.length() ; i++) {
            suffixes[i] = new Suffix(input.substring(i, input.length()), i);
        }
        Arrays.sort(suffixes);
        return suffixes;
    }
}
