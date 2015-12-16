import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sreedish.ps on 11/30/15.
 */
public class TWENDS {
    static Integer dparr[][];
    static Integer greedy;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String temp = br.readLine();
            if (br.equals("0")) {
                return;
            }
            String inp[] = temp.split(" ");
            Integer input[] = new Integer[inp.length];
            for (int i = 0; i < inp.length; i++) {
                input[i] = Integer.parseInt(inp[i]);
            }

            dparr = new Integer[input.length+1][input.length+1];
            for (int i = 0; i <= input.length; i++) {
                for (int j = 0; j <= input.length; j++) {
                    dparr[i][j] = -1;
                }
            }
            greedy =0;
            Integer dp = calculate(0,input.length-1,input,0,true);
            Integer total = 0;
            for (int i = 0; i < input.length; i++) {
                total += input[i];
            }
            System.out.println(dp - (total - dp));
        }
    }

    private static Integer calculate(int start, int end, Integer[] input,Integer value,boolean first) {
        if(start > end){
            return 0;
        }

        if(!dparr[start][end].equals(-1)){
            return dparr[start][end];
        }

        //pick best one
        Integer valStart = input[start]+ calculate(start+1,end,input,value+input[start],false);
        Integer valEnd = input[end]+ calculate(start,end-1,input, value +input[end],false);

        dparr[start][end] =  Math.max(valEnd,valStart);

        if(valStart >= valEnd){
            if(input[start+1] >= input[end]){
                return calculate(start+2,end,input, value +input[start+1],false);
            }else {
                return calculate(start+1,end-1,input, value +input[end],false);
            }
        }else {
            if(input[start+1] >= input[end]){
                return calculate(start+1,end-1,input, value +input[start+1],false);
            }else {
                return calculate(start+1,end-2,input, value +input[end],false);
            }
        }



    }
}
