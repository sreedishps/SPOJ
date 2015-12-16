import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class Main {
    public int getSum(int N, int MOD) {
        return 1;
    }

    public static void main(String[] args) {
        Main obj = new Main();
        System.out.println(obj.possible(50, 1000));
    }

    public String possible(int n, int s)
    {
        HashSet<Integer> possible = new HashSet();

        int j = 0;
        for(int i = n-2; i >= 1 ; i--){
            possible.add((i * (i+1)/2) + j);
            j++;
        }

        if(possible.contains(s)){
            return "Possible";
        }else {
            return "Impossible";
        }

    }


    public double calc(int amount, String fromUnit, String toUnit) {
        if (fromUnit.equals("in")) {
            if (toUnit.equals("in")) {
                return amount;
            } else if (toUnit.equals("ft")) {
                return amount / 12.0;
            } else if (toUnit.equals("yd")) {
                return (amount / 12.0) / 3;
            } else if (toUnit.equals("mi")) {
                return ((amount / 12.0) / 3) / 1760;
            }
        } else if (fromUnit.equals("ft")) {
            if (toUnit.equals("in")) {
                return amount * 12.0;
            } else if (toUnit.equals("ft")) {
                return amount;
            } else if (toUnit.equals("yd")) {
                return amount / 3;
            } else if (toUnit.equals("mi")) {
                return (amount / 3) / 1760;
            }
        } else if (fromUnit.equals("yd")) {
            if (toUnit.equals("in")) {
                return amount * 3 * 12;
            } else if (toUnit.equals("ft")) {
                return amount * 3.0;
            } else if (toUnit.equals("yd")) {
                return amount;
            } else if (toUnit.equals("mi")) {
                return amount / 1760.0;
            }
        } else if (fromUnit.equals("mi")) {
            if (toUnit.equals("in")) {
                return amount * 1760 * 3 * 12;
            } else if (toUnit.equals("ft")) {
                return amount * 1760 * 3;
            } else if (toUnit.equals("yd")) {
                return amount * 1760.0;
            } else if (toUnit.equals("mi")) {
                return amount;
            }
        }
        return amount;
    }

}
