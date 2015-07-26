import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TSHOW1 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       Integer T = Integer.parseInt(br.readLine());
       while (T-- > 0) {
         Long N = Long.parseLong(br.readLine());
         solve(N);
       }
  }

  private static void solve(Long n) {

    Long j = n;
    Long block = 2l;
    Long numdigits = 1l;
    while( j > block){
      j = j - block;
      block = block * 2;
      numdigits++;
    }
    StringBuilder str = new StringBuilder();
    j--;
    while(true){
      str.append(j%2);
      j = j/2;
      if(j ==0){
        break;
      }
    }

    str = str.reverse();
    String st = str.toString();
    st = st.replace('0','5');
    st = st.replace('1','6');

    for(int i =st.length(); i<numdigits;i++){
      System.out.print("5");
    }
    System.out.print(st.toString());
    System.out.println();
  }
}
