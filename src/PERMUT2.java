import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by sreedish.ps on 15/05/15.
 */
public class PERMUT2 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Integer N;
    while ((N = sc.nextInt()) != 0) {
      boolean flag = false;
      HashMap hm = new HashMap();
        for(int i =1;i<= N;i++){
        int num = sc.nextInt();
        if(i == num){
          continue;
        }
        if(hm.containsKey(num)){
          if((Integer)hm.get(num) == i){
            hm.remove(num);
            continue;
          }else {
            flag = true;
            System.out.println("not ambiguous");
            break;
          }
        }else {
          hm.put(i,num);
        }
      }

      if(!flag)
      System.out.println("ambiguous");

    }

  }
}
