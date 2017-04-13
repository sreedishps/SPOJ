import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

/**
 * Created by sreps on 8/17/2016.
 */
public class Diff {
    public static void main(String[] args) {
        BufferedReader br = null;

        try {

            String sCurrentLine;

            br = new BufferedReader(new FileReader("C:\\users\\sreps\\Downloads\\aug1-8.txt"));

            HashSet<String> adQualityMAp = new HashSet<>();
            while ((sCurrentLine = br.readLine()) != null) {
                adQualityMAp.add(sCurrentLine);
              //  System.out.println(sCurrentLine);
            }

            br = new BufferedReader(new FileReader("C:\\users\\sreps\\Downloads\\otherTeam.txt"));

            HashSet<String> otherMAp = new HashSet<>();
            while ((sCurrentLine = br.readLine()) != null) {
                otherMAp.add(sCurrentLine);
              //  System.out.println(sCurrentLine);
            }


            System.out.println("AQ size " + adQualityMAp.size());
            System.out.println("Other size "+otherMAp.size());

            long AqMinusOther = 0;
            long otherMinusAq = 0;
            long interSection = 0;

            for(String temp : adQualityMAp){
                if(otherMAp.contains(temp)){
                    interSection++;
                }else {
                    AqMinusOther++;
                }
            }

            System.out.println("Intersection " + interSection);
            System.out.println(" Aq - other  " + AqMinusOther);

            AqMinusOther = 0;
            otherMinusAq = 0;
            interSection = 0;

            for(String temp : otherMAp){
                if(adQualityMAp.contains(temp)){
                    interSection++;
                }else {
                   otherMinusAq++;
                }
            }

            System.out.println("Intersection " + interSection);
            System.out.println(" Other - Aq  " + otherMinusAq);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }
}
