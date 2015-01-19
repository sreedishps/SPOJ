import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sreedish.ps on 01/10/14.
 */
public class PALIN {
    public static void main(String[] args) throws IOException{
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N;
        N = Integer.parseInt(br.readLine());
        while(N > 0){
            N--;
            String str = "0"+br.readLine();

            char[]  arr =  str.toCharArray();
            int len = str.length();

            //reverse it
            for(int i=0;i<len/2;i++){
                char temp = arr[i];
                arr[i] = arr[len-1-i];
                arr[len-1-i] = temp;
            }
            while(true) {
                len = plusOne(arr, len);
                if(palin(arr,len)){
                    break;
                }
            }

            printNum(arr, len);



        }
    }

    private static boolean palin(char[] arr, int len) {
        if(arr[len-1] == '0'){
            len--;
        }
        for(int i=0;i<len/2;i++){
            if(arr[i] != arr[len-1-i]){
                return false;
            }
        }
        return true;
    }

    private static void printNum(char[] arr, int len) {
        if(arr[len-1] == '0'){
            len--;
        }
        for(int i=0;i<len;i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }

    private static int plusOne(char[] arr, int len) {
        int carry =0;
        int one =1;
        for(int i=0;i<len;i++){
            Integer dig = Integer.parseInt(arr[i]+"");
            dig = dig + one + carry;
            one = 0;
            arr[i] = ((dig%10)+"").toCharArray()[0] ;
            carry = dig/10;
            if(carry == 0){
                break;
            }
        }
        if(carry == 1){
            arr[len] = 1;
            return len+1;
        }
        return len;
    }
}
