import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by sreps on 7/26/2016.
 */
public class HACKRNDM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp[] = br.readLine().split(" ");

        Integer N = Integer.parseInt(temp[0]);
        Integer K = Integer.parseInt(temp[1]);

        temp = br.readLine().split(" ");

        int arr[] = new int[N];
        for(int i =0;i<N;i++){
            arr[i] = Integer.parseInt(temp[i]);
        }

        int count = 0;
        Arrays.sort(arr);

        for(Integer elem : arr){
            if(Arrays.binarySearch(arr,elem + K) >= 0){
                count++;
            }
        }

        System.out.println(count);
    }
}
