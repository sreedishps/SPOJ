import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Created by sreedish.ps on 11/22/15.
 */
public class SEALINE {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            Integer N = Integer.parseInt(br.readLine());
            String temp[] = br.readLine().split(" ");
            Stack<Integer> main = new Stack<Integer>();
            Stack<Integer> back = new Stack<Integer>();
            Integer moves = 0;

            for (int i = 1; i <= N; i++) {
                Integer inp = Integer.parseInt(temp[i-1]);
                if (inp.equals(0)) {
                    while (!main.isEmpty()) {
                        back.add(main.pop());
                    }
                    main.push(i);
                    while (!back.isEmpty()) {
                        main.add(back.pop());
                    }
                } else {
                    if(!main.isEmpty()){
                        while (!main.peek().equals(inp)) {
                            back.add(main.pop());
                            if(main.isEmpty()){
                                break;
                            }
                        }
                    }

                    if (main.size() > back.size()) {
                        moves += back.size();
                    } else {
                        moves += main.size();
                    }

                    main.push(i);

                    while (!back.isEmpty()) {
                        main.add(back.pop());
                    }
                }
//                System.out.println(moves);
            }

            System.out.println(moves);


        }
    }
}
