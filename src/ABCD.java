import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sreedish.ps on 21/10/14.
 */
public class ABCD {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Integer N = Integer.parseInt(br.readLine());
    N = N*2;
    String firstRow = br.readLine();
    StringBuilder secondRow = new StringBuilder();
    for(int i=0;i<N;i+=2){
      String temp = getMissing(firstRow.charAt(i),firstRow.charAt(i+1));
      if(i>1){
        if(temp.charAt(0) == secondRow.charAt(i-1)){
          StringBuffer a = new StringBuffer(temp);
          a = a.reverse();
          temp = a.toString();
        }
      }
      secondRow.append(temp);
    }

    System.out.println(secondRow);
  }

  private static String getMissing(char c1, char c2) {
    String ABCD = "";
    if((c1 != 'A') && (c2 != 'A')){
      ABCD += "A";
    }
    if((c1 != 'B') && (c2 != 'B')){
      ABCD += "B";
    }
    if((c1 != 'C') && (c2 != 'C')){
      ABCD += "C";
    }
    if((c1 != 'D') && (c2 != 'D')){
      ABCD += "D";
    }
    return ABCD;
  }
}
