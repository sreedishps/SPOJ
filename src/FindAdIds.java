import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

/**
 * Created by sreps on 2/22/2017.
 */
public class FindAdIds {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("C:\\users\\sreps\\desktop\\PageDidNotLoadTabSeparated.txt"));
        BufferedReader br2 = new BufferedReader(new FileReader("C:\\users\\sreps\\desktop\\404.txt"));

        HashSet<String> hm = new HashSet<>();
        HashSet<String> hm2 = new HashSet<>();
        try {
            String line = br2.readLine();

            while (line != null) {
                hm.add(line);
                line = br2.readLine();
            }

        } finally {
            br2.close();
        }

        try {
            String line = br.readLine();
            while (line != null) {
                if (hm.contains((line.split("\t")[6]))) {
                    hm2.add(line.split("\t")[2]);
                }
                line = br.readLine();
            }

        } finally

        {
            br.close();
        }

        for(String adId : hm2){
            System.out.println(adId);
        }
    }
}
