import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Created by sreedish.ps on 11/1/15.
 */
public class ABCDEF {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.parseInt(br.readLine());
        Integer input[] = new Integer[N];
        for(int i = 0;i<N;i++){
            input[i] = Integer.parseInt(br.readLine());
        }

        HashMap<Integer,Integer> LHS = new HashMap();
        HashMap<Integer,Integer> RHS = new HashMap();

        for(int i = 0;i<N;i++){
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    Integer lhs = input[i]* input[j] + input[k];
                    increment(LHS,lhs);
                    if(!input[k].equals(0)){
                        Integer rhs = (input[i] + input[j]) * input[k];
                        increment(RHS,rhs);
                    }
                }
            }
        }

        Integer answer = 0;
        for (Integer lhs : LHS.keySet()) {
            Integer rhs = RHS.get(lhs);
            if(rhs !=null){
                answer += (rhs * LHS.get(lhs));
            }
        }

        System.out.println(answer);
    }

    private static void increment(HashMap<Integer, Integer> LHS, Integer lhs) {
        if(LHS.get(lhs) == null){
            LHS.put(lhs,1);
            return;
        }
        LHS.put(lhs, LHS.get(lhs) + 1);
    }
}
