import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NY10A {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Integer T = Integer.parseInt(br.readLine());
    while(T-->0){
      Integer N = Integer.parseInt(br.readLine());
      String seq = br.readLine();
      System.out.println(N+" "+solve(seq));
    }
  }

  private static String solve(String seq) {
    char arr[] = seq.toCharArray();
    int[] ans = new int[8];
    for(int i=0;i<38;i++){
      String temp = new String(arr[i]+""+arr[i+1]+""+arr[i+2]);
      if (temp.equals("TTT")) {
        ans[0]++;
      } else if (temp.equals("TTH")) {
        ans[1]++;
      } else if (temp.equals("THT")) {
        ans[2]++;
      } else if (temp.equals("THH")) {
        ans[3]++;
      } else if (temp.equals("HTT")) {
        ans[4]++;
      } else if (temp.equals("HTH")) {
        ans[5]++;
      } else if (temp.equals("HHT")) {
        ans[6]++;
      } else if (temp.equals("HHH")) {
        ans[7]++;
      }
    }
    StringBuilder str = new StringBuilder();
    for (int i = 0; i < 8; i++) {
      str.append(ans[i]);
      if (i != 7) {
        str.append(" ");
      }
    }
    return str.toString();
  }
}
