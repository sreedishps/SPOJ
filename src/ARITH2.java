import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ARITH2 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Integer T = Integer.parseInt(br.readLine());
    String s;
    while (T > 0) {
      s = br.readLine();
      s = br.readLine();
      System.out.println(solve(s));
      T--;
    }
  }

  private static long solve(String str) {

    long result = stripFirstOperand(str);
    str   = nullifyFirstArgstrument(str);
    char bufferopreator = ' ';
    int i = 0;
    long operand = 0;
    while (true) {
      char s = str.charAt(i);
      i++;
      if (space(s)) {
        continue;
      } else if (equalto(s)) {
        result = calculate(result, operand, bufferopreator);
        operand = 0;
        break;
      } else if (operator(s)) {
        if(' ' != bufferopreator) {
        result = calculate(result, operand, bufferopreator);
          operand = 0;
        bufferopreator = s; }
        else {
          bufferopreator = s;
        }
      } else { // operand
        operand = operand * 10 + Integer.parseInt(s + "");
      }
    }
    return result;
  }

  private static String nullifyFirstArgstrument(String str) {
    char arr[] = str.toCharArray();
    int i =0;
    while(true){
      if(operator(arr[i]))  {
        return new String(arr);
      }   if(space(arr[i])){
        i++;
        continue;
      }      else {
        arr[i] = ' ';
        i++;
      }
    }
  }


  private static boolean operator(char a) {
    if (a == '*' || a == '/' || a == '+' || a == '-') {
      return true;
    }
    return false;
  }

  private static boolean equalto(char s) {
    return s == '=';
  }

  private static boolean space(char s) {
    return s == ' ';
  }

  private static long calculate(long a, long b, char s) {
    switch (s) {
      case '*':
        return a * b;
      case '/':
        return a / b;
      case '+':
        return a + b;
      case '-':
        return a - b;
    }
    return 0;
  }

  private static long stripFirstOperand(String str) {
    int i = 0;
    long operand = 0;
    while (true) {
      if (space(str.charAt(i))) {
        i++;
        continue;
      }
      if(equalto(str.charAt(i))){
        return  operand;
      }
      if (!operator(str.charAt(i))) {
        operand = operand * 10 + Integer.parseInt(str.charAt(i) + "");
      } else  {
        return operand;
      }
      i++;
    }

  }
}