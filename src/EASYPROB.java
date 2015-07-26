/**
 * Created by sreedish.ps on 15/01/15.
 */
public class EASYPROB {
  public static void main(String[] args) {

    System.out.println("137="+solve(137));
    System.out.println("1315=" + solve(1315));
    System.out.println("73="+solve(73));
    System.out.println("136="+solve(136));
    System.out.println("255="+solve(255));
    System.out.println("1384="+solve(1384));
    System.out.println("16385="+solve(16385));
  }

  private static String solve(int i) {
    int limit = 32768;
    String temp = "";
    while (i > 0) {
      while (i >= limit) {
        temp += printit(limit);
        temp += "+";
        i = i - limit;
      }
      limit = limit / 2;
    }
    return temp.substring(0,temp.length()-1);
  }

  private static String printit(int num) {
    if (num == 2) {
      return "2";
    }
    if (num == 1) {
      return "2(0)";
    }
    return "2(" + solve((int)(Math.log(num) / Math.log(2))) + ")";
  }
}
