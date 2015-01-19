import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by sreedish.ps on 15/10/14.
 */

class TestClass {
    public static void main(String args[] ) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
            line = br.readLine();
            Long K = Long.parseLong(line);
            Long tempK = K;
            Long threePower = 3L;
            int numDigits = 0;
            while(true){
                if(tempK <= threePower){
                    break;
                }
                tempK -= threePower;
                threePower*=3;
                numDigits++;
            }
            StringBuilder answer = convertBase3(tempK-1);
            //padding
            if(answer.length() <= numDigits){
                String zero = new String("");
                while (numDigits >= answer.length()){
                    zero = zero + "0";
                    numDigits--;
                }
                answer.insert(0,zero);
            }
            System.out.println(answer.toString().replaceAll("2","4").replaceAll("1","3").replaceAll("0","2"));
            //System.out.println(bruteForce(K));
        }

    }

    private static Long bruteForce(Long k) {
        int i =0;
        Long num = 0L;
        while(true){
            if(i == k){
                num--;
                break;
            }
            String temp = num.toString();
            temp = temp.replace("2","").replace("3","").replace("4","");
            if(temp.length() == 0){
                i++;
            }
            num++;
        }
        return num;
    }

    private static StringBuilder convertBase3(Long i) {
        StringBuilder answer = new StringBuilder();
        while(i > 0){
            answer.append(i % 3);
            i = i/3;
        }
        return answer.reverse();
    }
}
