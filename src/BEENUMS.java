import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by sreedish.ps on 03/05/15.
 */
public class BEENUMS {
  public static void main(String[] args) {
    HashSet hs = new HashSet();
    int counter =1;
    for(Long i=1L;i< 1000000000;){
      hs.add(i);
      i = i + counter * 6;
      counter++;
    }
   Scanner sc = new Scanner(System.in);
   while(sc.hasNextLong()){
     Long num = sc.nextLong();
     if(num.equals(-1L)){
       break;
     }
     if(hs.contains(num)){
       System.out.println("Y");
     }else{
       System.out.println("N");
     }
   }
  }
}
