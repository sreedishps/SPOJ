import java.util.Scanner;

/**
 * Created by sreedish.ps on 15/05/15.
 */
public class WILLITST {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Long num = sc.nextLong();
    if(num <= 1L){
      num = 2L;
    }
    while(num % 2 == 0){
      num = num /2;
    }
    if(num == 1){
      System.out.println("TAK");
    }else {
      System.out.printf("NIE");
    }
  }
}
