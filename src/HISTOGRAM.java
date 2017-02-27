import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Stack;

/**
 * Created by sreedish on 27/2/17.
 */
public class HISTOGRAM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String temp[] = br.readLine().split(" ");
            Integer N = Integer.parseInt(temp[0]);
            if(N.equals(0)){
                break;
            }

            Long input[] = new Long[N];

            for(int i =0;i<N ;i++){
                input[i] = Long.parseLong(temp[i+1]);
            }

            Long areaMax = -1L;

            int i = 0;
            Stack<Integer> stk = new Stack();

            while (i < N ) {

                if(stk.isEmpty()){
                    stk.push(i);
                    i++;
                    continue;
                }

                if(input[i].compareTo(input[stk.peek()]) >= 0 ){
                    stk.push(i);
                    i++;
                    continue;
                }

                // start popping until we find a less element of stack is empty

                while (!stk.isEmpty() && input[i].compareTo(input[stk.peek()]) < 0  ){
                    int current = stk.pop();

                    if(stk.isEmpty()){
                        Long area = input[current];
                        if(area.compareTo(areaMax) > 0){
                            areaMax = area;
                        }
                        continue;
                    }

                    int leftindex = stk.peek().intValue() + 1;
                    int rightIndex = i -1 ;

                    Long area = input[current] * (rightIndex - leftindex + 1);

                    if(area.compareTo(areaMax) > 0){
                        areaMax = area;
                    }
                }

            }

            int counter = 0;
            int index = -1;
            
            while (!stk.isEmpty()){
                index = stk.pop();
                counter++;
            }

            Long area = counter * input[index];
            if(area.compareTo(areaMax) > 0){
                areaMax = area;
            }

            System.out.println(areaMax);

        }
    }
}
