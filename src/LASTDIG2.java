import java.io.*;
import java.math.BigInteger;
public class LASTDIG2{
public static void main(String[] args)throws IOException{
BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
int N=Integer.parseInt(in.readLine()),q[][]={{},{},{6,2,4,8},{1,3,9,7},{6,4,6,4},{},{},{1,7,9,3},{6,8,4,2},{1,9,1,9}},m;
while(N-->0){
String temp[]=in.readLine().split(" ");
Long a=truncate(temp[0]);
  Long b=Long.parseLong(temp[1]);
  int ans;
  if(b==0){ans=1;}else if(a==0||a==1||a==6||a==5){ans=a.intValue();}else{m=(int)(b%4);ans=q[a.intValue()][m];}
System.out.println(ans);
}
}
private static Long truncate(String s){
BigInteger temp=new BigInteger(s);
return temp.mod(new BigInteger("10")).longValue();
}
}