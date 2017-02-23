import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

/**
 * Created by sreedish on 15/11/16.
 */
public class CF379C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp[] = br.readLine().split(" ");

        Long N = Long.parseLong(temp[0]);
        Long M = Long.parseLong(temp[1]);
        Long K = Long.parseLong(temp[2]);

        temp = br.readLine().split(" ");
        Long X = Long.parseLong(temp[0]);
        Long S = Long.parseLong(temp[1]);

        Long Mtime[] = new Long[M.intValue()];
        Long Mcost[] = new Long[M.intValue()];

        temp = br.readLine().split(" ");
        String temp2[] = br.readLine().split(" ");

        for(int i=0;i<M;i++){
            Mtime[i] = Long.parseLong(temp[i]);
            Mcost[i] = Long.parseLong(temp2[i]);
        }

        Long Ktime[] = new Long[K.intValue()];
        Long Kcost[] = new Long[K.intValue()];

        temp = br.readLine().split(" ");
        temp2 = br.readLine().split(" ");

        for(int i=0;i<K;i++){
            Ktime[i] = Long.parseLong(temp[i]);
            Kcost[i] = Long.parseLong(temp2[i]);
        }

        Long minTime = N * X;

        //case only K

        if(getMaximumInstant(Kcost, Ktime , 0, K.intValue() - 1 , S).compareTo(N) >= 0 ){
            minTime = 0L;
        }

        for(int i =0 ; i< M ; i++){
            if(Mcost[i].compareTo(S) > 0){
                continue;
            }

            if(minTime.compareTo(0L) == 0){
                break;
            }

            Long remainingMoney = S - Mcost[i];

            Long maximumInstant = getMaximumInstant(Kcost,Ktime, 0, K.intValue() -1, remainingMoney);

            Long currentTIme = 0L;

            if(maximumInstant.compareTo(N) >= 0){
                currentTIme = 0L;
            }else {
                currentTIme = (N - maximumInstant) * Mtime[i];
            }

            if(minTime.compareTo(currentTIme) > 0){
                minTime = currentTIme;
            }

        }

        System.out.println(minTime);

    }

    private static Long getMaximumInstant(Long[] kcost, Long[] ktime, Integer low , Integer high, Long remainingMoney) {
        if(remainingMoney.compareTo(kcost[high]) >= 0  ){
            return ktime[high];
        }

        if(kcost[low].compareTo(remainingMoney) > 0){
            return 0L;
        }

        Integer mid = low + (high - low) / 2 ;

        if(remainingMoney.compareTo(kcost[mid+1]) >= 0){
            return getMaximumInstant(kcost,ktime,mid+1,high,remainingMoney);
        }
        else {
            return  getMaximumInstant(kcost,ktime,low,mid,remainingMoney);
        }
    }
}
