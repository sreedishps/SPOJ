import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Random;

public class GCD2 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Integer N = Integer.parseInt(br.readLine());
    while (N-- > 0) {
      String temp[] = br.readLine().split(" ");
      Integer A = Integer.parseInt(temp[0]);
      BigInteger B = new BigInteger(temp[1]);
      if(A.equals(0)){
        System.out.println("0");
        continue;
      }

      Random randomGenerator = new Random();
      while (true) {
        Integer bb = B.mod(new BigInteger(A+"")).intValue();
        long gcd1 = (gcd1(A, bb));
        long big_made_small = specialMode(B.toString(), A);
        long gcd2 = gcd2(A, big_made_small);

        if(gcd1 != gcd2){
          System.out.println(A+" " +bb);
          System.out.println("gcd1 "+gcd1);
          System.out.println("gcd2 "+gcd2);
          break;
        }
        else{
          System.out.println("PASS "+A+" "+B);
        }
        A = randomGenerator.nextInt(10000000);
        B = new BigInteger(randomGenerator.nextInt(10000000)+"");
      }



    }


  }

  static int gcd1(int a, int b)
  {
  	if (b==0)
  		return a;
  	else
  		return gcd1(b,a%b);
  }


  static long specialMode(String big,long small){
      long remainder = 0;
      for (int index = 0; index < big.length(); index++){
          if(remainder >= small){
              remainder = remainder % small;
          }
            remainder = remainder * 10;
              remainder +=  Integer.parseInt(big.charAt(index)+ "");

      }
      return remainder % small;
  }

  static long gcd2(long A,long B){
      if(B == 0 ){
          return A;
      }
      return gcd2(B,A % B);
  }

}
