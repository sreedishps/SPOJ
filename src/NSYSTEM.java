import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sreedish.ps on 10/14/15.
 */
public class NSYSTEM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer T = Integer.parseInt(br.readLine());
        while (T-- > 0){
            String temp[] = br.readLine().split(" ");
            String one = temp[0];
            String two = temp[1];
            System.out.println(add(one,two));
        }
    }

    private static String add(String one, String two) {
        StringBuilder ans = new StringBuilder("");
        int carry = 0 ;
        int m,c,x,i;

        carry = solve(one,two,'i',carry,ans);
        carry = solve(one,two,'x',carry,ans);
        carry = solve(one,two,'c',carry,ans);
        solve(one,two,'m',carry,ans);

        return ans.toString();
    }

    private static int solve(String one , String two,char pos, int carry,StringBuilder solve){
        int ans = getValue(one,pos) + getValue(two,pos) + carry;

        carry = (ans > 9)? 1 : 0;
        ans = ans%10;

        if(ans == 0){
            //do nothing
        }else if(ans == 1){
            solve.insert(0,pos);
        } else {
            solve.insert(0,ans+""+pos);
        }
        return carry;
    }

    private static int getValue(String str, char val) {
        if(!str.contains(val+"")){
            return 0;
        }
        int pos = str.indexOf(val) -1 ;
        if(pos == -1){
            return 1;
        }
        if (str.charAt(pos) >= '2' && str.charAt(pos) <= '9'){
            return str.charAt(pos) - '0' ;
        }
        return 1;
    }


}
