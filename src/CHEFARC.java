import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;

/**
 * Created by sreps on 7/4/2016.
 */
public class CHEFARC {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String temp[] = br.readLine().split(" ");
            Integer N = Integer.parseInt(temp[0]);
            Integer M = Integer.parseInt(temp[1]);
            Integer k1 = Integer.parseInt(temp[2]);
            Integer k2 = Integer.parseInt(temp[3]);

            Integer matrix1[][] = new Integer[N][M];
            Integer matrix2[][] = new Integer[N][M];

            for (int i = 0; i < N; i++) {
                temp = br.readLine().split(" ");
                for (int j = 0; j < M; j++) {
                    if (Integer.parseInt(temp[j]) == 1) {
                        matrix1[i][j] = -1;
                        matrix2[i][j] = -1;
                    } else {
                        matrix1[i][j] = 0;
                        matrix2[i][j] = 0;
                    }
                }
            }




            int currentWave = 0;

//            Integer[][] test = new Integer[10][10];
//            for(int i = 0; i< 10; i++){
//                for (int j = 0; j < 10; j++) {
//                    test[i][j] = 0;
//                }
//            }

//            test[3][3] = 1;
//            test[3][2] = -1;
//
//            propagate(test,10,10,1,2);
//            propagate(test,10,10,2,2);
//            print(test,10,10);

            matrix1[0][0] = 1;
            matrix2[0][M-1] = 1;

            for(currentWave = 1; currentWave < 1010 ; currentWave++){
//                System.out.println(currentWave);
//                print(matrix1,N,M);
//                System.out.println();
//                print(matrix2,N,M);

                boolean val1 = propagate(matrix1,N,M,currentWave,k1);
                boolean val2 = propagate(matrix2,N,M,currentWave,k2);
                if(!val1 &&
                !val2){
                    System.out.println("-1");
                    break;
                }
                if(check(matrix1,matrix2,N,M)){
                    System.out.println(currentWave);
                    break;
                }
            }

        }


    }

    private static boolean check(Integer[][] matrix1, Integer[][] matrix2, Integer N, Integer M) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
               if(matrix1[i][j] > 0 && matrix2[i][j] > 0){
                   return true;
               }
            }
        }
        return false;
    }

    private static boolean propagate(Integer[][] matrix, Integer N, Integer M, int currentWave, int K) {
        boolean returnVl = false;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(matrix[i][j] == currentWave){
                    returnVl = returnVl || wave(matrix,i,j,N,M,K,currentWave);
                }
            }
        }
        return returnVl;
    }

    private static boolean wave(Integer[][] matrix, int i, int j, Integer N, Integer M, int K, int currentwave) {
        int offset = 0;
        boolean returnVal = false;
        for(int row = i - K ; row <= i + K ; row++){
            for(int col = j -offset; col <= j+ offset ; col++ ){
                if(row < 0 || row >= N || col < 0 || col >= M){
                    continue;
                }
                if(matrix[row][col] == 0){
                    matrix[row][col] = currentwave +1;
                    returnVal = true;
                }
            }
            if(row < i ){
                offset++;
            }else {
                offset--;
            }
        }
        return returnVal;
    }


    private static  void print(Integer[][] matrix, int N, int M) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }


}
