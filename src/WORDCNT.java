import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by sreedish.ps on 1/25/16.
 */
public class WORDCNT {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.parseInt(in.readLine());
        Scanner sc = new Scanner(System.in);
        while (N-- > 0) {
            String temp = in.readLine();
            if(temp.length()==0){
                N++;
                continue;
            }
            StringTokenizer tokenizer = new StringTokenizer(temp);
            int currentStreak = 0, max = 0, currentLength = 0;
            while (tokenizer.hasMoreTokens()) {
                int length = tokenizer.nextToken().length();
                if (length == currentLength) {
                    currentStreak++;
                } else {
                    if (currentStreak > max) {
                        max = currentStreak;
                    }
                    currentStreak = 1;
                    currentLength = length;
                }
            }
            System.out.println(maxWords(temp));
        }
    }
    public static int maxWords(String str){
        String[] array = str.split(" ");
        int maxCount = 0;
        int prevLen = 0;
        int prevCount = 0;
        for(int i = 0; i < array.length; i++){
            int thisLen = array[i].length();
            if(thisLen==prevLen){
                prevCount++;
            }else{
                prevLen = thisLen;
                if(prevCount > maxCount){
                    maxCount = prevCount;
                }
                prevCount = 1;
            }
        }
        return maxCount;
    }
}
