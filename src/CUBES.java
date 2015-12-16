/**
 * Created by sreedish.ps on 11/23/15.
 */
public class CUBES {
    public static void main(String[] args) {
        for (int i = 2; i <= 100; i++) {
            for (int j = 2; j <= 100 ; j++) {
                for (int k = j; k <= 100 ; k++) {
                    for (int l = k; l <= 100 ; l++) {
                        if(check(i,j,k,l)){
                            System.out.println("Cube = "+i+", Triple = ("+j+","+k+","+l+")");
                        }
                    }
                }
            }
        }
    }

    private static boolean check(int i, int j, int k, int l) {
        if((i*i*i)==(j*j*j + k*k*k + l*l*l)){
            return true;
        }
        return false;
    }
}
