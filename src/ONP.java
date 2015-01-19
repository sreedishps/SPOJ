import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Created by sreedish.ps on 11/01/15.
 */
public class ONP {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();

    Integer T = Integer.parseInt(s);

    while(T >0){
      T--;
      s = br.readLine();
      Stack<Character> stack = new Stack<Character>();

      StringBuilder op = new StringBuilder();

      for(int i=0;i<s.length();i++){
       char current = s.charAt(i);
        if(current  >= 'a' && current <= 'z'){
          op.append(current);
          continue;
        }
        else if(current == '('){
          stack.push(current);
          continue;
        }
        else if(current == ')'){
          while(true){
           char temp = stack.pop();
            if(temp == '('){
              break;
            }else{
              op.append(temp);
            }
          }
          continue;
        }

        else{
            while (true){
              if(stack.isEmpty()){
                stack.push(current);
                break;
              }
              if(!currentPrecedenceGreaterThanTop(current,stack.peek())){
                op.append(stack.pop());
              }else{
                stack.push(current);
                break;
              }
            }
            continue;
          }

      }
      while (!stack.empty()){
        op.append(stack.pop());
      }
      System.out.println(op.toString());
    }
  }

  private static boolean currentPrecedenceGreaterThanTop(char current, Character peek) {
    String prec = "(+-*/^)";
    int cur = prec.indexOf(current);
    int top = prec.indexOf(peek);
    return (cur>top);
  }
}
