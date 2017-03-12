import javax.swing.text.StyledEditorKit;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * Created by sreps on 3/4/2017.
 */
public class schedule3 {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String temp[] = br.readLine().split(" ");
            Integer N = Integer.parseInt(temp[0]);
            Integer K = Integer.parseInt(temp[1]);

            temp = br.readLine().split("");
            boolean inp[] = new boolean[N];


            for (int i = 0; i < N; i++) {
                if (temp[i].equals("1")) {
                    inp[i] = true;
                } else {
                    inp[i] = false;
                }
            }

//            /***
//             * brute block
//             */
//
//            Random ran = new Random();
//            Integer N = ran.nextInt(10) + 1;
//            Integer K = ran.nextInt(Math.max(1,N-1));
//
//            boolean inp[] = new boolean[N];
//            System.out.println("Testcase #" + T + " " +"N and K " + N + " " + K);
//
//            for (int i = 0; i < N; i++) {
//                inp[i] = (ran.nextBoolean());
//                if (inp[i]) {
//                    System.out.print(1);
//                } else {
//                    System.out.print(0);
//                }
//            }
//            System.out.println();

            /***
             * end block
             */
          //    Integer bruteForceAnswer = bruteForce(inp, N, K);

            //Integer bruteForceAnswer = solve3(inp, N, K);

            Integer answer = solve3(inp,N,K);

//            System.out.println(answer + " " + bruteForceAnswer);
//            if (answer != bruteForceAnswer) {/
//                System.out.println("Problem");
//                String temp2 = br.readLine();
//            }

          //  System.out.println(bruteForceAnswer);
            System.out.println(answer);

        }
    }

    private static Integer solve3(boolean[] inp, Integer N, Integer K) {
        if (oneFlip(inp, N, K)) {
            return 1;
        }

        if (K == 1) {
            return bruteForce(inp, N, K);
        }

        //calculate size
        Integer size[] = new Integer[N + 1];
        for (int i = 0; i <= N; i++) {
            size[i] = 0;
        }

        int cont = 1;
        int max = -1;
        for (int i = 1; i < N; i++) {
            if (inp[i] == inp[i - 1]) {
                cont++;
            } else {
                size[cont]++;
                if (cont > max) {
                    max = cont;
                }
                cont = 1;
            }
        }
        size[cont]++;
        if (cont > max) {
            max = cont;
        }

        //check for possible minimum starting from 2 to max
        int possible = 2;
        while (possible < max) {
            if(checkPossible(possible,size,inp,N,K, max)){
                return possible;
            }
            possible++;
        }
        return possible;
    }

    private static boolean checkPossible(int possible, Integer[] sizeArray, boolean[] inp, Integer N, Integer K, Integer max) {


        for(int size = max ; size > possible ; size--){
            if(K.compareTo(0) <= 0){
                return false;
            }

            if (sizeArray[size].compareTo(0) == 0) {
                continue;
            }

            if(minimumKNeeded(size,sizeArray[size], possible).compareTo(K) <=0  ){
                // update main size
                sizeArray[possible] += ((size/(possible + 1)) * sizeArray[size]);
                // update left over size
                int remaining = size % (possible + 1);
                sizeArray[remaining] += sizeArray[size];
            }

        }


        return true;
    }

    private static Integer minimumKNeeded(int size, Integer parts, int possible) {
        return (size/(possible + 1)) * parts;
    }

    private static boolean oneFlip(boolean[] inp, Integer N, Integer K) {
        int flips = 0;
        for (int i = 0; i < N; i++) {
            if (i % 2 == 0 && inp[i]) {
                flips++;
            }

            if (i % 2 == 1 && !inp[i]) {
                flips++;
            }
        }

        if (flips <= K) {
            return true;
        }

        flips = 0;
        for (int i = 0; i < N; i++) {
            if (i % 2 == 1 && inp[i]) {
                flips++;
            }

            if (i % 2 == 0 && !inp[i]) {
                flips++;
            }
        }

        if (flips <= K) {
            return true;
        }


        return false;
    }


    private static int solve2(boolean[] inp, Integer N, Integer K) {
        int flips = 0;
        for (int i = 0; i < N; i++) {
            if (i % 2 == 0 && inp[i]) {
                flips++;
            }

            if (i % 2 == 1 && !inp[i]) {
                flips++;
            }
        }

        if (flips <= K) {
            return 1;
        }

        flips = 0;
        for (int i = 0; i < N; i++) {
            if (i % 2 == 1 && inp[i]) {
                flips++;
            }

            if (i % 2 == 0 && !inp[i]) {
                flips++;
            }
        }

        if (flips <= K) {
            return 1;
        }

        if (K == 1) {
            return bruteForce(inp, N, K);
        }

        Integer size[] = new Integer[N + 1];
        for (int i = 0; i <= N; i++) {
            size[i] = 0;
        }

        int cont = 1;
        int max = -1;
        for (int i = 1; i < N; i++) {
            if (inp[i] == inp[i - 1]) {
                cont++;
            } else {
                size[cont]++;
                if (cont > max) {
                    max = cont;
                }
                cont = 1;
            }
        }
        size[cont]++;
        if (cont > max) {
            max = cont;
        }

        int answer = -1;
        boolean flag = false;
        if (K == 2) {
            flag = true;
        }
        for (int i = max; i >= 2; i--) {
            if (i == 2) {
                answer = 2;
                break;
            }
            if (size[i] == 0) {
                continue;
            }
            if (size[i] <= K) {

                if (K == 2 && size[i] == 1 && flag) {
                    answer = bruteForce(inp, N, 2);
                    break;
                    //special case
//                        int minimum = 0;
//                        if (i % 3 == 0) {
//                            minimum = i + i % 3;
//                            minimum /= 3;
//                        } else {
//                            minimum = i + 3 - (i % 3);
//                            minimum /= 3;
//                            minimum -= 1;
//                        }
//
//                        boolean flag = false;
//                        for (int j = i-1 ; j > minimum; j--) {
//                            if (size[j] > 0) {
//                                flag = true;
//                            }
//                        }
//
//                        if (!flag) {
//                            answer = minimum;
//                            break;
//                        }
                }

                int nextBig = getNExtBig(size, i);
                if (nextBig <= (i / 2)) {
                    K -= size[i];
                    if (i % 2 == 0) {
                        size[(i) / 2] += (size[i]);
                        size[(i / 2) - 1] += (size[i]);
                    } else {
                        size[(i - 1) / 2] += (size[i] * 2);
                    }
                } else {
                    System.out.println("problem found");
                }

            } else {
                answer = i;
                break;
            }
            answer = i;
        }
        return answer;
    }

    private static int getNExtBig(Integer[] size, int i) {

        while (--i >= 2) {
            if (size[i].compareTo(0) > 0) {
                return i;
            }
        }

        return -1;
    }

    private static int solve(boolean[] inp, Integer N, Integer K) {
        int flips = 0;
        for (int i = 0; i < N; i++) {
            if (i % 2 == 0 && inp[i]) {
                flips++;
            }

            if (i % 2 == 1 && !inp[i]) {
                flips++;
            }
        }

        if (flips <= K) {
            return 1;
        }

        flips = 0;
        for (int i = 0; i < N; i++) {
            if (i % 2 == 1 && inp[i]) {
                flips++;
            }

            if (i % 2 == 0 && !inp[i]) {
                flips++;
            }
        }

        if (flips <= K) {
            return 1;
        }

        Integer size[] = new Integer[N + 1];
        for (int i = 0; i <= N; i++) {
            size[i] = 0;
        }

        int cont = 1;
        int max = -1;
        for (int i = 1; i < N; i++) {
            if (inp[i] == inp[i - 1]) {
                cont++;
            } else {
                size[cont]++;
                if (cont > max) {
                    max = cont;
                }
                cont = 1;
            }
        }
        size[cont]++;
        if (cont > max) {
            max = cont;
        }

        int answer = -1;
        boolean flag = false;
        if (K == 2) {
            flag = true;
        }
        for (int i = max; i >= 2; i--) {
            if (i == 2) {
                answer = 2;
            }
            if (size[i] == 0) {
                continue;
            }
            if (size[i] <= K) {

                if (K == 2 && size[i] == 1 && flag) {
                    answer = bruteForce(inp, N, 2);
                    break;
                    //special case
//                        int minimum = 0;
//                        if (i % 3 == 0) {
//                            minimum = i + i % 3;
//                            minimum /= 3;
//                        } else {
//                            minimum = i + 3 - (i % 3);
//                            minimum /= 3;
//                            minimum -= 1;
//                        }
//
//                        boolean flag = false;
//                        for (int j = i-1 ; j > minimum; j--) {
//                            if (size[j] > 0) {
//                                flag = true;
//                            }
//                        }
//
//                        if (!flag) {
//                            answer = minimum;
//                            break;
//                        }
                }

                K -= size[i];
                if (i % 2 == 0) {
                    size[(i) / 2] += (size[i]);
                    size[(i / 2) - 1] += (size[i]);
                } else {
                    size[(i - 1) / 2] += (size[i] * 2);
                }
            } else {
                answer = i;
                break;
            }
            answer = i;
        }
        return answer;
    }

    private static int checkSpecial(Integer[] size, int index, Integer N) {
        int block = index + index % 3;
        block /= 3;

        for (int i = index; i >= block; i--) {
            if (size[i] > 0) {

            }
        }
        size[block - 1] += 2;

        return 0;
    }


    public static int bruteForce(boolean arr[], int N, int K) {
        if (K == 0) {
            return score(arr, N);
        }
        int minimum = N + 1;
        for (int i = 0; i < N; i++) {
            arr[i] = !arr[i];
            minimum = Math.min(minimum, bruteForce(arr, N, K - 1));
            arr[i] = !arr[i];
        }
        minimum = Math.min(minimum, score(arr, N));
        return minimum;
    }

    private static int score(boolean[] inp, int N) {
        int cont = 1;
        int max = -1;
        for (int i = 1; i < N; i++) {
            if (inp[i] == inp[i - 1]) {
                cont++;
            } else {
                if (cont > max) {
                    max = cont;
                }
                cont = 1;
            }
        }
        if (cont > max) {
            max = cont;
        }
        return max;
    }


}
