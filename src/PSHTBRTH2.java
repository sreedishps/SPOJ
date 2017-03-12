import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sreps on 3/11/2017.
 */
public class PSHTBRTH2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String temp[] = br.readLine().split(" ");
            Integer N = Integer.parseInt(temp[0]);
            Integer M = Integer.parseInt(temp[1]);

            Integer bitCount[] = new Integer[N];
            Integer blockCount[] = new Integer[N];

            for(int i =0; i<N; i++){
                boolean arr[][] = new boolean[4][4];
                for(int j = 0; j < 4 ; j++){
                    temp = br.readLine().split("");
                    for(int k = 0 ; k < 4;k++){
                        if(temp[k].equals("1")){
                            arr[j][k] = true;
                        }else {
                            arr[j][k] = false;
                        }
                    }
                }

                br.readLine();
                bitCount[i] = getBitCount(arr);
                blockCount[i]  = getBlockCount(arr);

                System.out.println(bitCount[i] +" "+ blockCount[i]);
            }

            for(int query = 0 ; query < M ; query++){
                temp = br.readLine().split(" ");
                if(temp[0].equals("1")){
                    System.out.println(solve(bitCount, blockCount, Integer.parseInt(temp[1]) - 1 ,Integer.parseInt(temp[2]) - 1 ));
                }else {

                    Integer index = Integer.parseInt(temp[1]) - 1;
                    boolean arr[][] = new boolean[4][4];
                    for(int j = 0; j < 4 ; j++){
                        temp = br.readLine().split("");
                        for(int k = 0 ; k < 4;k++){
                            if(temp[k].equals("1")){
                                arr[j][k] = true;
                            }else {
                                arr[j][k] = false;
                            }
                        }
                    }
                    bitCount[index] = getBitCount(arr);
                    blockCount[index]  = getBlockCount(arr);
                }
            }
        }
    }

    private static String solve(Integer[] bitCount, Integer[] blockCount, int L, int R) {
        Integer totalBits = 0;
        Integer totalBlock = 0;

        for(int i = L ; i <= R ; i++){
            totalBits += bitCount[i];
            totalBlock += blockCount[i];
        }
        if(totalBits % 2 == 0 && totalBlock % 2 == 0){
            return "Lotsy";
        }
        return "Pishty";
    }

    private static Integer getBlockCount(boolean[][] arr) {
        int counter = 0;
        for(int j = 0; j < 4 ; j++){
            for(int k = 0 ; k < 4;k++){
                if(arr[j][k]){
                    counter++;
                    // nullify that square block
                    int rowMax = 0;
                    for(int row = k ; row < 4 ; row++){
                        if(arr[j][row]){
                            rowMax++;
                            arr[j][row] = false;
                        }else {
                            break;
                        }
                    }

                    for(int row = j+1; row < 4 ; row++){
                        boolean flag2 = true;
                        for(int col = 0 ; col < rowMax ; col++){
                            if(!arr[row][col+ k]){
                                flag2 = false;
                            }
                        }

                        if(flag2){
                            for(int col = 0 ; col < rowMax ; col++){
                                arr[row][col+ k] = false;
                            }
                        }else {
                            break;
                        }
                    }
                }
            }
        }
        return counter;
    }

    private static Integer getBitCount(boolean[][] arr) {
        int counter = 0;
        for(int j = 0; j < 4 ; j++){
            for(int k = 0 ; k < 4;k++){
                if(arr[j][k]){
                    counter++;
                }
            }
        }
        return counter;
    }
}
